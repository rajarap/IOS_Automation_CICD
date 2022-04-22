package com.cs.arris.Utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.cs.arris.Base.ParentClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EmailTest extends ParentClass{

	public TestUtils utils = new TestUtils();
	public static WebDriver driver;
	public String content;
	public String otpCode;
		
//		public String getValidOTP(String emailId) 
//		{
//			utils.log().info("Get Valid OTP for : " + emailId);
//			 
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//				  
//			driver.manage().window().maximize();
//			super.pause(5);
//			driver.get("https://mail7.io");
//			super.pause(5);
//			
//			//click login
//			//enter username
//			//enter password
//			//click login button
//			//pause(10)
//			//popup comes up   id = popupusername
//			//click Inbox button  xpath = /html/body/div[5]/div/div[3]/button[1]
//			
//			driver.findElement(By.xpath("/html/body/main/section[2]/div/form/div[1]/input[1]")).sendKeys(emailId); 
//			super.pause(5);
//			driver.findElement(By.xpath("/html/body/main/section[2]/div/form/div[1]/input[2]")).click();  //Go to inbox
//			super.pause(5);
//			driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[4]/div/div[1]/div[1]/div/div[2]/p/a[1]")).click();
//			super.pause(5);
//			driver.findElement(By.id("loginradius-login-emailid")).sendKeys("prabhu.rajarathinam@mobileprogramming.com");
//			super.pause(2);
//			driver.findElement(By.id("loginradius-login-password")).sendKeys("mail7io");
//			super.pause(2);
//			driver.findElement(By.xpath("/html/body/div[2]/div[5]/div/div/div/div/div/div/div/main/div/div/ul[2]/li/div[2]/div[1]/b")).click();
//			super.pause(5);
//			driver.switchTo().frame(0);
//			content = driver.findElement(By.xpath("/html/body")).getText(); 
//			driver.switchTo().defaultContent();
//			driver.findElement(By.xpath("//*[@id=\"message\"]/div[1]/a/div/span")).click();
//		    otpCode = getOTPCode(content);
//			super.pause(3);
//			utils.log().info("OTP CODE : " + otpCode);
//			driver.close();
//			return otpCode;
//		}
		
		public String getValidOTP(String emailId) 
		{
			utils.log().info("Get Valid OTP for : " + emailId);
			 
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
				  
			driver.manage().window().maximize();
			super.pause(5);
			driver.get("https://www.mailinator.com");
			super.pause(2);
			driver.findElement(By.xpath("//*[@id=\"search\"]")).sendKeys(emailId);
			super.pause(2);
			driver.findElement(By.xpath("//*[@id=\"site-header\"]/div[1]/div/div/div[1]/div/button")).click(); //GO button
			super.pause(5);
			driver.findElement(By.xpath("/html/body/div/main/div[2]/div[3]/div/div[4]/div/div/table/tbody/tr/td[2]")).click();
			super.pause(5);
			driver.switchTo().frame("html_msg_body");
			content = driver.findElement(By.xpath("/html/body")).getText(); 
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//*[@id=\"email_pane\"]/div/div[1]/div[2]/a")).click();
		    otpCode = getOTPCode(content);
			super.pause(3);
			utils.log().info("OTP CODE : " + otpCode);
			driver.close();
			return otpCode;
		}
				  
		private String getOTPCode(String content) 
		{
			String otpCodePattern = "[^a-zA-Z:!.\"<>\\/=\\-;,\\s*]\\d\\d\\d\\d\\d";
			Pattern p = Pattern.compile(otpCodePattern);
			Matcher m = p.matcher(content); 
			if(m.find())
				return m.group(0);
			 else
				return "No Matcher";
		}
					
				
		public void deleteEmail()
		{
			driver.findElement(By.xpath("//*[@id=\"message\"]/div[1]/a/div/span")).click();
			driver.findElement(By.xpath("//*[@id=\"public_622a32fe60557c00138eb52d\"]/div[1]/div/label")).click();
			driver.findElement(By.xpath("//*[@id=\"depublicemaildeleteall\"]/i")).click();
					
		}
	}

