package com.qa.base;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestCat {

	public static WebDriver driver;
	public static Properties prop;

	public static void main(String[] args) throws Throwable {

		prop = new Properties();

		// mention the below chrome option to solve timeout exception issue
		ChromeOptions options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NONE);

		FileInputStream fis = new FileInputStream(".\\src\\main\\java\\resource\\data.properties");
		prop.load(fis);

		String browserName = prop.getProperty("browser");
		System.out.println(browserName);

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chrome"));
			// driver = new ChromeDriver();
			driver = new ChromeDriver(options);
		}

		else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", prop.getProperty("Firefox"));
			driver = new FirefoxDriver();
		}

		// driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Dimension dm = new Dimension(411, 630);
		driver.manage().window().setSize(dm);
		driver.manage().deleteAllCookies();
		System.out.println("Browser is launched");
		driver.navigate().to("https://catevolution.com.au/index.php?route=common/amp_home");
		System.out.println("Url is launched");
		Thread.sleep(3000);
		System.out.println("Scroll started");

		WebElement ele = driver.findElement(By.xpath("//*[contains(text(),'Copyright')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("arguments[0].scrollIntoView();", ele);
		// js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

//		for(int i=0;i<12;i++) {
//			js.executeScript("window.scrollBy(0,550)", "");
//			Thread.sleep(1000);
//			System.out.println("Scrolled time:-"+i);
//		}
//		
//		
//		for(int i=0;i<12;i++) {
//			js.executeScript("window.scrollBy(0,-550)", "");
//			Thread.sleep(1000);
//			System.out.println("Scrolled time:-"+i);
//		}

		System.out.println("Scroll end");
		Thread.sleep(3000);
		WebElement hamburgerMenu = driver.findElement(By.xpath("//button[@class=\"menu-button amp-close-image\"]"));

		js.executeScript("arguments[0].click()", hamburgerMenu);
		//js.executeScript("el = document.elementFromPoint(415, 30); el.click();");
		//Thread.sleep(3000);
		System.out.println("We have clicked on hamburger menu");
		
		WebElement subMenuLitterRobot =  driver.findElement(By.xpath("//a[contains(text(),'Litter-Robot Connect')]"));
		subMenuLitterRobot.click();
		System.out.println("We have clicked on Litter-Robot Connect sub menu");
		
		for(int i=0;i<2;i++) {
			js.executeScript("window.scrollBy(0,550)", "");
			Thread.sleep(1000);
			System.out.println("Scrolled time:-"+i);
		}
		Thread.sleep(3000);
		Select selectColor =new Select(driver.findElement(By.id("input-option240")));
		selectColor.selectByVisibleText("Grey (SKU: LR3C-1200 )");
		
		js.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(1000);
		
		WebElement buyNowBtn = driver.findElement(By.xpath("//input[@id='button-cart-buynow']"));
		buyNowBtn.click();
		
		js.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(1000);
		
		WebElement firstName = driver.findElement(By.xpath("(//*[@name=\"payment_address[firstname]\"])[2]"));
		firstName.sendKeys("hello");
		
		WebElement lastName = driver.findElement(By.xpath("(//input[@name='payment_address[lastname]'])[2]"));
		lastName.sendKeys("hello");
		
		WebElement email = driver.findElement(By.xpath("(//input[@name='payment_address[email]'])[2]"));
		email.sendKeys("hello@gmail.com");
		
		WebElement telephone = driver.findElement(By.xpath("(//input[@name='payment_address[telephone]'])[2]"));
		telephone.sendKeys("1236547890");
		
		WebElement flat = driver.findElement(By.xpath("(//input[@name='payment_address[address_2]'])[2]"));
		flat.sendKeys("abc");
		
		WebElement address = driver.findElement(By.xpath("(//input[@name='payment_address[address_1]'])[2]"));
		address.sendKeys("this is address");
		
		WebElement city = driver.findElement(By.xpath("(//input[@name='payment_address[city]'])[2]"));
		city.sendKeys("City");
		
		WebElement postCode = driver.findElement(By.xpath("(//input[@name='payment_address[postcode]'])[2]"));
		postCode.sendKeys("123456");
			
		Select selectStateDD =new Select(driver.findElement(By.xpath("(//*[@name='payment_address[zone_id]'])[2]")));
		selectStateDD.selectByVisibleText("Northern Territory");
				
		Select selectCountryDD =new Select(driver.findElement(By.xpath("(//*[@name='payment_address[country_id]'])[2]")));
		selectCountryDD.selectByVisibleText("Australia");
		
		js.executeScript("window.scrollBy(0,550)", "");
		Thread.sleep(1000);
		
		WebElement creditCardRadioBtn = driver.findElement(By.xpath("(//*[@name='payment_method'])[1]"));
		creditCardRadioBtn.click();
		
		WebElement ccHolder = driver.findElement(By.xpath("//input[@name=\"cc_holder\"]"));
		ccHolder.sendKeys("testingName");
		
		WebElement ccNumber = driver.findElement(By.xpath("//input[@name=\"cc_number\"]"));
		ccNumber.sendKeys("1236412326541236");
		
		Select ccExpDateDD =new Select(driver.findElement(By.xpath("//*[@name='cc_expire_date_month']")));
		ccExpDateDD.selectByVisibleText("03");
		
		Select ccExpYearDD =new Select(driver.findElement(By.xpath("//*[@name='cc_expire_date_year']")));
		ccExpYearDD.selectByVisibleText("2023");
		
		WebElement ccV = driver.findElement(By.xpath("//input[@name='cc_cvv2']"));
		ccV.sendKeys("123");
		
		js.executeScript("window.scrollBy(0,550)", "");
		Thread.sleep(1000);
		
		js.executeScript("window.scrollBy(0,550)", "");
		Thread.sleep(1000);
		
				
		Select hearAboutDD =new Select(driver.findElement(By.id("dropdownHduSource")));
		hearAboutDD.selectByVisibleText("Google Ads");
		
		js.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(1000);
		
		WebElement orderComment = driver.findElement(By.xpath("//*[@name='comment']"));
		orderComment.sendKeys("Hurry...!!!");
		
		WebElement termsChkBox = driver.findElement(By.xpath("//input[@name='confirm_terms']"));
		termsChkBox.click();
		
		
		WebElement confirmOrderBtn = driver.findElement(By.xpath("//*[contains(text(),'CONFIRM ORDER')]"));
		
		//confirmOrderBtn.click();
		
		System.out.println("Execution completed successfully");
	}
}
