package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;


public class GetStartedPage extends ParentClass implements Page
{
	TestUtils utils = new TestUtils();
	SoftAssert softAssert;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Lets_Get_Started_Screen_TitleLabel_GetStarted\"]")
	private MobileElement getStartedMessage;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeImage[@name=\"Lets_Get_Started_Screen_Image_Surfboard\"]")
	private MobileElement getStartedImage;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Lets_Get_Started_Screen_Button_GetStarted\"]")
	private MobileElement getStartedButton;
	
	public GetStartedPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void clickGetStartedButton() 
	{
		this.getGetStartedTitle();
		this.getGetStartedImage();
		
		if(getStartedButton.isDisplayed()) {
			click(getStartedButton);
			utils.log().info("Clicked on Get Started Button");
		}else {
			utils.log().info("Get Started Button is not displayed");
		}

	}
		
	public void getGetStartedImage()
	{
		if(getStartedImage.isDisplayed())
			utils.log("Get Started Image is displayed");
		else
			utils.log("Image on the Get Started page is not displayed");
	}
	
	  public void getGetStartedTitle() 
	  {
		  if(getStartedMessage.isDisplayed())
			  utils.log("Title : " + getStartedMessage.getText() + " is displayed");
			else
			  utils.log("Get Started Title is not displayed");

	  }

	@Override
	public boolean isAt() {
		if(getStartedButton.isDisplayed())
		{
			utils.log().info("On Get Started Page");
			return true;
		}
		else
		{
			utils.log().info("Not On Get Started Page");
			return false;
		}
	}
}
