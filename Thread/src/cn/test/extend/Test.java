package cn.test.extend;


public class Test {
	public  static int count = 0;
	public static void main(String[] args) throws Exception {
		for(int i=0;i<10;i++){
			new Thread(new Runnable() {
				
				@Override
				public void run() {
						synchronized (Test.class) {
							count++;
							System.out.println(Thread.currentThread().getName());
						}
//					}
				}
			}).start();
		}
		System.out.println(count);	
	}
	
	
}
