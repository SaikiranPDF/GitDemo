import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/practice-project");
		driver.findElement(By.linkText("Practice")).click();
		driver.findElement(By.id("name")).sendKeys("SaiKiran");
		driver.findElement(By.id("email")).sendKeys("saikirankabothula@gmail.com");
		driver.findElement(By.id("agreeTerms")).click();
		driver.findElement(By.id("form-submit")).click();
		
	}

}
