package com.qa.base;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class BrowserStackSample {
	static AndroidDriver<AndroidElement> driver;

	public static void main(String[] args) throws Throwable {

		DesiredCapabilities caps = new DesiredCapabilities();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		caps.setCapability("browserstack.user", "kenmaccormick1");
		caps.setCapability("browserstack.key", "kR58js3CZxgwgKHyxraB");
		caps.setCapability("device", "Google Pixel 3");
		caps.setCapability("os_version", "9.0");
		// caps.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
		caps.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.CHROME);
		caps.setCapability("project", "First Java Project");
		caps.setCapability("build", "Java Android");
		caps.setCapability("name", "first_test");
		caps.setCapability("automationName", "UiAutomator2");
		driver = new AndroidDriver<AndroidElement>(new URL("http://hub.browserstack.com/wd/hub"), caps);

		
		driver.navigate().to("https://catevolution.com.au/index.php?route=common/amp_home");

		System.out.println("Browser is launched");
		System.out.println("Title " + driver.getTitle());
		Thread.sleep(1000);
		
		System.out.println("Url is launched");
		Thread.sleep(3000);
		System.out.println("Scroll started");

		WebElement ele = driver.findElement(By.xpath("//*[contains(text(),'Copyright')]"));

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
		hamburgerMenu.click();
		//js.executeScript("arguments[0].click()", hamburgerMenu);
		//js.executeScript("el = document.elementFromPoint(415, 30); el.click();");
		//Thread.sleep(3000);
		System.out.println("We have clicked on hamburger menu");
		
		WebElement subMenuLitterRobot =  driver.findElement(By.xpath("//a[contains(text(),'Litter-Robot Connect')]"));
		subMenuLitterRobot.click();
		System.out.println("We have clicked on Litter-Robot Connect sub menu");
		
		for(int i=0;i<2;i++) {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,650)", "");
			Thread.sleep(1000);
			System.out.println("Scrolled time:-"+i);
		}
		
		Thread.sleep(3000);
		Select selectColor =new Select(driver.findElement(By.id("input-option240")));
		selectColor.selectByVisibleText("Bisque (SKU: LR3C-1000 ) ");
		
//		for(int i=0;i<1;i++) {
//			JavascriptExecutor jse = (JavascriptExecutor) driver;
//			jse.executeScript("window.scrollBy(0,250)", "");
//			Thread.sleep(1000);
//			System.out.println("Scrolled time:-"+i);
//		}
		
		driver.navigate().refresh();
		Thread.sleep(3000);
		
		System.out.println("clicking on buy now button");
		WebElement buyNowBtn = driver.findElement(By.xpath("//input[@value='Buy Now']"));
		buyNowBtn.click();
		
		for(int i=0;i<1;i++) {
			JavascriptExecutor jse1 = (JavascriptExecutor) driver;
			jse1.executeScript("window.scrollBy(0,250)", "");
			Thread.sleep(1000);
			System.out.println("Scrolled time:-"+i);
		}
		
		System.out.println("Entering user details");
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
		
		
		for(int i=0;i<1;i++) {
			JavascriptExecutor jse2 = (JavascriptExecutor) driver;
			jse2.executeScript("window.scrollBy(0,550)", "");
			Thread.sleep(1000);
			System.out.println("Scrolled time:-"+i);
		}
		
		System.out.println("Entering credit card details");
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
		
		for(int i=0;i<2;i++) {
			JavascriptExecutor jse3 = (JavascriptExecutor) driver;
			jse3.executeScript("window.scrollBy(0,550)", "");
			Thread.sleep(1000);
			System.out.println("Scrolled time:-"+i);
		}
		
				
		Select hearAboutDD =new Select(driver.findElement(By.id("dropdownHduSource")));
		hearAboutDD.selectByVisibleText("Google Ads");
		
		for(int i=0;i<1;i++) {
			JavascriptExecutor jse4 = (JavascriptExecutor) driver;
			jse4.executeScript("window.scrollBy(0,250)", "");
			Thread.sleep(1000);
			System.out.println("Scrolled time:-"+i);
		}
		
		WebElement orderComment = driver.findElement(By.xpath("//*[@name='comment']"));
		orderComment.sendKeys("Hurry...!!!");
		
		WebElement termsChkBox = driver.findElement(By.xpath("//input[@name='confirm_terms']"));
		termsChkBox.click();
		
		
		WebElement confirmOrderBtn = driver.findElement(By.xpath("//*[contains(text(),'CONFIRM ORDER')]"));
		
		//confirmOrderBtn.click();
		
		System.out.println("Execution completed successfully");

		driver.quit();

	}

}