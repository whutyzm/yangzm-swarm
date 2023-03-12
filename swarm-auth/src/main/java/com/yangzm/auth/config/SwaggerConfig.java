package com.yangzm.auth.config;

import com.yangzm.common.config.BaseSwaggerConfig;
import com.yangzm.common.domain.SwaggerProperties;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * description ()
 *
 * @author create by yangzm
 * @date 2023/3/11
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {
    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("com.yangzm.auth.controller")
                .title("认证中心")
                .description("认证中心相关接口文档")
                .contactName("yangzm")
                .version("1.0")
                .enableSecurity(true)
                .build();
    }

    @Bean
    public BeanPostProcessor springfoxHandlerProviderBeanPostProcessor() {
        return generateBeanPostProcessor();
    }
}
