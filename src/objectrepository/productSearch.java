package objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class productSearch {

	WebDriver driver;

	public productSearch(WebDriver driver) {

		this.driver = driver;
	}

	// By loginbutton = By.xpath("//a[contains(text(),'Login & Signup')]");
	By SearchProduct = By.xpath("//input[@placeholder='Search for products, brands and more']");
	By productDetail = By.xpath("//a[@class='_31qSD5' and @rel='noopener noreferrer'] ");
	By Login = By.className("_2zrpKA");

	public WebElement searchProduct() {
		return driver.findElement(SearchProduct);
	}

	public WebElement productDetail() {
		return driver.findElement(productDetail);
	}

}
