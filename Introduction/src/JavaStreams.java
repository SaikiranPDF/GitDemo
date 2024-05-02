import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.cssSelector("tr th:nth-child(1)")).click();
		List<WebElement> elementsList =  driver.findElements(By.xpath("//tr/td[1]"));
		List<String> OGList = elementsList.stream().map(s->s.getText()).collect(Collectors.toList());
		List<String> sortedList = OGList.stream().sorted().collect(Collectors.toList());
		Assert.assertTrue(OGList.equals(sortedList));
		List<String> price;
		
		//scan the names column with gettext -> vegname -> price of that vegname
		do
		{
			List<WebElement> rows =  driver.findElements(By.xpath("//tr/td[1]"));
			price = rows.stream().filter(s->s.getText().contains("Rice")).map(s->getVegetablePrice(s))
			.collect(Collectors.toList());
			price.forEach(a-> System.out.println(a));
			if(price.size()<1)
			{
			driver.findElement(By.cssSelector("[aria-label='Next'")).click();
			}
		}while(price.size()<1);	
	}

	private static String getVegetablePrice(WebElement s) {
		// TODO Auto-generated method stub
		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceValue;
	}
}	