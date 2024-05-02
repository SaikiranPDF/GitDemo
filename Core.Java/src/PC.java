import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
public class PC {

	public void Example()
	{
		System.out.println("HeLl0 WeLcOmE tO cOrE jAvA");
	}
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("This is BeofreMethod");
	}
	@AfterMethod
	public void AfterMethod()
	{
		System.out.println("This is AfterMethod");
	}
} 