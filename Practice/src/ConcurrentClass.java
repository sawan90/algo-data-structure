import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class ConcurrentClass {
	public static class Callble implements Callable<Integer>{
		public static int count; 
		public static Object ob = new Object();
		@Override
		public Integer call() throws Exception {
			Thread.currentThread().setName("FooName"+count);
			// TODO Auto-generated method stub
			synchronized (ob) {
				System.out.println(Thread.currentThread().getName());
				++ count;
			}
			return count;
		}
		
	}

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		Callble c1  = new Callble();
		Callble c2  = new Callble();
		for(int i=1;i<10;i++){
			Future<Integer> f1 = executorService.submit(c1);
			Future<Integer> f2 = executorService.submit(c2);
			try {
				System.out.println(f1.get());
				System.out.println(f2.get());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
