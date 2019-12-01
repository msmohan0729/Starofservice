package com.sos.baseclass;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class StarOfServiceTNG {
	public static WebDriver driver;
	public static String url = "https://www.starofservice.in/dir/telangana/hyderabad/hyderabad/plumbing#/form/plumbing";
	
	@BeforeSuite
	public void launchingBrowser() {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\StarOfService\\lib\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);
		waitForPageLoad(20);
	}
	
	
	@Test
	public void page1() throws InterruptedException {
		//The problems are to do with which of the following things? // page -1
		String pageName=driver.findElement(By.xpath("//*[@id=\"field-85b2127bffbae4814e7a3eb0f34c06661b163fc0\"]/div")).getText().toString();
		System.out.println(pageName);
				
		click("//div[text()= \"Toilet\"]");
		click("//button[text()=\"Next\"]");
		waitForPageLoad(20);
	}
	
	
	@Test
	public void page2() throws InterruptedException {
		//What do you need done? // page - 2
		String pageName = driver.findElement(By.xpath("//*[@id=\"field-961c4f5f5328371a0e5951f97c15664a3c12d4a8\"]/div")).getText().toString();
		System.out.println(pageName);
		
		click("//div[text()= \"Replace\"]");
		click("//button[text()=\"Next\"]");
		waitForPageLoad(20);
	}
	
	
	@Test
	public void page3() throws InterruptedException {
		//What problem(s) do you have? // page -3
		String pageName = driver.findElement(By.xpath("//*[@id=\"field-4c162d5f3ce8efdb800408dd13b216f0ac1a3b1b\"]/div")).getText().toString();
		System.out.println(pageName);
		
		click("//div[text()= \"Leak in a pipe\"]");
		click("//button[text()=\"Next\"]");
		waitForPageLoad(20);
	}
	
	
	@Test
	public void page4() throws InterruptedException {
		// Is there anything else that the Plumber needs to know? // page -4
		String pageName = driver.findElement(By.xpath("//*[@id=\"field-7bd2550347e9ea395a4d4f69e844c370af064034\"]/div[1]")).getText().toString();
		System.out.println(pageName);
	
		click("//button[text()=\"Skip\"]");
		waitForPageLoad(20);
	}
	
	
	@Test
	public void page5() throws InterruptedException {
		 //When do you require plumbing? // page -5
		String pageName = driver.findElement(By.xpath("//*[@id=\"field-825e134dc1d6cc63e9c9daf02e75b4a3e5d08133\"]/div")).getText().toString();
		System.out.println(pageName);

		click("//div[text()= \"I'm flexible\"]");
		click("//button[text()=\"Next\"]");
		waitForPageLoad(20);
	}
	
	
	@Test
	public void page6() throws InterruptedException {
		// 
		Thread.sleep(10000);
		String page2 = driver.findElement(By.xpath("//*[@id=\"field-Where would you like us to notify you about new quotes received on your request?\"]/div")).getText().toString();
		System.out.println(page2);	
	}
	
	
	@AfterSuite
	public void closingBrowser() {
		waitForPageLoad(20);
		driver.quit();
	}
	
	
	public static void click(String xpath) throws InterruptedException {
		driver.findElement(By.xpath(xpath)).click();
		waitForPageLoad(20);
	}
	
	public static void waitForPageLoad(int seconds) {
		driver.manage().timeouts().pageLoadTimeout(seconds, TimeUnit.SECONDS);
	}

}
