package Flipkart;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import objectrepository.addtocart;
import objectrepository.flipkartlogin;
import objectrepository.logout;
import objectrepository.productSearch;

public class flipkart {
	static WebDriver driver;

	@BeforeTest
	public void driverinit() {
		System.out.println("====== Initializing Selenium driver ======");
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void login() throws InterruptedException {

		System.out.println("====== Opening Flipkart Website ======");
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		Thread.sleep(2000);

		// Login Flow
		System.out.println("====== Logging into Flipkart ======");
		flipkartlogin flogin = new flipkartlogin(driver);
		flogin.username().sendKeys("8951017950");
		flogin.password().sendKeys("Welcome123$", Keys.ENTER);
		Thread.sleep(1000);
		System.out.println(driver.getTitle());

		// Product search
		System.out.println("====== Performing Product Search ======");
		productSearch pd = new productSearch(driver);
		pd.searchProduct().sendKeys("Apple iphone", Keys.ENTER);
		Thread.sleep(1000);
		pd.productDetail().click();

		// Windows switching
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		it.next();
		String productPage = it.next();
		driver.switchTo().window(productPage);
		Thread.sleep(1000);

		// Add to cart and add new address
		System.out.println("====== Adding Product into chart ======");
		addtocart adc = new addtocart(driver);
		Thread.sleep(1000);
		adc.addtocartitem().click();
		adc.placeorder().click();
		
		System.out.println("====== Changing Address ======");
		String name = "Gurpreet";
		String mo = "9828123456";
		String pin = "123445";
		String add = "Address";
		String loc = "Location";
		int state = 1;
		String city = "Bangalore Rural District";
		adc.addnewaddress(driver, name, mo, pin, add, loc, state, city);

		// Logout
		System.out.println("====== Loggout from Flipkart ======");
		logout lg = new logout(driver);
		lg.flipkartLogout();
		Thread.sleep(1000);
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
