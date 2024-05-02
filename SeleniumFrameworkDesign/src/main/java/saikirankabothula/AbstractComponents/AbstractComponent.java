package saikirankabothula.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import saikirankabothula.pageobjects.CartPage;

public class AbstractComponent 
{
			 WebDriver driver;
		public AbstractComponent(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		
	}
		@FindBy(css="button[routerlink='/dashboard/cart']")
		WebElement cartHeader;
		
		public CartPage goToCartPage() {
			
			cartHeader.click();
			CartPage cartPage = new CartPage(driver);
			return cartPage;
		}
		
		public void waitForElementsToAppear(By findBy)
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));	
		}
		
		public void waitForElementsToDisappear(WebElement ele) throws InterruptedException
		{
			Thread.sleep(1000);
		//	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		//	wait.until(ExpectedConditions.invisibilityOf(ele));
		}
		
}


