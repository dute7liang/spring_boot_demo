package com.duteliang.spring;

import com.duteliang.spring.property.AutoProperties;
import com.duteliang.spring.property.DefaultAutoProperties;
import com.duteliang.spring.property.DefaultProperties;
import com.duteliang.spring.property.SourceProperties;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @Description:
 * @Auther: zl
 * @Date: 2018-8-6 17:03
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes=PropertyApplication.class)
@Slf4j
public class PropertyApplicationTest {

	@Autowired
	private DefaultProperties defaultProperties;

	@Autowired
	private SourceProperties sourceProperties;

	@Autowired
	private AutoProperties autoProperties;

	@Autowired
	private Environment env;

	@Autowired
	private DefaultAutoProperties defaultAutoProperties;

	@Test
	public void defaultAutoPropertiesTest(){
		log.info(defaultAutoProperties.toString());
	}

	@Test
	public void defaultPropertiesTest(){
		log.info(defaultProperties.toString());
		log.info(env.getProperty("com.appName"));
	}

	@Test
	public void sourceProperties() throws IOException {
		log.info(sourceProperties.toString());


		Resource url = sourceProperties.getUrl();
		URL url1 = url.getURL();
		log.info(url1.getPath());


		Resource file = sourceProperties.getFile();
		File file1 = file.getFile();
		log.info(file1.getAbsolutePath());

	}

	@Test
	public void autoProperties(){
		log.info(autoProperties.toString());
	}

}