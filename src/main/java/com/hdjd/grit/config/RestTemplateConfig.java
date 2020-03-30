package com.hdjd.grit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName:RestTemplateConfig
 * @author: yeqi
 * @create: 2020/3/5 15:25
 * @description
 */

/**
 * RestTemplate配置
 * 这是一种JavaConfig的容器配置，用于spring容器的bean收集与注册，并通过参数传递的方式实现依赖注入。
 * "@Configuration"注解标注的配置类，都是spring容器配置类，springboot通过"@EnableAutoConfiguration"
 * 注解将所有标注了"@Configuration"注解的配置类，"一股脑儿"全部注入spring容器中。
 *
 * @author mht
 *
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.TEXT_PLAIN));
        restTemplate.getMessageConverters().add(converter);
        return restTemplate;
    }

}