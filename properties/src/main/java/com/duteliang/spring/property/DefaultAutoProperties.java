package com.duteliang.spring.property;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Auther: zl
 * @Date: 2018-9-4 20:34
 */
@Component
@Data
@ToString
@ConfigurationProperties(prefix = "duteliang.test")
public class DefaultAutoProperties {

	private String name;

	private Integer age;


}
