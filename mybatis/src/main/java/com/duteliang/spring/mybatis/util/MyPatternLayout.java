package com.duteliang.spring.mybatis.util;

import ch.qos.logback.classic.PatternLayout;

public class MyPatternLayout extends PatternLayout {
    static {  
        defaultConverterMap.put("ip",IpConvert.class.getName());  
    }  
} 
