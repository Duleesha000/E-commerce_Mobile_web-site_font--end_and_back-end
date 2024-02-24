package com.devtechnexus.paymentservice.config;

import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.OAuthTokenCredential;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * PaypalConfig
 * Configuration Bean for PayPal API.
 * <br><br>
 * ALL VALUES ARE STORED IN SECRETS.PROPERTIES FILE.
 * SECRETS.PROPERTIES IS NOT COMMITTED NOR SHARED AS IT CONTAINS SENSITIVE INFORMATION.
 * <br>
 * check out the ReadME.md for more info.
 *
 */
@Configuration
public class PaypalConfig {

    @Value("${PAYPAL_CLIENT_ID}")
    private String clientId;

    @Value("${PAYPAL_CLIENT_SECRET}")
    private String clientSecret;

    @Value("${PAYPAL_MODE}")
    private String mode;

    @Bean
    public Map<String, String> paypalSdkConfig() {
        return Map.of(
                "mode", mode,
                "clientId", clientId,
                "clientSecret", clientSecret
        );
    }

    @Bean
    public OAuthTokenCredential oAuthTokenCredential() {
        return new OAuthTokenCredential(clientId, clientSecret, paypalSdkConfig());
    }

    @Bean
    public APIContext apiContext() throws PayPalRESTException {
        APIContext context = new APIContext(oAuthTokenCredential().getAccessToken());
        context.setConfigurationMap(paypalSdkConfig());
        return context;
    }
}
