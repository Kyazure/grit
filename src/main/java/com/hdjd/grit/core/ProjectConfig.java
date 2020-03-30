package com.hdjd.grit.core;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:config.properties")
@Data
public class ProjectConfig {
    private static ProjectConfig properties;
    @Value("${project.login.url}")
    private String loginUrl;
    @Value("${project.session.name}")
    private String sessionUserInfoKey;
    @Value("${project.date.format}")
    private String dateFormat;
}
