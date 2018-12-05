package com.scan.config;
   
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2; 
 
@Configuration
@EnableSwagger2
@ComponentScan(basePackages = {"com.scan.controller"})   
@EnableWebMvc
public class SwaggerConfig extends WebMvcConfigurationSupport {

	@Bean
    public Docket customDocket() {
        //
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("sunlight001", "https://www.baidu.com", "sunlight001@qq.com");
        return new ApiInfo("Blog前台API接口",//大标题 title
                "springmvc-swagger-demo",//小标题
                "0.0.1",//版本
                "www.baidu.com",//termsOfServiceUrl
                contact,//作者
                "sunlight001",//链接显示文字
                "www.baidu.com"//网站链接
        );
    }
	
	  
}