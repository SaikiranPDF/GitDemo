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
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import saikirankabothula.TestComponents.BaseTest;
import saikirankabothula.pageobjects.CartPage;
import saikirankabothula.pageobjects.CheckoutPage;
import saikirankabothula.pageobjects.ConfirmationPage;
import saikirankabothula.pageobjects.LandingPage;
import saikirankabothula.pageobjects.ProductCatalog;

public class SubmitOrderTest extends BaseTest {

	@Test
	public void submitOrder() throws InterruptedException
	{
			
		String productName = "ZARA COAT 3";
		LandingPage landingPage = launchApplication();
		ProductCatalog productCatalog = landingPage.loginApplication("saikiranpdf@gmail.com", "Saikiran@pdf1");
		List<WebElement> products = productCatalog.getProductsList();	
		productCatalog.addProductToCart(productName); 
		CartPage cartPage = productCatalog.goToCartPage();
			
		Boolean match = cartPage.verifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		
		checkoutPage.selectCountry("india");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		
		
	
		String confirmMessage = confirmationPage.getConfirmationMessage();
		
		
		
	
		
		
		
		
	}

	public LandingPage launchApplication() {
		// TODO Auto-generated method stub
		return null;
	}

}
