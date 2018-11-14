package cn.test.thread3;

//���������̷ֱ߳�ͨ��ͬһ������ ���� һ�� ͬ����һ����ͬ������ ��������ͬ�����첽����
/**
 * ���ڶ���̵߳���ͬһ�� ����, ����̵߳������е�ͬ���ͷ�ͬ������ �������� ������ν���첽,������õ� ���� ����ͬ���� ��  ���� ��ν��ͬ��
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
