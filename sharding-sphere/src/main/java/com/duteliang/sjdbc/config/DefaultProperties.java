package com.duteliang.sjdbc.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 默认的配置
 *
 * @author fengshuonan
 * @date 2018-01-07 12:33
 */
@Configuration
public class DefaultProperties {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DruidProperties druidProperties() {
        return new DruidProperties();
    }

}
