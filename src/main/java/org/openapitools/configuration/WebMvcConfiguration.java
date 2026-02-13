package org.openapitools.configuration;

import org.openapitools.interceptor.PSUGeoLocationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Web MVC configuration to register PSU-GEO-Location header validation interceptor.
 */
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    
    @Autowired
    private PSUGeoLocationInterceptor psuGeoLocationInterceptor;
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(psuGeoLocationInterceptor)
                .addPathPatterns("/pre-process-consent-creation")
                .addPathPatterns("/validate-consent-access")
                .addPathPatterns("/signing-basket/**")
                .addPathPatterns("/persist-authorized-consent");
    }
}
