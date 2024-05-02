package saikirankabothula.Tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import saikirankabothula.pageobjects.LandingPage;

public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String productName = "ADIDAS ORIGINAL";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		LandingPage landingPage = new LandingPage(driver);
		driver.findElement(By.id("userEmail")).sendKeys("saikiranpdf@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Saikiran@pdf1");
		driver.findElement(By.id("login")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//we are using Explicit_wait to load products in the website
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".col-lg-4")));

		List<WebElement> products = driver.findElements(By.cssSelector(".col-lg-4"));

		WebElement prod = products.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst()
				.orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

//Now we are using EXPLICIT_WAIT method to grab product is added popup
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));

//{class = ng-animating} - using Explicit_wait for the loading icon till disappear
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).click();

		List<WebElement> cartProd = driver.findElements(By.cssSelector("productName"));

//filter - gives the WebElement to that particular element
//anyMatch - gives the text present in that WebElement
		Boolean match = cartProd.stream().anyMatch(cProd -> cProd.getText().equalsIgnoreCase(productName));

		// Assert.assertTrue(match);

		driver.findElement(By.cssSelector(".totalRow button")).click();

//___________using Action class___________
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section[class*='ta-results']")));
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		driver.findElement(By.cssSelector(".action__submit")).click();

		String message = driver.findElement(By.cssSelector(".hero-primary")).getText();

		Assert.assertTrue(message.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
//Assert.assertEquals(message, " Thankyou for the order. ");

	}

}
