package com.hdjd.grit.config.interceptor;

import com.hdjd.grit.core.ProjectConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: yuan
 * @Date: 2020/3/4 18:27
 * @Version 1.0
 * 登录拦截器
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer   {
    private final SessionInterceptor sessionInterceptor;
    private final ProjectConfig projectConfig;

    @Autowired
    public InterceptorConfig(ProjectConfig projectConfig, SessionInterceptor sessionInterceptor) {
        this.sessionInterceptor = sessionInterceptor;
        this.projectConfig = projectConfig;
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/images/**")
                .addResourceLocations("file:" + System.getProperty("user.dir") + "/images/");
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sessionInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/admin/login")
                .excludePathPatterns("/user/login/**")
                .excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**")
                .excludePathPatterns("/goods/**")
                .excludePathPatterns("/comments")
                .excludePathPatterns("/user/address/**")
                .excludePathPatterns("/orders/**")
                .excludePathPatterns("/announcement/**")
                .excludePathPatterns("/admin/message/**")
                .excludePathPatterns("/wx/message")
                .excludePathPatterns("/battle/**")
                .excludePathPatterns("/images/**");
    }
}
