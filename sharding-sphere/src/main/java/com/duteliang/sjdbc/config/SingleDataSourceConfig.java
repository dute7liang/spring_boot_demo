package com.duteliang.sjdbc.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 单数据源配置
 *
 * @author zl
 * @Date 2017/5/20 21:58
 */
@SpringBootConfiguration
@ConditionalOnProperty(value = "sharding.jdbc.type",havingValue = "single",matchIfMissing = true)
@EnableTransactionManagement
public class SingleDataSourceConfig {

    /**
     * 单数据源连接池配置
     */
    @Bean
    public DruidDataSource dataSource(DruidProperties druidProperties) {
        DruidDataSource dataSource = new DruidDataSource();
        druidProperties.config(dataSource);
        return dataSource;
    }


}

