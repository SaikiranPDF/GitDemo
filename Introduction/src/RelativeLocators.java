import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
public class RelativeLocators {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		/* _______________Using RELATIVE LOCATORS____________________
		
		WebElement nameElement = driver.findElement(By.xpath("(//input[@name='name'])[1]"));
		System.out.println(driver.findElement(with(By.tagName("label")).above(nameElement)).getText());
		*/
		driver.switchTo().newWindow(WindowType.TAB);
		//driver.switchTo().newWindow(WindowType.WINDOW);
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String PW = it.next();
		String CW = it.next();
		driver.switchTo().window(CW);
		driver.get("https://rahulshettyacademy.com/");
		String courseName =  driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p/']"))
		.get(1).getText();
		
		driver.switchTo().window(PW);
		
		WebElement name = driver.findElement(By.cssSelector("input[name='name']"));
		name.sendKeys(courseName);
		//driver.quit();
	/*	//___________________SCREEEN SHOT______________________
		File nameSS = name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(nameSS, new File("Logo.png"));
	*/	
		//_________________GET HEIGHT & WIDTH_____________________
		System.out.println(name.getRect().getDimension().getHeight());
		System.out.println(name.getRect().getDimension().getWidth());
		
		
	}
	

}
