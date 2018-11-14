package cn.test.thread2;

/**
 * 多个线程调用一个对象 使用的锁是对象锁
 *
 */
public class ObjectLock {
	public  synchronized  void testObjectLockMethod(String flag){
		 int  num = 0;
		try {
			if(flag == "a"){
				System.out.println("a");
				Thread.sleep(1000);
			}else{
				System.out.println("b");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(flag+"~~~~:"+num);
	}
	
	
	public static void main(String[] args) {
		ObjectLock obj = new ObjectLock();
		ObjectLock obj2 = new ObjectLock();
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				obj.testObjectLockMethod("a");
				
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				obj2.testObjectLockMethod("b");
				
			}
		});
		t1.start();
		t2.start();
		
		
	}
}
