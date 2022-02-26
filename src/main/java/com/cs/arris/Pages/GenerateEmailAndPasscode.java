package com.cs.arris.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class GenerateEmailAndPasscode extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	public WebDriver webdriver;
	public String newEmailAddress;
	public String emailBodyContent;
	public String passCode;
	
	@FindAll({
		@FindBy (xpath = "//button[@class='mt-4']"),
		@FindBy (xpath = "//button[@text()='Add inboxe']")
	})
	public WebElement addInboxButton;
	
	@FindBy (xpath = "//input[@id='grid-first-name']")
	public WebElement userName;
	
	@FindBy (xpath = "//*[@id=\"__layout\"]/div/div/div[2]/nav/div[2]/div/div/div/form/div/div[2]/select")
	public WebElement domain;
	
	@FindBy (xpath = "//button[@text()='Add now!']")
	public WebElement addNowButton;
	
	@FindBy (linkText = "Your verification code")
	public WebElement yourVerificationCode;
	
	@FindBy (xpath = "/html/body/text()")
	public WebElement emailContent;
	
	public GenerateEmailAndPasscode()
	{
		//PageFactory.initElements(webdriver, this);
		ChromeOptions options = new ChromeOptions(); 
		options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
//		options.addArguments("--headless");
		webdriver = new ChromeDriver(options);
		//webdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public String createEmailAndReturnPassCode(String emailAddress)
	{
		this.newEmailAddress = emailAddress;
		webdriver.navigate().to("https://getnada.com");
		webdriver.findElement(By.xpath("//button[@text()='Add inboxe']")).click();
		webdriver.findElement(By.xpath("//input[@id='grid-first-name']")).sendKeys(this.newEmailAddress);
		Select select = new Select(webdriver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div/div[2]/nav/div[2]/div/div/div/form/div/div[2]/select")));
		select.selectByValue("getnada.com");
		webdriver.findElement(By.xpath("//button[@text()='Add now!']")).click();	
		
		//return passcode
		super.pause(5);
		webdriver.findElement(By.linkText("Your verification code"));
		emailBodyContent = webdriver.findElement(By.xpath("/html/body/text()"));
		passCode = getOTPCode(emailBodyContent);
		webdriver.close();
		webdriver.quit();
		
		return passCode;
	}
	
	public String getPassCode()
	{
		try 
		{
			yourVerificationCode.click();
			emailBodyContent = emailContent.getText();  //Your verification code is 221404. 
			passCode = getOTPCode(emailBodyContent);
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
	

	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}

}
