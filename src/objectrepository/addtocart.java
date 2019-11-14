package objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class addtocart {

	WebDriver driver;

	public addtocart(WebDriver driver) {

		this.driver = driver;
	}

	// Add to cart button
	By addtocart = By.xpath("//button[(text()='ADD TO CART')]");
	// Place Order button
	By placeOrder = By.xpath("//span[(text()='Place Order')]");

	By addnewaddress = By.xpath("//div[contains(text(),'Add a new address')]");
	// New address Elements
	By newName = By.xpath("//input[@name='name']");
	By newMobile = By.xpath("//input[@name='phone']");
	By newPin = By.xpath("//input[@name='pincode']");
	By newAddress = By.xpath("//textarea[@name='addressLine1']");
	By newLocality = By.xpath("//input[@name='addressLine2']");
	By newCity = By.xpath("//input[@name='city']");
	By newState = By.xpath("//select[@name='state']");
	By newAddtype = By.xpath("//input[@name='locationTypeTag']");
	// Save New Addres button
	By savebutton = By.xpath("//button[(text()='Save and Deliver Here')]");
	//Cancel button
	By cancelbutton = By.xpath("//button[@class='_2AkmmA _237M5J']");
	

	public WebElement addtocartitem() {
		return driver.findElement(addtocart);
	}

	public WebElement placeorder() {
		return driver.findElement(placeOrder);
	}

	public void addnewaddress(WebDriver driver, String name, String mobile, String pin, String address, String loc,
			Integer stateno, String city) throws InterruptedException {

		driver.findElement(addnewaddress).click();
		Thread.sleep(1000);
		driver.findElement(newName).sendKeys(name);
		Thread.sleep(1000);
		driver.findElement(newMobile).sendKeys(mobile);
		Thread.sleep(1000);
		driver.findElement(newPin).sendKeys(pin);
		Thread.sleep(1000);
		driver.findElement(newAddress).sendKeys(address);
		Thread.sleep(1000);
		driver.findElement(newLocality).sendKeys(loc);
		Thread.sleep(1000);
		Select state = new Select(driver.findElement(newState));
		state.selectByIndex(stateno);
		Thread.sleep(1000);
		driver.findElement(newCity).sendKeys(city, Keys.DOWN, Keys.ENTER);
		Thread.sleep(1000);
		WebElement radio1 = driver.findElement(newAddtype);
		//radio1.click();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", radio1);
		Thread.sleep(1000);
		driver.findElement(cancelbutton).click();

	}
}
