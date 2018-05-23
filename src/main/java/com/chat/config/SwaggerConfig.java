package com.chat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger2 配置
 */
@Configuration
@EnableSwagger2//开启Swagger功能
public class SwaggerConfig {
    @Bean
    public Docket createRestDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("api") //定义组
                .apiInfo(apiInfo())//配置说明
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.chat.controller"))//拦截包路径
                .paths(PathSelectors.any()) //拦截接口
                .build();
    }
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("聊天室")
                .description("聊天室")
                .termsOfServiceUrl("920518289@qq.com")
                .version("1.0")
                .build();
    }
}
