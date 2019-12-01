package com.sos.baseclass;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StarOfService {
	
	public static WebDriver driver;
	public static String url = "https://www.starofservice.in/dir/telangana/hyderabad/hyderabad/plumbing#/form/plumbing";
	public static String radioPage = "When do you require plumbing?";
	public static String skipPage = "Is there anything else that the Plumber needs to know?";
	public static String finalPage = "Where would you like us to notify you about new quotes received on your request?";
	public static String title;
	public static boolean flag = true;
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\StarOfService\\lib\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		Thread.sleep(5000);
		
		title=driver.findElement(By.xpath("//*[@class=\"v2__title___1Covm v2__commonFormTitle___3kSbd\"]")).getText().toString();
		
		while(flag) {
			if(title.equals(finalPage)) {
				System.out.println("End of Script!");
				flag=false;
				driver.quit();
				return;
			}
			
			if(title.equals(skipPage)) {
				click("//button[text()=\"Skip\"]");
			}
					
			click("//*[@class=\"styles__itemV2___1Vo1Z styles__itemBase___rDyIf\"]");
			click("//button[text()=\"Next\"]");
			Thread.sleep(5000);
			wait(30);
			title=driver.findElement(By.xpath("//*[@class=\"v2__title___1Covm v2__commonFormTitle___3kSbd\"]")).getText().toString();
		}
	}
	
	public static void click(String xpath) throws InterruptedException {
		driver.findElement(By.xpath(xpath)).click();
		Thread.sleep(2000);	
	}
	
	public static void wait(int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
}
