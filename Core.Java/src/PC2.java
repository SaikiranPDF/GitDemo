import bsh.This;

public class PC2 extends PC3 {

	int a;
	public PC2(int a)
	{
		super(a);
		this.a=a;
	}
	public int increment() {
		a=a+1;
		return a;
	}
	public int decrement() {
		a=a-1;
		return a;
	}	
}
