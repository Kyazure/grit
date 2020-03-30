package com.hdjd.grit.core.util;

import com.hdjd.grit.core.convert.WxMappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: yuan
 * @Date: 2020/3/14 23:08
 * @Version 1.0
 */
public class RestTemplateUtil {
    public static RestTemplate getInstance() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new WxMappingJackson2HttpMessageConverter());
        return restTemplate;
    }
}
