package com.wizzdi.billing.payment.paypal.client;

import ch.qos.logback.classic.Level;
import com.wizzdi.billing.payment.paypal.client.exceptions.PayPalLoginException;
import com.wizzdi.billing.payment.paypal.client.request.*;
import com.wizzdi.billing.payment.paypal.client.response.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.Collections;

import static com.wizzdi.billing.payment.paypal.client.LoggingInterceptor.LOGGER;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = App.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ActiveProfiles("test")
class SubscriptionClientTest {

    private static final Logger logger = LoggerFactory.getLogger(SubscriptionClientTest.class);
    private SubscriptionClient subscriptionClient;
    private String planId;
    private String productId;

    @Value("${paypal.clientId}")
    private String paypalClientId;
    @Value("${paypal.secret}")
    private String secret;
    @Value("${paypal.test.shopper.email}")
    private String shopperEmail;

    @BeforeAll
    void setUp() throws IOException, PayPalLoginException {
        ch.qos.logback.classic.Logger logger = (ch.qos.logback.classic.Logger)LOGGER;
        logger.setLevel(Level.DEBUG);


        subscriptionClient = new SubscriptionClient(SubscriptionClient.SANDBOX_URL, paypalClientId,secret);
        subscriptionClient.init();

    }

    @Order(1)
    @Test
    void createProduct() {
        String id = System.currentTimeMillis() + "";
        ProductCreate productCreate = new ProductCreate();
        productCreate.setCategory(ProductCategory.SOFTWARE);
        productCreate.setType(ProductType.SERVICE);
        productCreate.setName("test");
        productCreate.setDescription("test service");
        productCreate.setHomeUrl("https://wizzdi.com");

        ResponseEntity<Product> productResponse = subscriptionClient.createProduct(id, productCreate);
        Assertions.assertTrue(productResponse.getStatusCode().is2xxSuccessful());
        Product product = productResponse.getBody();
        Assertions.assertNotNull(product);
        logger.info(product + "");
        this.productId=product.getId();
    }

    @Order(2)
    @Test
    void getProducts() {
        try {
            ResponseEntity<ProductsResponse> products = subscriptionClient.getProducts(10, 1, true);
            Assertions.assertTrue(products.getStatusCode().is2xxSuccessful());
            ProductsResponse productsResponse = products.getBody();
            Assertions.assertNotNull(productsResponse);
            Assertions.assertFalse(productsResponse.getProducts().isEmpty());
            logger.info(productsResponse + "");
        } catch (HttpClientErrorException e) {
            String responseBodyAsString = e.getResponseBodyAsString();
            Assertions.fail(responseBodyAsString);

        }
    }

    @Order(3)
    @Test
    void createPlan() {
        try {
            String requestId = System.currentTimeMillis() + "";
            PlanCreate planCreate = new PlanCreate();
            planCreate.setProductId(productId);
            planCreate.setDescription("test plan");
            planCreate.setName("test plan");
            PaymentPreferences paymentPreferences = new PaymentPreferences();
            paymentPreferences.setAutoBillOutstanding(true);
            paymentPreferences.setSetupFeeFailureAction(SetupFeeFailureAction.CANCEL);
            planCreate.setPaymentPreferences(paymentPreferences);
            BillingCycle billingCycle = new BillingCycle();
            Frequency frequency = new Frequency();
            frequency.setIntervalCount(10);
            frequency.setIntervalUnit(InternalUnit.MONTH);
            billingCycle.setFrequency(frequency);
            billingCycle.setTotalCycles(5);
            billingCycle.setSequence(1);
            billingCycle.setTenureType(TenureType.REGULAR);
            PricingScheme pricingScheme = new PricingScheme();
            pricingScheme.setVersion(1);
            FixedPrice fixedPrice = new FixedPrice();
            fixedPrice.setValue("10");
            fixedPrice.setCurrencyCode("ILS");
            pricingScheme.setFixedPrice(fixedPrice);
            billingCycle.setPricingScheme(pricingScheme);
            planCreate.setBillingCycles(Collections.singletonList(billingCycle));
            ResponseEntity<Plan> planResponseEntity = subscriptionClient.createPlan(requestId, planCreate);
            Assertions.assertTrue(planResponseEntity.getStatusCode().is2xxSuccessful());
            Plan plan = planResponseEntity.getBody();
            Assertions.assertNotNull(plan);
            logger.info(plan + "");
            this.planId = plan.getId();
        } catch (HttpClientErrorException e) {
            String responseBodyAsString = e.getResponseBodyAsString();
            Assertions.fail(responseBodyAsString);

        }
    }

    @Order(4)
    @Test
    void getPlans() {
        ResponseEntity<PlansResponse> plansResponseResponseEntity = subscriptionClient.getPlans(10, 1, true, null, null);
        Assertions.assertTrue(plansResponseResponseEntity.getStatusCode().is2xxSuccessful());
        PlansResponse plansResponse = plansResponseResponseEntity.getBody();
        Assertions.assertNotNull(plansResponse);
        logger.info(plansResponse + "");
    }


    @Order(5)
    @Test
    void createSubscription() {
        try {
            String requestId = System.currentTimeMillis() + "";
            SubscriptionCreate subscriptionCreate = new SubscriptionCreate();
            Subscriber subscriber = new Subscriber();
            subscriber.setEmailAddress(shopperEmail);
            subscriptionCreate.setSubscriber(subscriber);
            subscriptionCreate.setPlanId(planId);
            subscriptionCreate.setStartTime(OffsetDateTime.now());
            ResponseEntity<Subscription> subscriptionClientSubscription = subscriptionClient.createSubscription(requestId, subscriptionCreate);
            Assertions.assertTrue(subscriptionClientSubscription.getStatusCode().is2xxSuccessful());
            Subscription subscription = subscriptionClientSubscription.getBody();
            Assertions.assertNotNull(subscription);
            logger.info(subscription + "");
        } catch (HttpClientErrorException e) {
            String responseBodyAsString = e.getResponseBodyAsString();
            Assertions.fail(responseBodyAsString);

        }
    }

}