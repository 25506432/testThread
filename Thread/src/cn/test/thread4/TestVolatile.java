package cn.test.thread4;
/**
 * 线程执行后,JVM 会为每个线程分配一个新的内存空间,在JDK1.5以后 为 线程内存空间做了优化,线程独立的内存空间增加了一个新的空间
 * 里面存放的是 主内存空间的变量(为什么 会存在独立线程的 内存变量空间? --> 因为 主内存的变量 在run 方法中被引用了)的副本 ,
 * 每次在 交互的时候 跟自己独立内存变量空间交互 即可,而不需要 每次 都到主内存中读取,从而导致,就算 下述的值被修改 也不会停止线程运行。
 *当 在run中被引用的变量被volatile关键字修饰过后,当该变量被修改后,会强制[引用该变量的]线程执行引擎去主内存中读取(也就是 
 *	刷新这个线程中独立内存变量空间中变量的值)。
 */

public class TestVolatile  extends Thread{
	private volatile boolean isRunning = true;
	public void setIsRunning(boolean isRunning){
		this.isRunning = isRunning;
	}
	
	@Override
	public void run() {
		System.out.println("进入 run 方法");
		while(isRunning == true){
			
		}
		System.out.println("线程停止");
	}
	
	public static void main(String[] args) throws InterruptedException {
		TestVolatile t= new TestVolatile();
		Thread t1 = new Thread(t);
		t1.start();
		Thread.sleep(3000);
		t.setIsRunning(false);
		System.out.println("isRunning的值已经被改为false");
		System.out.println(t.isRunning);
		
	}
	
}
