Spring Boot Demo <br/>
本项目采用IntelliJ IDEA编辑器开发 <br/>
jdk        1.8 <br/>
springBoot 1.5.15 <br/>
大部分项目配置优先采用注解和javaConfig，不使用xml配置写法 <br/>

1. properties  对配置文件的解析做demo写法，有小部分SpEL的运用 <br/>
2. spring_core 对spring ioc和aop做简单的运用 <br/>
3. mongodb     对mongodb的基本操作 <br/>
4. mvc         对web工程的基本搭建 <br/>
   +  使用内置tomcat 
   +  使用jdbcTemplate 连接 mysql 
   +  使用springMvc 
   +  使用注解方式的事物管理 
   +  使用swagger来测试和查看接口 
   +  使用thymeleaf视图解析器
   +  下载，上传文件
   +  拦截器,过滤器,监听器，servlet的基本使用
   +  嵌入webSocket 
   +  嵌入activeMq 
   +  基本的登陆系统
5. redis       对redis的基本使用(未开发) <br/>
6. hibernate   对hibernate的基本使用(未开发) <br/>
7. mybatis     对mybatis的基本使用 <br/>
   +  数据库连接池采用阿里的druid
   +  对日志logback的使用
   +  使用分页插件和通用mapper插件 (官网入口:http://mybatis.tk/ ) <br/>
   mybatis-java  对mybatis和插件的配置详细化，不使用springBoot的配置
8. apache_shiro 对shiro的使用(开发中) <br/>