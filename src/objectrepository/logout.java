package objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class logout {

	WebDriver driver;

	public logout(WebDriver driver) {

		this.driver = driver;
	}

	public void flipkartLogout() throws InterruptedException {
		
		 driver.get("https://www.flipkart.com/account/?rd=0&link=home_account");
		 driver.findElement(By.xpath("//span[@class='_2ZZi8V']")).click();
		 

		/*Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath("//div[@class='_2aUbKa'][text()='Gurpreet']"));
		action.moveToElement(we).build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("//div[(text()='Logout')]"))).click().build().perform();*/
	}

}