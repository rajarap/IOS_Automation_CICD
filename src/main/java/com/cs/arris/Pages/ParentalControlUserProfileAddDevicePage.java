package com.cs.arris.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.Direction;
import com.cs.arris.Utilities.SwipeActions;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ParentalControlUserProfileAddDevicePage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	public List<String> deviceList = new ArrayList<String>();
	public int deviceListSize;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Parental_Control_Device_List_Screen_NavigationBar_TitleLabel\"]") 
	public MobileElement addDeviceTitle; 
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Parental_Control_Device_List_Screen_NavigationBar_Button_Back\"]")
	public MobileElement backButton; 
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Parental_Control_Device_List_Screen_NavigationBar_Button_Help\"]")
	public MobileElement helpIcon; 
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Parental_Control_Profiles_Screen_Button_EditProfileSave\"]")
	public MobileElement cloudIcon;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Parental_Control_Device_List_Screen_Button_Add\"]") 
	public MobileElement addDeviceButton;
	
	
	//Click Add Device Button without selecting any devices
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Parental_Control_Device_List_Screen_Label_Error\"]")
	public MobileElement alertTitle;

//	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Parental_Control_Profiles_Screen_Button_EditProfileSave\"]")
//	public MobileElement description;
//
//	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Parental_Control_Profiles_Screen_Button_EditProfileSave\"]")
//	public MobileElement closeIcon;
//
//	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Parental_Control_Profiles_Screen_Button_EditProfileSave\"]")
//	public MobileElement okButton;

	//Click Add Device Button without selecting any devices
	
	public ParentalControlAddDeviceHelpPage getParentalAddDeviceHelpPageObject(){
		ParentalControlAddDeviceHelpPage addDeviceHelpPage = new ParentalControlAddDeviceHelpPage();
		return addDeviceHelpPage;
	}
	
	public ParentalControlUserProfileAddDevicePage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public boolean clickBackButton() {
		if (backButton.isDisplayed()) {
				click(backButton);
				utils.log().info("Clicked on Back Button");
				return true;
		} else {
			utils.log().info("Back Button is not displayed");
			return false;
		}
	}

	public boolean clickHelpIcon() {
		if (helpIcon.isDisplayed()) {
			click(helpIcon);
			utils.log().info("Clicked on Help Icon");
			return true;
		} else {
			utils.log().info("Help Icon is not displayed");
			return false;
		}
	}
	
	public boolean clickAddDeviceButton()
	{
		if(addDeviceButton.isDisplayed()) {
			click(addDeviceButton); 
			utils.log().info("Clicked on Add Device Button");
			return true;
		} else {
			utils.log().info("Add Device button is not displayed");
			return false;
		}
	}
	
//	public boolean clickOKButtonOnAlertDialog()	{
//		if(okButton.isDisplayed()) {
//			click(okButton); 
//			utils.log().info("Clicked OK button on Alert Dialog");
//			return true;
//		} else {
//			utils.log().info("Alert dialog did not appear");
//			return false;
//		}
//	}
//	
//	public boolean clickCloseButtonOnAlertDialog()	{
//		if(closeIcon.isDisplayed()) {
//			click(closeIcon); 
//			utils.log().info("Clicked Close button on Alert Dialog");
//			return true;
//		} else {
//			utils.log().info("Alert dialog did not appear");
//			return false;
//		}
//	}
	
	// Add device page should not list the device already associated to the user
