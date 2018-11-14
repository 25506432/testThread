package cn.test.thread5;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class MyQueue {
	
	private LinkedList<Object> list = new LinkedList<>();
	private AtomicInteger count = new AtomicInteger(0);
	private int minSize = 0;
	private int maxSize ;
	private Object lock = new Object();
	public MyQueue(int len) {
		this.maxSize = len;
	}
	
	public void put(Object obj){
		synchronized (lock) {
			while(this.maxSize == count.get()){
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			//添加元素
			list.add(obj);
			//计数器增加
			count.incrementAndGet();
			System.out.println("新增元素:"+obj);
			//唤醒其他线程
			lock.notify();
		}
	}
	public Object take(){
		Object obj = null;
		synchronized (lock) {
			while(count.get() == 0){
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			//移除元素
			obj =  list.removeFirst();
			//计数器减一
			count.decrementAndGet();
			//唤醒其他线程
			lock.notify();
		}
		return obj;
	}
	
	public static void main(String[] args) {
		MyQueue mq = new MyQueue(5);
		mq.put("a");
		mq.put("b");
		mq.put("c");
		mq.put("d");
		mq.put("e");
		
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				mq.put("ggggg");
				mq.put("fffff");
				mq.put("hhhhh");
			}
		} ,"t1");
		
		t1.start();
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				Object ob1 = mq.take();
				System.out.println("移除元素为:"+ob1);
				Object ob2 = mq.take();
				System.out.println("移除元素为:"+ob2);
				
			}
		},"t2");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t2.start();
		
	}
	
	
}
