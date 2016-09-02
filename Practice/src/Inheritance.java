abstract class Inheritance1  {
	public int i;
	public Inheritance1(){
		System.out.println(i);
	}
	public Inheritance1(int i) {
		i = i;
		System.out.println("hi"+i);
	}
	public void show(){
		System.out.println("hello");
	}
	
	
}

public class Inheritance extends Inheritance1 {
	public int i;
	public Inheritance(int i) {
		i =5;
		System.out.println("hello" + i);
	}
	
	public void show(int a){
		System.out.println("hello");
	}
	public static void main(String[] args) {
		Inheritance1 i = new Inheritance(5);

System.out.printf("Pi = %f and E = %b", Math.PI, Math.E);
		System.out.println("end");
	}

}
