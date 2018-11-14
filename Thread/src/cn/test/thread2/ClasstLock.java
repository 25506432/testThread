package cn.test.thread2;
/**
 *多个线程调用 多个 ClasstLock对象  能同步的锁是 字节码文件锁 
 *
 */
public class ClasstLock {
	public static  synchronized  void testObjectLockMethod(String flag){
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
		ClasstLock obj = new ClasstLock();
		ClasstLock obj2 = new ClasstLock();
		
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
