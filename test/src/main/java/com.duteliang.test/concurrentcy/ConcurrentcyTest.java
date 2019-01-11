package com.duteliang.test.concurrentcy;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: zl
 * @Date: 2019-1-5 15:33
 */
@Slf4j
public class ConcurrentcyTest {

	public static int count = 0;

	// 请求总数
	public static int clientTotal = 5000;

	// 同时并发执行线程数
	public static int 	threadTotal = 200;

	public static void main(String[] args) throws InterruptedException {

		Lock lock = new ReentrantLock();

		ExecutorService service = Executors.newCachedThreadPool();
		final Semaphore semaphore = new Semaphore(threadTotal);
		final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
		for (int i = 0; i < clientTotal; i++) {
			service.execute(() -> {
				try {
					semaphore.acquire();
					add();
					semaphore.release();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				countDownLatch.countDown();
			});
		}
		countDownLatch.await();
		service.shutdown();
		log.info("num = {}",count);
	}

	public static void add(){
		count++;
	}



}
