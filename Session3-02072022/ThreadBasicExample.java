package Class3;

class ThreadA extends Thread{
	public void run() {
		System.out.println("ThreadA "+Thread.currentThread());
		for(int i=20;i>0;i--) {
			System.out.println("ThreadA class with i= "+i);
		}
	}
}

class ThreadB extends Thread{
	public void run() {
		System.out.println("ThreadB "+Thread.currentThread());
		for(int i=20;i>0;i--) {
			System.out.println("ThreadB class with i= "+i);
		}
	}
}


class ThreadRunnable implements Runnable{

	@Override
	public void run() {
		System.out.println("ThreadRunnable "+Thread.currentThread());
		for(int j =25;j>0;j--) {
			System.out.println("ThreadRunnable class with j= "+j);
		}
	}
	
}
public class ThreadBasicExample {
	
	public static void main(String[] args) {
		
		ThreadA threadA = new ThreadA();
		ThreadB threadB = new ThreadB();

		
		ThreadRunnable threadC = new ThreadRunnable();
		
		Thread t1 = new Thread(threadC);
		
		threadA.start();
		threadA.setPriority(10);
		
		try {
			threadA.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		threadB.start();
		t1.run();
		
		System.out.println("Total Memory available to JVM "+ Runtime.getRuntime().totalMemory()/1000000+" MB");
		
		System.out.println("Total Memory used by JVM "+ (Runtime.getRuntime().totalMemory() - 
				Runtime.getRuntime().freeMemory())/1000000+" MB");
		
		//VisualVM

		
	}

}
