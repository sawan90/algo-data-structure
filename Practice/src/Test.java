public class Test implements Runnable {
	public void run() {
		System.out.println(Thread.currentThread().getName()+" "+ geta());
		System.out.println(Thread.currentThread().getName()+" "+getb());
	}

	 static int a = 1;

	public synchronized static int geta() {
		
		return a++;
	}

	public synchronized static int getb() {
		geta();
		return a;
	}

	public static void main(String args[]) {
		Test a1 = new Test();
		Test a2 = new Test();
		Thread t1 = new Thread(a1);
		Thread t2 = new Thread(a2);
		t1.start();
		t2.start();
	}

}
