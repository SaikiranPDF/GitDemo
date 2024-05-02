import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class JavaStreamsTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.id("search-field")).sendKeys("Chocolate");
		List<WebElement> veg = driver.findElements(By.xpath("//tr/td[1]"));
		List<WebElement> filVeg = veg.stream().filter(s->s.getText().contains("Chocolate"))
		.collect(Collectors.toList());
		Assert.assertEquals(veg.size(), filVeg.size());
	}

}
