
public class Temp {
public static void main(String[] args) {
	Thread t1 = new Thread();
	t1.setName("temp");
	System.out.println(t1.getName()+ " "+t1);
	Thread t = Thread.currentThread();
	System.out.println(t+ " "+t.getName()+" " + t.getPriority());
}
}
