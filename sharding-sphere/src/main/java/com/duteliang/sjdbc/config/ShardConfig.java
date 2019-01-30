package com.duteliang.sjdbc.config;

import com.alibaba.druid.pool.DruidDataSource;
import io.shardingsphere.api.config.rule.ShardingRuleConfiguration;
import io.shardingsphere.api.config.rule.TableRuleConfiguration;
import io.shardingsphere.api.config.strategy.InlineShardingStrategyConfiguration;
import io.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 分片 配置
 * @author: zl
 * @Date: 2019-1-28 14:36
 */
@SpringBootConfiguration
@ConditionalOnProperty(value = "sharding.jdbc.type",havingValue = "shard")
public class ShardConfig {


	public DataSource getShardingDataSource() throws SQLException {
		ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
		shardingRuleConfig.getTableRuleConfigs().add(getOrderTableRuleConfiguration());
		shardingRuleConfig.getTableRuleConfigs().add(getOrderItemTableRuleConfiguration());
		shardingRuleConfig.getBindingTableGroups().add("t_order, t_order_item");
		shardingRuleConfig.getBroadcastTables().add("t_config");
		shardingRuleConfig.setDefaultDatabaseShardingStrategyConfig(
				new InlineShardingStrategyConfiguration("user_id", "ds${user_id % 2}"));
//		shardingRuleConfig.setDefaultTableShardingStrategyConfig(
//				new StandardShardingStrategyConfiguration("order_id", new ModuloShardingTableAlgorithm()));
		return ShardingDataSourceFactory.createDataSource(createDataSourceMap(), shardingRuleConfig
					,new LinkedHashMap<String, Object>(), new Properties());
	}

	public TableRuleConfiguration getOrderTableRuleConfiguration() {
		TableRuleConfiguration result = new TableRuleConfiguration();
		result.setLogicTable("t_order");
		result.setActualDataNodes("ds${0..1}.t_order${0..1}");
		result.setKeyGeneratorColumnName("order_id");
		return result;
	}

	public TableRuleConfiguration getOrderItemTableRuleConfiguration() {
		TableRuleConfiguration result = new TableRuleConfiguration();
		result.setLogicTable("t_order_item");
		result.setActualDataNodes("ds${0..1}.t_order_item${0..1}");
		return result;
	}

	public Map<String, DataSource> createDataSourceMap() {
		Map<String, DataSource> result = new HashMap<>();
		result.put("ds0", getDataSource("jdbc:mysql://127.0.0.1:3307/test"));
		result.put("ds1", getDataSource("jdbc:mysql://127.0.0.1:3309/test"));
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
