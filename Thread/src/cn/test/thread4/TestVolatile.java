package cn.test.thread4;
/**
 * �߳�ִ�к�,JVM ��Ϊÿ���̷߳���һ���µ��ڴ�ռ�,��JDK1.5�Ժ� Ϊ �߳��ڴ�ռ������Ż�,�̶߳������ڴ�ռ�������һ���µĿռ�
 * �����ŵ��� ���ڴ�ռ�ı���(Ϊʲô ����ڶ����̵߳� �ڴ�����ռ�? --> ��Ϊ ���ڴ�ı��� ��run �����б�������)�ĸ��� ,
 * ÿ���� ������ʱ�� ���Լ������ڴ�����ռ佻�� ����,������Ҫ ÿ�� �������ڴ��ж�ȡ,�Ӷ�����,���� ������ֵ���޸� Ҳ����ֹͣ�߳����С�
 *�� ��run�б����õı�����volatile�ؼ������ι���,���ñ������޸ĺ�,��ǿ��[���øñ�����]�߳�ִ������ȥ���ڴ��ж�ȡ(Ҳ���� 
 *	ˢ������߳��ж����ڴ�����ռ��б�����ֵ)��
 */

public class TestVolatile  extends Thread{
	private volatile boolean isRunning = true;
	public void setIsRunning(boolean isRunning){
		this.isRunning = isRunning;
	}
	
	@Override
	public void run() {
		System.out.println("���� run ����");
		while(isRunning == true){
			
		}
		System.out.println("�߳�ֹͣ");
	}
	
	public static void main(String[] args) throws InterruptedException {
		TestVolatile t= new TestVolatile();
		Thread t1 = new Thread(t);
		t1.start();
		Thread.sleep(3000);
		t.setIsRunning(false);
		System.out.println("isRunning��ֵ�Ѿ�����Ϊfalse");
		System.out.println(t.isRunning);
		
	}
	
}
