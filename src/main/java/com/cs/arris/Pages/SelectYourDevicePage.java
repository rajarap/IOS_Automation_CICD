package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class SelectYourDevicePage  extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeOther[@name=\"NavigationBar_Button_Help\"]")
	public MobileElement helpIcon;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Select_Your_Device_Category_Screen_TitleLabel\"]")
	public MobileElement selectYourDeviceMessage;
	
//	@AndroidFindBy (id = "com.arris.sbcBeta:id/product_category_recycler_view") 
//	public MobileElement selectYourDeviceOptions;  //contains both the product category options
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeImage[@name=\"Select_Your_Device_Category_Screen_Image_Deselect[1]\"]")
	public MobileElement selectYourDeviceSurfboardMaxOption; 
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeImage[@name=\"Select_Your_Device_Category_Screen_Image_Deselect[2]\"]")
	public MobileElement selectYourDeviceISBCableWithWifiOption; 
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeImage[@name=\"Select_Your_Device_Category_Screen_Image_Deselect[3]\"]")
	public MobileElement selectYourDeviceISBCableWithoutWifiOption; 
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Select_Your_Device_Category_Screen_Label_Help\"]")
	public MobileElement selectYourDeviceHelpMeWithSelection; 
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Select_Your_Device_Category_Screen_Button\"]")
	public MobileElement selectYourDeviceNextButton; 
	
	
	
	public SelectYourDevicePage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void selectSurfboardMaxOption()
	{
		click(selectYourDeviceSurfboardMaxOption);
		utils.log().info("Select your Device 1 - Selected SURFboard mAX option");
	}
	
	public void clickNextButton()
	{
		if(selectYourDeviceNextButton.isEnabled())
		{
			click(selectYourDeviceNextButton);
			utils.log().info("Select your Device 1 - Clicked Next Button");

		}else {
			selectSurfboardMaxOption();
			clickNextButton();
		}
	}

	@Override
	public boolean isAt() {
		if(selectYourDeviceNextButton.isDisplayed())
		{
			utils.log().info("At Select your Device Page");
			return true;
		}
		else
		{
			utils.log().info("Select your Device Page is not displayed");
			return false;
		}
	}
	
}
