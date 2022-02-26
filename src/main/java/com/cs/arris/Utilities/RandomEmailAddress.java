package com.cs.arris.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class RandomEmailAddress 
{
	public  WebDriver driver;
	public  String changeButtonById = "click-to-change";
	public  String copyButtonById = "click-to-copy";
	public  String deleteButtonById = "click-to-delete";
	public  String refreshButtonById = "click-to-refresh";
	public  String emailAddress;
	public  String passCode;
	
	public RandomEmailAddress()
	{
		driver = new SafariDriver();	
		
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();

	}
	
	public String getNewEmailAddress()
	{
		try 
		{
			driver.navigate().to("https://temp-mail.org/en/");
			//driver.findElement(By.id(deleteButtonById)).click();
			Thread.sleep(10);
			driver.findElement(By.id(copyButtonById)).click();
			driver.close();
			emailAddress = (String) Toolkit.getDefaultToolkit()
			        .getSystemClipboard().getData(DataFlavor.stringFlavor);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emailAddress;
	}
	
	public String getPasscode()
	{
		try
		{
			driver.navigate().to("https://temp-mail.org/en/");
			Thread.sleep(5);
			driver.findElement(By.linkText("Your verification code")).click();
			String content = driver.findElement(By.className("inbox-data-content-intro")).getText(); //Your verification code is 988710.
			passCode = getOTPCode(content);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return passCode;
	}
	
	private String getOTPCode(String content) {
		String[] contents = content.split(" ");
		for(String s : contents)
		{
			System.out.println(s);
		}
		String code = contents[contents.length-1];
		return code.substring(0, 6);
	}

}
