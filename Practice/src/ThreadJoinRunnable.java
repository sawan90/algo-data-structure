
public class ThreadJoinRunnable {
	public static Object lock = new Object();
	
	public static void main(String[] args) throws InterruptedException {
		ThreadJoinRunnable threadJoinRunnable = new ThreadJoinRunnable();
		R1 r1  = new R1(threadJoinRunnable);
		R2 r2  = new R2(threadJoinRunnable);
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
	}
}

class R1 implements Runnable{
	private ThreadJoinRunnable threadJoinRunnable;
	public R1(ThreadJoinRunnable threadJoinRunnable) {
		this.threadJoinRunnable = threadJoinRunnable;
	}
	@Override
	public void run() {
		synchronized (threadJoinRunnable) {
			for(int i=1;i<=10;i+=2){
				System.out.println(i);
				try {
					threadJoinRunnable.wait();
					threadJoinRunnable.notifyAll();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
}

class R2 implements Runnable{
	private ThreadJoinRunnable threadJoinRunnable;
	public R2(ThreadJoinRunnable threadJoinRunnable) {
		this.threadJoinRunnable = threadJoinRunnable;
	}
	@Override
	public void run() {
		synchronized (threadJoinRunnable) {
			for(int i=2;i<=10;i+=2){
				
				System.out.println(i);
				try {
					threadJoinRunnable.notifyAll();
					threadJoinRunnable.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	
		
	}
	
}

