package saikirankabothula.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import saikirankabothula.AbstractComponents.AbstractComponent;

public class ProductCatalog extends AbstractComponent {
	
	WebDriver driver;
	
	public ProductCatalog(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
//	WebElement userEmail = driver.findElement(By.id("userEmail"));
	
//______________PAGE FACTORY________________
//List<WebElement> products = driver.findElements(By.cssSelector(".col-lg-4"));
	
	@FindBy(css=".col-lg-")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	By productsBy = By.cssSelector(".col-lg-4");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");

	public List<WebElement> getProductsList()
	{
		waitForElementsToAppear(productsBy);
		return products;
	}
	
	public WebElement getProductByName(String productName)
	{
		WebElement prod =  getProductsList().stream().filter(product->product.findElement(By.cssSelector("b"))
				.getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	
	public void addProductToCart(String productName) throws InterruptedException
	{
		WebElement prod =  getProductByName(productName);
		prod.findElement(addToCart).click();
		waitForElementsToAppear(toastMessage);
		waitForElementsToDisappear(spinner);
	}
	
	

}
