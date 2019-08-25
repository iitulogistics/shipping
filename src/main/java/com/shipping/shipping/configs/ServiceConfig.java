package com.shipping.shipping.configs;

import com.shipping.shipping.services.impl.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {
    @Bean
    @Qualifier("defaultOrderService")
    public DefaultOrdersService defaultOrderService() {
        return new DefaultOrdersService();
    }

    @Bean
    @Qualifier("defaultClientService")
    public DefaultClientService defaultClientService() {
        return new DefaultClientService();
    }

    @Bean
    @Qualifier("defaultProductTypeService")
    public DefaultProductTypeService defaultProductTypeService() {
        return new DefaultProductTypeService();
    }

    @Bean
    @Qualifier("defaultStatusService")
    public DefaultStatusService defaultStatusService() {
        return new DefaultStatusService();
    }
}
