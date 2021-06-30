package com.wizzdi.billing.payment.paypal.client;

import com.wizzdi.billing.payment.paypal.client.exceptions.PayPalLoginException;
import com.wizzdi.billing.payment.paypal.client.request.*;
import com.wizzdi.billing.payment.paypal.client.response.*;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.http.client.*;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.*;

import static com.wizzdi.billing.payment.paypal.client.LoggingInterceptor.LOGGER;

public class SubscriptionClient {
    public static final String SANDBOX_URL = "https://api-m.sandbox.paypal.com";
    private static final Logger logger= LoggerFactory.getLogger(SubscriptionClient.class);

    public static final String PAY_PAL_REQUEST_ID = "PayPal-Request-Id";
    private final String url;
    private final String clientId;
    private final String secret;
    private final RestTemplate restTemplate;
    private PayPalToken payPalToken;


    public SubscriptionClient(RestTemplate restTemplate, String url, String clientId, String secret) {
        this.restTemplate = restTemplate;
        this.url = url;
        this.clientId = clientId;
        this.secret = secret;
    }

    public SubscriptionClient(String url, String clientId, String secret) {
        this(getRestTemplate(url), url, clientId, secret);

    }


    private static RestTemplate getRestTemplate(String url) {
        RestTemplate restTemplate;
        if (LOGGER.isDebugEnabled()) {
            ClientHttpRequestFactory factory
                    = new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory());
            restTemplate = new RestTemplate(factory);
        } else {
            restTemplate = new RestTemplate();
        }
        List<ClientHttpRequestInterceptor> interceptors = restTemplate.getInterceptors();
        if (CollectionUtils.isEmpty(interceptors)) {
            interceptors = new ArrayList<>();
        }
        interceptors.add(new LoggingInterceptor());
        restTemplate.setInterceptors(interceptors);
        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(url));
        return restTemplate;
    }

    public void init() throws PayPalLoginException {
        String plainCreds = clientId + ":" + secret;
        byte[] plainCredsBytes = plainCreds.getBytes();
        byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
        String base64Creds = new String(base64CredsBytes);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Creds);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("grant_type", "client_credentials");
        ResponseEntity<PayPalToken> response = restTemplate.exchange("v1/oauth2/token", HttpMethod.POST, new HttpEntity<>(map, headers), PayPalToken.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            PayPalToken body = response.getBody();
            if (body != null) {
                this.payPalToken = body;
                restTemplate.getInterceptors().add((httpRequest, bytes, clientHttpRequestExecution) -> {
                    httpRequest.getHeaders()
                            .setBearerAuth(payPalToken.getAccessToken());
                    return clientHttpRequestExecution.execute(httpRequest, bytes);
                });
                return;
            }

        }
        throw new PayPalLoginException("failed logging in with credentials");
    }

    public ResponseEntity<ProductsResponse> getProducts(int pageSize, int page, boolean totalRequired) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url+"/v1/catalogs/products")

                .queryParam("page_size", pageSize)
                .queryParam("page", page)
                .queryParam("total_required", totalRequired);

        return restTemplate.getForEntity(builder.toUriString(), ProductsResponse.class);

    }

    public ResponseEntity<PlansResponse> getPlans(int pageSize, int page, boolean totalRequired, String planIds, String productId) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url+"/v1/billing/plans")
                .queryParam("page_size", pageSize)
                .queryParam("page", page)
                .queryParam("total_required", totalRequired);
        if (productId != null) {
            builder = builder.queryParam("product_id", productId);
        }
        if (planIds != null) {
            builder.queryParam("plan_ids", planIds);

        }


        return restTemplate.getForEntity(builder.toUriString(), PlansResponse.class);

    }

    public ResponseEntity<Subscription> getSubscription(String subscriptionId) {

        Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("id", subscriptionId);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url+"/v1/billing/subscriptions/{id}")
                .uriVariables(uriVariables);


        return restTemplate.getForEntity(builder.toUriString(), Subscription.class);

    }


    public ResponseEntity<Product> createProduct(String requestId, ProductCreate productCreate) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.add(PAY_PAL_REQUEST_ID, requestId);
        return restTemplate.exchange("v1/catalogs/products", HttpMethod.POST, new HttpEntity<>(productCreate, httpHeaders), Product.class);

    }

    public ResponseEntity<Plan> createPlan(String requestId, PlanCreate planCreate) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.add(PAY_PAL_REQUEST_ID, requestId);
        httpHeaders.add("Prefer", "return=representation");
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        return restTemplate.exchange("v1/billing/plans", HttpMethod.POST, new HttpEntity<>(planCreate, httpHeaders), Plan.class);

    }


    public ResponseEntity<Subscription> createSubscription(String requestId, SubscriptionCreate productCreate) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.add(PAY_PAL_REQUEST_ID, requestId);
        httpHeaders.add("Prefer", "return=representation");
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        return restTemplate.exchange("v1/billing/subscriptions", HttpMethod.POST, new HttpEntity<>(productCreate, httpHeaders), Subscription.class);

    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public String getUrl() {
        return url;
    }

    public String getClientId() {
        return clientId;
    }

    public String getSecret() {
        return secret;
    }
}
