package com.url.shortener.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<RateLimitingFilter> rateLimiter(RateLimitingFilter filter) {
        FilterRegistrationBean<RateLimitingFilter> bean =
                new FilterRegistrationBean<>();

        bean.setFilter(filter);

        bean.addUrlPatterns("/api/auth/public/login", "/api/auth/public/register");

        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);

        return bean;
    }
}

