package cn.test.thread4;

import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomicInteger extends Thread{
	private static volatile int count = 0;
//	private static AtomicInteger count = new AtomicInteger(0);
	public static  void increCount(){
		for(int i=0;i<1000;i++){
			count ++;
//			count.incrementAndGet();
		}
		System.out.println(count);
	}
	@Override
	public void run() {
		increCount();
	}
	public static void main(String[] args) {
		TestAtomicInteger [] arr = new TestAtomicInteger[10];
		for(int i=0;i< 10;i++){
			arr[i] = new TestAtomicInteger();
		}
		for(int i=0;i<10;i++){
			arr[i].start();
		}
	}
}
