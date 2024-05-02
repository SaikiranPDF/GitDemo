import org.testng.annotations.Test;
public class PC1 extends PC {

	@Test
	public void testRun() 
	{	
		PC2 pc2 = new PC2(3);
		int a = 3;
		Example();
		System.out.println(pc2.increment());
		System.out.println(pc2.decrement());
		//PC3 pc3 = new PC3(3);
		System.out.println(pc2.multiplyThree());
		
	}

}
