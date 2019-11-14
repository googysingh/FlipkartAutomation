package objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class flipkartlogin {

	WebDriver driver;

	public flipkartlogin(WebDriver driver) {
		
		this.driver = driver;
	}

	//By loginbutton = By.xpath("//a[contains(text(),'Login & Signup')]");
	By userName = By.className("_2zrpKA");
	By passWord = By.xpath("//input[@type=\"password\"]");

	public WebElement username() {
		return driver.findElement(userName);
	}

	public WebElement password() {
		return driver.findElement(passWord);
	}

}
