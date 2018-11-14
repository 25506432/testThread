package cn.test.thread1;

public class TestThread implements Runnable {
//	private static  int a = 5;
	private   int a = 5;
	
	@Override
	public  void run() {
		a-- ;
		System.out.println(a);
	}
	
	public static void main(String[] args) {
//		TestThread t1 = new TestThread();
//		TestThread t2 = new TestThread();
//		TestThread t3 = new TestThread();
//		TestThread t4 = new TestThread();
//		TestThread t5 = new TestThread();
//		Thread tt1 = new Thread(t1);
//		Thread tt2 = new Thread(t2);
//		Thread tt3 = new Thread(t3);
//		Thread tt4 = new Thread(t4);
//		Thread tt5 = new Thread(t5);
//		tt1.start();
//		tt2.start();
//		tt3.start();
//		tt4.start();
//		tt5.start();
		TestThread thread = new TestThread();
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
