package cn.test.thread3;

//测试两个线程分别通过同一个对象 调用 一个 同步和一个非同步方法 对象锁的同步和异步问题
/**
 * 对于多个线程调用同一个 对象, 多个线程调用其中的同步和非同步方法 互不干扰 就是所谓的异步,如果调用的 方法 都是同步的 则  就是 所谓的同步
 */
public class TestThread extends Thread{
	
	public synchronized void test1(){
		try {
			System.out.println(this.currentThread().getName());
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	public synchronized void test2(){
//		System.out.println(this.currentThread().getName());
//	}
	public  void test2(){
		System.out.println(this.currentThread().getName());
	}
	
	public static void main(String[] args) {
		TestThread t = new TestThread();
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				t.test1();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				t.test2();
			}
		});
		t1.start();
		t2.start();
	}
}
