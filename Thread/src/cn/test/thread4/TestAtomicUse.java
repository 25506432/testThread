package cn.test.thread4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomicUse {
	private static  AtomicInteger count = new AtomicInteger();
	
	public synchronized  int mulAtoAdd(){
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		count.addAndGet(1);
		count.addAndGet(2);
		count.addAndGet(3);
		count.addAndGet(4);
		return count.get();
	}
	
	public static void main(String[] args) {
		TestAtomicUse t = new TestAtomicUse();
		List<Thread> li = new ArrayList<>();
		for(int i=0;i<10;i++){
			li.add(new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.println(t.mulAtoAdd());
				}
			}));
		}
		for (Thread thread : li) {
			thread.start();
		}
		
	}
	
}