//	public boolean verifyDeviceCountAfterAssociatingToUser() {
//		try {
//			int deviceListSizeBeforeAssociation = deviceListSize;
//			int deviceListSizeAfterAssociation = super.deviceNames.size();
//			int result = deviceListSizeBeforeAssociation - deviceListSizeAfterAssociation;
//			return true;
//		} catch (Exception e) {
//			return false;
//		}
//		// utils.log().info("Number of Devices associated to the user is " + result);
//	}
	
	// To verify the devices listed in Add Device Page
	public boolean verifyDevicesInAddDevicePage() {
		utils.log().info("                                     ");
		utils.log().info("*************************************");
		utils.log().info("Devices Listed in the Add Device Page");
		utils.log().info("*************************************");

		//String selector = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable";
		//int size = super.getDriver().findElementsByXPath("//XCUIElementTypeApplication[@name=\"SBC Test\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable").size();
		
		String selector = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable";
		int size = super.getDriver().findElements(MobileBy.iOSClassChain(selector)).size();
		utils.log().info("Count of Devices Listed in the Add Device Page is : " + size);
		
		try {
			for (int i = 1; i <= size ; i++) {
				utils.log().info("Parental Control Add Device : " + i);
				utils.log().info("----------------------------------");

				List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
				"//XCUIElementTypeApplication[@name=\"SBC Test\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell["+i+"]");

				for (MobileElement e : entity) {
					if (super.getDriver().findElementByXPath("//XCUIElementTypeImage[@name=\"Parental_Control_Device_List_Screen_Image_Device["+i+"]\"]").isDisplayed())
						utils.log().info("Device Image is displayed");
					else
						utils.log().info("Device Image is not available : ");

					if (super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Parental_Control_Device_List_Screen_Label_Device["+i+"]\"]").isDisplayed())
						utils.log().info("Device name : " + super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Parental_Control_Device_List_Screen_Label_Device["+i+"]\"]").getText());
					else
						utils.log().info("Device Name is not available ");

					if (super.getDriver().findElementByXPath("//XCUIElementTypeImage[@name=\"Parental_Control_Device_List_Screen_Image_Box["+i+"]\"]").isDisplayed())
						utils.log().info("Check box is displayed ");
					else
						utils.log().info("Check box is not available ");
					utils.log().info("****************************************************");
					utils.log().info("                                                    ");
				}
				if (i >= 5)
					new SwipeActions().swipeScreen(Direction.UP);
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean selectADeviceForUserProfile() {
		utils.log().info("                                           ");
		utils.log().info("*******************************************");
		utils.log().info("Select A Device From the List of Devices   ");
		utils.log().info("*******************************************");

		String selector = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable";
		int size = super.getDriver().findElements(MobileBy.iOSClassChain(selector)).size();
		
			try {
				for (int i = 1; i <= size ; i++) {
//					utils.log().info("Selected Device : " + i);
//					utils.log().info("-----------------------");

					List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
					"//XCUIElementTypeApplication[@name=\"SBC Test\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell["+i+"]");

					for (MobileElement e : entity) {
						if (super.getDriver().findElementByXPath("//XCUIElementTypeImage[@name=\"Parental_Control_Device_List_Screen_Image_Device["+i+"]\"]").isDisplayed())
							utils.log().info("Device Image is displayed");
						else
							utils.log().info("Device Image is not available");

						if (super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Parental_Control_Device_List_Screen_Label_Device["+i+"]\"]").isDisplayed())
							utils.log().info("Device name : " + super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Parental_Control_Device_List_Screen_Label_Device["+i+"]\"]").getText());
						else
							utils.log().info("Device Name is not available ");

						if (super.getDriver().findElementByXPath("//XCUIElementTypeImage[@name=\"Parental_Control_Device_List_Screen_Image_Box["+i+"]\"]").isDisplayed()) {
							click(super.getDriver().findElementByXPath("//XCUIElementTypeImage[@name=\"Parental_Control_Device_List_Screen_Image_Box["+i+"]\"]"));
							utils.log().info("Clicked the check box to select the device for the user ");}
						else
							utils.log().info("Check box is not available ");
							utils.log().info("****************************************************");
							utils.log().info("                                                    ");
					}
				}
				return true;
			} catch (Exception e) {
				return false;}
	}

	 
	public boolean verifyUIOnAddDevicePage() {
		utils.log().info("                                       ");
		utils.log().info("***************************************");
		utils.log().info(" Parental Control  -  Add Device Page  ");
		utils.log().info("***************************************");
		
		try {
			if (addDeviceTitle.isDisplayed())
				utils.log().info("Title - " + addDeviceTitle.getText() + " - is displayed");
			else
				utils.log().info("Add Device Text is not displayed");

			if (backButton.isDisplayed())
				utils.log().info("Back Button is displayed");
			else
				utils.log().info("Back Button is not displayed");

			if (cloudIcon.isDisplayed())
				utils.log().info("Cloud Icon is displayed");
			else
				utils.log().info("Cloud Icon is not displayed");

			if (helpIcon.isDisplayed())
				utils.log().info("Help Icon is displayed");
			else
				utils.log().info("Help Icon is not displayed");

			if (addDeviceButton.isDisplayed())
				utils.log().info("Add Device button is displayed");
			else
				utils.log().info("Add Device button is not displayed");

			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@Override
	public boolean isAt() {
		if(addDeviceTitle.isDisplayed()){
			utils.log().info("On Add Device Page");
			return true;
		}else {
			utils.log().info("Not on Add Device Page");
		return false;}
	}
	
}

