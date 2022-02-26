package com.cs.arris.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.Select;

import com.cs.arris.Base.ParentClass;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GetOTPFromNada extends ParentClass
{
	public WebDriver webdriver;
	public String byLinkTextVerificationCodeLink = "Your verification code";
	public String email_body_content ;
	public String byLinkTextgoBackToInbox = "Go Back to Inbox";
	public String byClassNamelistBox = "cursor-pointer";
	public String byXpathAddInboxButton = "//*[@id=\"__layout\"]/div/div/div[2]/div/div[1]/div/div/p/span[1]/div/span";
	public String byXpathAddNowButton = "//*[@id=\"__layout\"]/div/div/div[2]/nav/div[2]/div/div/div/form/button";
	public String byXpathEmalIDButton = "//*[@id=\"__layout\"]/div/div/div[2]/div/div[1]/div/div/p/span[1]/a/button";
	public String byXpathDeleteButton = "//*[@id=\"__layout\"]/div/div/div[2]/div/div[1]/div/div/div[1]/div[2]/table/tbody/tr/td[3]";
	public String byIdUsername = "grid-first-name";
	public String byClassNameSelectDomain = "md:items-stretch";
	public String passCode;
	public String newEmailAddress;
	
	public GetOTPFromNada()
	{
		//driver = new SafariDriver();	
		
		//WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions(); 
		options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
		options.addArguments("user-data-dir=/Users/prabhu/Library/Application Support/Google/Chrome/Default");
//		options.addArguments("--headless");
		webdriver = new ChromeDriver(options);
		webdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public String createNewEmailAddress(String emailAddress)
	{
		this.newEmailAddress = emailAddress;
		try 
		{
			webdriver.navigate().to("https://getnada.com");
			Thread.sleep(5);
			webdriver.findElement(By.className(byClassNamelistBox)).click();
			webdriver.findElement(By.className(byXpathAddInboxButton)).click();
			super.waitForVisibility(driver.findElement(By.id(byIdUsername)));
			webdriver.findElement(By.id(byIdUsername)).sendKeys(newEmailAddress);
			WebElement domain = webdriver.findElement(By.className("byClassNameSelectDomain"));
			Select select = new Select(domain);
			select.selectByVisibleText("@getnada.com");
			webdriver.findElement(By.className(byXpathAddNowButton)).click();
			webdriver.close();
			webdriver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return passCode;
	}
	
	public String getPassCode(String emailAddress)
	{
		try 
		{
			webdriver.navigate().to("https://getnada.com");
			Thread.sleep(5);
			webdriver.findElement(By.xpath(byXpathEmalIDButton)).sendKeys(emailAddress);
			Thread.sleep(3);
			webdriver.findElement(By.linkText(byLinkTextVerificationCodeLink));
			email_body_content = webdriver.findElement(By.xpath("/html/body/text()")).getText();  //Your verification code is 221404. 
			passCode = getOTPCode(email_body_content);
			webdriver.close();
			webdriver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return passCode;
	}
	
	private String getOTPCode(String content) {
		String[] contents = content.split(" ");
		for(String s : contents)
		{
			System.out.println(s + "\n");
		}
		String code = contents[contents.length-1];
		return code.substring(0, 6);
	}
	
	private void deleteEmail(WebDriver driver)
	{
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath(byXpathDeleteButton));
	}

}
