package Class4;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task implements Runnable{
	
	private String name;
	
	public Task(String s) {
		name = s;
	}

	@Override
	public void run() {
		try {
			
	
		for(int i=0;i<=5;i++) {
			if(i==0) {
				Date d = new Date();
				SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
				System.out.println("Initialization for "+name+" = "+ft.format(d));
			}
			else {
				Date d = new Date();
				SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
				System.out.println("Execution for "+name+" = "+ft.format(d));
			}
			Thread.sleep(300);
		 }
		}catch(InterruptedException e) {
			 
		 }
	}
	
}

public class ThreadPoolExample {
	
	public static void main(String args[]) {
		
		Runnable r1 = new Task("task 1");
		Runnable r2 = new Task("task 2");
		Runnable r3 = new Task("task 3");
		Runnable r4 = new Task("task 4");
		Runnable r5 = new Task("task 5");
		
		ExecutorService pool =  Executors.newFixedThreadPool(3);
		pool.execute(r1);
		pool.execute(r2);
		pool.execute(r3);
		pool.execute(r4);
		pool.execute(r5);
		
		pool.shutdown();
	}

}
