package com.duteliang.test;

/**
 * @author: zl
 * @Date: 2019-1-5 13:45
 */
public class ThreadDemo {

	private volatile int num = 0;

	private int getNum(){
		return this.num;
	}

	private void increase(){
//		try {
//			Thread.sleep(100);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		num++;
	}


	public static void main(String[] args) {
		final ThreadDemo threadDemo = new ThreadDemo();

		for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				for (int j = 0; j < 1000; j++) {
					threadDemo.increase();
				}
			}).start();
		}
		while (Thread.activeCount() > 1){
			Thread.yield();
		}

		System.out.println("num = " + threadDemo.getNum());

	}


}

