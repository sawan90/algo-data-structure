import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class testSyn implements Serializable {
	public int speeds;
	public int wheels;

	private void writeObject(ObjectOutputStream oos) throws IOException {
		oos.writeInt(speeds);
		oos.writeInt(wheels);
	}

	private void readObject(ObjectInputStream ois) throws IOException {
		speeds = ois.readInt();
		wheels = ois.readInt();
	}
	public Object readResolve(){
		System.out.println("hello");
		return this;
		
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileOutputStream f = new FileOutputStream(
				"/home/sawanchoubisa/testSyn.dat");
		ObjectOutputStream outputStreamWriter = new ObjectOutputStream(f);
		testSyn t = new testSyn();
		t.speeds = 5;
		t.wheels = 10;
		outputStreamWriter.writeObject(t);
		outputStreamWriter.close();
		FileInputStream fileInputStream = new FileInputStream(
				"/home/sawanchoubisa/testSyn.dat");
		ObjectInputStream objectInputStream = new ObjectInputStream(
				fileInputStream);
		testSyn t1 = new testSyn();
		t1 = (testSyn) objectInputStream.readObject();
		System.out.println(t1.speeds);
		objectInputStream.close();
	}
}