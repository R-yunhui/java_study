package com.ral.admin.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * SwaggerConfig
 * @Description swagger 配置类
 * @author renyunhui
 * @date 2021/2/1 15:50
 * @version 1.0
 */
@Configuration
public class SwaggerConfig {

    @Value("${swagger.enabled}")
    private Boolean enabled;

    @Value("${swagger.title}")
    private String title;

    @Value("${swagger.description}")
    private String description;

    @Value("${swagger.version}")
    private String version;

    @Value("${swagger.contact.url}")
    private String url;

    @Value("${swagger.contact.name}")
    private String name;

    @Value("${swagger.contact.email}")
    private String email;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(enabled)
                .apiInfo(apiInfo())
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.ral"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .description(description)
                .title(title)
                .version(version)
                .contact(new Contact(name, url, email))
                .build();
    }
}
