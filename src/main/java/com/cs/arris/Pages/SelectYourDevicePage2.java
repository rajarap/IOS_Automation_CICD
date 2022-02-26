package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class SelectYourDevicePage2 extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"NavigationBar_Button_Help\"]")
	public MobileElement helpIcon;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Select_Your_Device_Screen_TitleLabel\"]")
	public MobileElement selectYourDeviceMessage;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeImage[@name=\"Select_Your_Device_Router_Selection_Screen_Image_Box[1]\"]")
	public MobileElement selectYourDeviceMaxProAX11000RadioButton;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeImage[@name=\"Select_Your_Device_Router_Selection_Screen_Image_Box[2]\"]")
	public MobileElement selectYourDeviceMaxPlusAX7800RadioButton;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeImage[@name=\"Select_Your_Device_Router_Selection_Screen_Image_Box[3]\"]")
	public MobileElement selectYourDeviceMaxAX6600;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeImage[@name=\"Select_Your_Device_Router_Selection_Screen_Image_Box[4]\"]")
	public MobileElement selectYourDeviceMaxDashAC3800;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"App Store Link\"]")
	public MobileElement selectYourDevicePlayStoreLink;	
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Select_Your_Device_Screen_Label_Note\"]")
	public MobileElement productDescription;	

	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"Select_Your_Device_Screen_Button\"]")
	public MobileElement selectYourDeviceNextButton;
	
	public SelectYourDevicePage2()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void selectMaxProAX11000RadioButton()
	{
		String selector = "**/XCUIElementTypeImage[`name == \"Select_Your_Device_Router_Selection_Screen_Image_Box[1]\"`]";
		super.getDriver().findElement(MobileBy.iOSClassChain(selector)).click();
//		if(selectYourDeviceMaxProAX11000RadioButton.isDisplayed())
//			click(selectYourDeviceMaxProAX11000RadioButton);
		utils.log().info("Select your Device 2 - Selected mAX Pro AX11000 option");
	}
	
	public void selectMaxProAX7800RadioButton()
	{
		String selector = "**/XCUIElementTypeImage[`name == \"Select_Your_Device_Router_Selection_Screen_Image_Box[2]\"`]";
		super.getDriver().findElement(MobileBy.iOSClassChain(selector)).click();
		
//		if(selectYourDeviceMaxPlusAX7800RadioButton.isDisplayed())
//			click(selectYourDeviceMaxPlusAX7800RadioButton);
		utils.log().info("Select your Device 2 - Selected mAX Pro AX7800 option");
	}
	public void clickNextButton()
	{
		if(selectYourDeviceNextButton.isEnabled())
		{
			click(selectYourDeviceNextButton);
			utils.log().info("Select your Device 2 - Clicked Next Button");
//		}else {
//			selectMaxProAX11000RadioButton();
//			clickNextButton();
		}
	}
	
	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}
	
}




