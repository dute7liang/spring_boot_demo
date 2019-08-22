package com.duteliang.java.collection;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: zl
 * @Date: 2019-8-21 11:45
 */
public class ListDemo {

	public static Object obj = new Object();

	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		obj.wait();

	}



}
