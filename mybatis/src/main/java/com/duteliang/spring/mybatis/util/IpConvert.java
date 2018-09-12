package com.duteliang.spring.mybatis.util;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

import java.net.InetAddress;

public class IpConvert extends ClassicConverter {
	  
    @Override
    public String convert(ILoggingEvent event) {
    	String ip = "";
        InetAddress ia=null;
        try {
        	ia = InetAddress.getLocalHost();
            String localName = ia.getHostName();
            String localIp = ia.getHostAddress();
            ip+="["+localName+"|"+localIp;
        } catch (Exception e) {
            e.printStackTrace();
        }  
        return ip;
    }  
}  
