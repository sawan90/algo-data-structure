public class ThreadJoin {
	public static Object lock = new Object();
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				synchronized (lock) {
					for(int i=1;i<=10;i+=2){
						System.out.println(i);
						try {
							lock.wait();
							lock.notifyAll();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				
			}
		});
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				synchronized (lock) {
					for(int i=2;i<=10;i+=2){
						
						System.out.println(i);
						try {
							lock.notifyAll();
							lock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			
				
			}
		});
		
			
			try {
				t1.start();
				t2.start();
				t1.join();
				t2.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	
}
