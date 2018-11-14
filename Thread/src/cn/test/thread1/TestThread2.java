package cn.test.thread1;

public class TestThread2 extends Thread {
	private   int a = 5;
	
	@Override
	public synchronized void run() {
		a-- ;
		System.out.println(this.currentThread().getName()+"----"+a);
	}
	
	public static void main(String[] args) {
		TestThread2 thread = new TestThread2();
		Thread t1 = new Thread(thread,"t1");
		Thread t2 = new Thread(thread,"t2");
		Thread t3 = new Thread(thread,"t3");
		Thread t4 = new Thread(thread,"t4");
		Thread t5 = new Thread(thread,"t5");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
		
	}
}
