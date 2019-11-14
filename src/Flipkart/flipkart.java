package Flipkart;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import objectrepository.addtocart;
import objectrepository.flipkartlogin;
import objectrepository.logout;
import objectrepository.productSearch;

public class flipkart {


	@Test
	public void login() throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		
		//Login Flow
		flipkartlogin flogin = new flipkartlogin(driver);
		flogin.username().sendKeys("8951017950");
		flogin.password().sendKeys("Welcome123$", Keys.ENTER);
		Thread.sleep(1000);
		System.out.println(driver.getTitle());
				
		//Product search
		productSearch pd = new productSearch(driver);
		pd.searchProduct().sendKeys("Apple iphone", Keys.ENTER);
		Thread.sleep(1000);
		pd.productDetail().click();
		
		//Windows switching
		Set<String> ids=driver.getWindowHandles();
		Iterator<String> it=ids.iterator();
		String homePage=it.next();
		String productPage=it.next();
		driver.switchTo().window(productPage); 
		Thread.sleep(1000);
		
		// Add to cart and add new address
		addtocart adc= new addtocart(driver);
		Thread.sleep(1000);
		adc.addtocartitem().click();;
		adc.placeorder().click();;
		String name="Gurpreet";
		String mo= "9828123456";
		String pin="123445";
		String add="Address";
		String loc="Location";
		int state=1;
		String city="Bangalore Rural District";
		adc.addnewaddress(driver,name,mo,pin,add,loc,state,city);
		
		
		//Logout 
		logout lg = new logout(driver);
		lg.flipkartLogout();
		Thread.sleep(1000);
		driver.quit();

	}


}
