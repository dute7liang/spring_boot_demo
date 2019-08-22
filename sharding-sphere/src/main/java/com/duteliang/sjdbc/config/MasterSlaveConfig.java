package com.duteliang.sjdbc.config;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSource;

import io.shardingsphere.api.config.rule.MasterSlaveRuleConfiguration;
import io.shardingsphere.shardingjdbc.api.MasterSlaveDataSourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

/**
 * 主从读写分离技术
 * 配置暂时是写死的
 * @author: zl
 * @Date: 2019-1-25 16:58
 */
@SpringBootConfiguration
@ConditionalOnProperty(value = "sharding.jdbc.type",havingValue = "masterSlave")
public class MasterSlaveConfig {

	@Bean
	@Primary
	public DataSource getMasterSlaveDataSource() throws SQLException {
		MasterSlaveRuleConfiguration masterSlaveRuleConfig = new MasterSlaveRuleConfiguration();
		masterSlaveRuleConfig.setName("ds_master_slave");
		masterSlaveRuleConfig.setMasterDataSourceName("ds_master");
		masterSlaveRuleConfig.setSlaveDataSourceNames(Arrays.asList("ds_slave0"));
		Properties properties = new Properties();
		properties.setProperty("sql.show", "true");
		return MasterSlaveDataSourceFactory.createDataSource(createDataSourceMap(), masterSlaveRuleConfig,
				new LinkedHashMap<String, Object>(), properties);
	}

	private Map<String, DataSource> createDataSourceMap() {
		Map<String, DataSource> result = new HashMap<>();
		result.put("ds_master", getDataSource("jdbc:mysql://127.0.0.1:3307/test"));
		result.put("ds_slave0", getDataSource("jdbc:mysql://127.0.0.1:3308/test"));
		return result;
	}

	@Autowired
	private DruidProperties druidProperties;

	/**
	 * 获取对于的dataSource。写死的。 测试
	 * 账号密码是一样的
	 * @param url
	 */
	private DataSource getDataSource(String url){
		DruidDataSource dataSource = new DruidDataSource();
		druidProperties.config(dataSource);
		dataSource.setUrl(url);
		return dataSource;

	}



}
