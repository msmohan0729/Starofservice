package com.sos.baseclass;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StarOfService {
	
	public static WebDriver driver;
	public static String url = "https://www.starofservice.in/dir/telangana/hyderabad/hyderabad/plumbing#/form/plumbing";
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
		
		waitForPage();
		getPageName();
		
		while(flag) {
			
			if(title.equals(finalPage)) {
				System.out.println("End of Script!");
				flag=false;
				driver.quit();
				return;
			}
			if(title.equals(skipPage)) {
				click("//button[text()=\"Skip\"]");
				getPageName();
				return;
			}
			
			if(title.equals("When do you require plumbing?")) {
				click("//div[text()=\"On a specific date\"]");
				nextbutton();
				getPageName();
				return;
			}
			
			if(title.equals("On what date?")){
				click("//*[@aria-label= \"Tuesday, December 31, 2019\"]");
				nextbutton();
				getPageName();
				return;
			}
			
			if(title.equals("What time do you need the Plumber?")) {
				Select fruits = new Select(driver.findElement(By.xpath("//*[@id=\"2fb1107f62b7900a8af4942e0a0532a856dd41ed\"]")));
				fruits.selectByVisibleText("09:30");
				nextbutton();
				getPageName();
				return;
			}
				
			waitForPage();
			click("//*[@class=\"styles__itemV2___1Vo1Z styles__itemBase___rDyIf\"]");
			nextbutton();
			waitForPage();
			getPageName();
			
		}
	}
	
	private static void getPageName() {
		title=driver.findElement(By.xpath("//*[@class=\"v2__title___1Covm v2__commonFormTitle___3kSbd\"]")).getText().toString();	
	}

	public static void click(String xpath) throws InterruptedException {
		driver.findElement(By.xpath(xpath)).click();
		waitForPage();
	}
	
	public static void waitForPage() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}	
	
	public static void nextbutton() throws InterruptedException {
		click("//button[text()=\"Next\"]");
	}
}
