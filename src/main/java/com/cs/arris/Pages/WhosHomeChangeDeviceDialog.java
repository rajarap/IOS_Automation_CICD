package com.cs.arris.Pages;

import java.util.List;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.Direction;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class WhosHomeChangeDeviceDialog extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"WH_HouseholdAddDeviceSelectedPopup_Screen_Button_Close\"]")
	public MobileElement closeButton;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"WH_HouseholdAddDeviceSelectedPopup_Screen_TitleLabel\"]")
	public MobileElement changeDeviceTitle;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"WH_HouseholdAddDeviceSelectedPopup_Screen_View_PageIndicator\"]")
	public MobileElement pageIndicator;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"WH_HouseholdAddDeviceSelectedPopup_Screen_Button_Info\"]")
	public MobileElement infoIcon;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Pick a dedicated mobile device which can track Member12’s entry and exit.\"]")
	public MobileElement infoText;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"WH_HouseholdAddDeviceSelectedPopup_Screen_Label_Member\"]")
	public MobileElement memberNameLabel;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"WH_HouseholdAddDeviceSelectedPopup_Screen_Button_Phone'\"]")
	public MobileElement phoneIcon;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"WH_HouseholdAddDeviceSelectedPopup_Screen_Button_Tab\"]")
	public MobileElement tabIcon;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"WH_HouseholdAddDeviceSelectedPopup_Screen_Button_Computer\"]")
	public MobileElement computerIcon;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"WH_HouseholdAddDeviceSelectedPopup_Screen_Button_Iot\"]")
	public MobileElement iotIcon;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"WH_HouseholdAddDeviceSelectedPopup_Screen_Button_Update\"]")
	public MobileElement updateButton;
	
	
	public WhosHomeChangeDeviceDialog() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public boolean clickUpdateButton() {
		if (updateButton.isDisplayed()) {
			click(updateButton);
			utils.log().info("Clicked on Update Button");
			return true;
		} else {
			utils.log().info("Update Button is not displayed");
			return false;
		}
	}
	
	public boolean clickCloseButton() {
		if (closeButton.isDisplayed()) {
			click(closeButton);
			utils.log().info("Clicked on Close Button");
			return true;
		} else {
			utils.log().info("Close Button is not displayed");
			return false;
		}
	}
	
	public boolean clickPhoneButton() {
		if (phoneIcon.isDisplayed()) {
			click(phoneIcon);
			utils.log().info("Clicked on Phone Button");
			return true;
		} else {
			utils.log().info("Phone Button is not displayed");
			return false;
		}
	}
	
	public boolean clickTabButton() {
		if (tabIcon.isDisplayed()) {
			click(tabIcon);
			utils.log().info("Clicked on Tab Button");
			return true;
		} else {
			utils.log().info("Tab Button is not displayed");
			return false;
		}
	}
	
	public boolean clickComputerButton() {
		if (computerIcon.isDisplayed()) {
			click(computerIcon);
			utils.log().info("Clicked on Computer Button");
			return true;
		} else {
			utils.log().info("Computer Button is not displayed");
			return false;
		}
	}
	
	public boolean clickIOTButton() {
		if (iotIcon.isDisplayed()) {
			click(iotIcon);
			utils.log().info("Clicked on IOT Button");
			return true;
		} else {
			utils.log().info("IOT Button is not displayed");
			return false;
		}
	}
	
	public boolean clickInfoIcon() {
		if (infoIcon.isDisplayed()) {
			click(infoIcon);
			utils.log().info("Clicked on Info Button");
			return true;
		} else {
			utils.log().info("Info Button is not displayed");
			return false;
		}
	}


	public boolean verifyPickADeviceDialogUI() {
		
		utils.log().info("                                                ");
		utils.log().info("************************************************");
		utils.log().info("Details of UI Elements on Whos Home Welcome Page");
		utils.log().info("************************************************");
		try {
			if (changeDeviceTitle.isDisplayed())
				utils.log().info(changeDeviceTitle.getText() + " text is displayed");
			else
				utils.log().info("CHANGE A DEVICE Text is not displayed");

			if (pageIndicator.isDisplayed())
				utils.log().info("Page Indicator Image is displayed");
			else
				utils.log().info("age Indicator  Image is not displayed");
			
			if (infoIcon.isDisplayed())
				utils.log().info("Info icon is displayed");
			else
				utils.log().info("Info Icon is not displayed");

			if (memberNameLabel.isDisplayed())
				utils.log().info(memberNameLabel.getText() + " text is displayed");
			else
				utils.log().info("Household memeber name is not displayed");

			if (phoneIcon.isDisplayed())
				utils.log().info("Phone button is displayed");
			else
				utils.log().info("Phone button is not displayed");
			
			if (tabIcon.isDisplayed())
				utils.log().info("Tab button is displayed");
			else
				utils.log().info("Tab button is not displayed");
			
			if (computerIcon.isDisplayed())
				utils.log().info("Conputer button is displayed");
			else
				utils.log().info("Conputer button is not displayed");
			
			if (iotIcon.isDisplayed())
				utils.log().info("IOT button is displayed");
			else
				utils.log().info("IOT button is not displayed");
			
			if (updateButton.isDisplayed())
				utils.log().info("Update button is displayed");
			else
				utils.log().info("Update button is not displayed");
			
			if (closeButton.isDisplayed())
				utils.log().info("Close button is displayed");
			else
				utils.log().info("Close button is not displayed");

			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean verifyPickAPhoneDevice() {
		utils.log().info("                                                       ");
		utils.log().info("*******************************************************");
		utils.log().info("Details of Phone Devices Listed in Pick A Device Dialog");
		utils.log().info("*******************************************************");

			int size = super.getDriver().findElements(MobileBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable")).size();
			utils.log().info("Count of Phone Devices is : " + size);
			
			if(size != 0)
			{
				for (int i = 1; i <= size; i++) {
					utils.log().info("Phone Device  : " + i);
					utils.log().info("--------------------------");
							
					List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
					"//XCUIElementTypeApplication[@name=\"SBC Test\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell["+i+"]");

					for (MobileElement e : entity) {
						try {								     
						if (super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"WH_HouseholdAddDeviceSelectedPopup_Screen_Label_Device["+i+"]\"]").isDisplayed())
							utils.log().info("Phone Device Name " + " : "
									+ super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"WH_HouseholdAddDeviceSelectedPopup_Screen_Label_Device["+i+"]\"]").getText());
						} catch (Exception exp) {
							utils.log().info("Phone Device Name is not displayed ");
						}
						
						try {
						if (super.getDriver().findElementByXPath("//XCUIElementTypeButton[@name=\"WH_HouseholdAddDeviceSelectedPopup_Screen_Button_Device["+i+"]\"]").isDisplayed())
							utils.log().info("Phone Device Radio Button is displayed ");
						} catch (Exception exp) {
							utils.log().info("Phone Device Radio Button is not displayed ");
						}
						utils.log().info("****************************************************");
						utils.log().info("                                                    ");
					}
					if(i >= 2) super.swipeUp();
				}
				
			return true;
			}else {
				utils.log().info("Currently there are no phone devices listed in the Pick A Device dialog");
				return true;
			}
	}
	
	public boolean verifyPickATabDevice() {
		utils.log().info("                                                     ");
		utils.log().info("*****************************************************");
		utils.log().info("Details of Tab Devices Listed in Pick A Device Dialog");
		utils.log().info("*****************************************************");

		int size = super.getDriver().findElements(MobileBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable")).size();
		utils.log().info("Count of Tab Devices is : " + size);
		
		if(size != 0)
		{
			for (int i = 1; i <= size; i++) {
				utils.log().info("Tab Device  : " + i);
				utils.log().info("--------------------------");
						
				List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
				"//XCUIElementTypeApplication[@name=\"SBC Test\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell["+i+"]");

				for (MobileElement e : entity) {
					try {								     
					if (super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"WH_HouseholdAddDeviceSelectedPopup_Screen_Label_Device["+i+"]\"]").isDisplayed())
						utils.log().info("Tab Device Name " + " : "
								+ super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"WH_HouseholdAddDeviceSelectedPopup_Screen_Label_Device["+i+"]\"]").getText());
					} catch (Exception exp) {
						utils.log().info("Tab Device Name is not displayed ");
					}
					
					try {
					if (super.getDriver().findElementByXPath("//XCUIElementTypeButton[@name=\"WH_HouseholdAddDeviceSelectedPopup_Screen_Button_Device["+i+"]\"]").isDisplayed())
						utils.log().info("Tab Device Radio Button is displayed ");
					} catch (Exception exp) {
						utils.log().info("Tab Device Radio Button is not displayed ");
					}
					utils.log().info("****************************************************");
					utils.log().info("                                                    ");
				}
				if(i >= 2) super.swipeUp();
			}
			return true;
		}else {
			utils.log().info("Currently there are no Tab devices listed in the Pick A Device dialog");
			return true;
		}

	}
	
	public boolean verifyPickAComputerDevice() {
		utils.log().info("                                                          ");
		utils.log().info("**********************************************************");
		utils.log().info("Details of Computer Devices Listed in Pick A Device Dialog");
		utils.log().info("**********************************************************");

		int size = super.getDriver().findElements(MobileBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable")).size();
		utils.log().info("Count of Computer Devices is : " + size);
		
		if(size != 0)
		{
			for (int i = 1; i <= size; i++) {
				utils.log().info("Computer Device  : " + i);
				utils.log().info("--------------------------");
						
				List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
				"//XCUIElementTypeApplication[@name=\"SBC Test\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell["+i+"]");

				for (MobileElement e : entity) {
					try {								     
					if (super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"WH_HouseholdAddDeviceSelectedPopup_Screen_Label_Device["+i+"]\"]").isDisplayed())
						utils.log().info("Computer Device Name " + " : "
								+ super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"WH_HouseholdAddDeviceSelectedPopup_Screen_Label_Device["+i+"]\"]").getText());
					} catch (Exception exp) {
						utils.log().info("Computer Device Name is not displayed ");
					}
					
					try {
					if (super.getDriver().findElementByXPath("//XCUIElementTypeButton[@name=\"WH_HouseholdAddDeviceSelectedPopup_Screen_Button_Device["+i+"]\"]").isDisplayed())
						utils.log().info("Computer Device Radio Button is displayed ");
					} catch (Exception exp) {
						utils.log().info("Computer Device Radio Button is not displayed ");
					}
					utils.log().info("****************************************************");
					utils.log().info("                                                    ");
				}
				if(i >= 2) super.swipeUp();
			}
			return true;
		}else {
			utils.log().info("Currently there are no Computer devices listed in the Pick A Device dialog");
			return true;
		}
	}
	
	public boolean verifyPickAIOTDevice() {
		utils.log().info("                                                     ");
		utils.log().info("*****************************************************");
		utils.log().info("Details of IOT Devices Listed in Pick A Device Dialog");
		utils.log().info("*****************************************************");

		int size = super.getDriver().findElements(MobileBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable")).size();
		utils.log().info("Count of IOT Devices is : " + size);
		
		if(size != 0)
		{
			for (int i = 1; i <= size; i++) {
				utils.log().info("IOT Device  : " + i);
				utils.log().info("-------------------");
						
				List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
				"//XCUIElementTypeApplication[@name=\"SBC Test\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell["+i+"]");

				for (MobileElement e : entity) {
					try {								     
					if (super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"WH_HouseholdAddDeviceSelectedPopup_Screen_Label_Device["+i+"]\"]").isDisplayed())
						utils.log().info("IOT Device Name " + " : "
								+ super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"WH_HouseholdAddDeviceSelectedPopup_Screen_Label_Device["+i+"]\"]").getText());
					} catch (Exception exp) {
						utils.log().info("IOT Device Name is not displayed ");
					}
					
					try {
					if (super.getDriver().findElementByXPath("//XCUIElementTypeButton[@name=\"WH_HouseholdAddDeviceSelectedPopup_Screen_Button_Device["+i+"]\"]").isDisplayed())
						utils.log().info("IOT Device Radio Button is displayed ");
					} catch (Exception exp) {
						utils.log().info("IOT Device Radio Button is not displayed ");
					}
					utils.log().info("****************************************************");
					utils.log().info("                                                    ");
				}
				if(i >= 2) super.swipeUp();
			}
			return true;
		}else {
			utils.log().info("Currently there are no Computer devices listed in the Pick A Device dialog");
			return true;
		}
	}
	
	public boolean pickAIOTDevice() {

		int size = super.getDriver().findElements(MobileBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable")).size();
		utils.log().info("Count of IOT Devices is : " + size);
		
		if(size != 0)
		{
			for (int i = 1; i <= 1; i++) {
				utils.log().info("Selecting IOT Device  : " + i);
				utils.log().info("----------------------------");
						
				List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
				"//XCUIElementTypeApplication[@name=\"SBC Test\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell["+i+"]");

				for (MobileElement e : entity) {
					try {								     
					if (e.findElementByXPath("//XCUIElementTypeStaticText[@name=\"WH_HouseholdAddDeviceSelectedPopup_Screen_Label_Device["+i+"]\"]").isDisplayed())
						utils.log().info("Selecting IOT Device Name " + " : "
								+ e.findElementByXPath("//XCUIElementTypeStaticText[@name=\"WH_HouseholdAddDeviceSelectedPopup_Screen_Label_Device["+i+"]\"]").getText());
					} catch (Exception exp) {
						utils.log().info("IOT Device Name is not displayed ");
					}
					
					try {
					if (e.findElementByXPath("//XCUIElementTypeButton[@name=\"WH_HouseholdAddDeviceSelectedPopup_Screen_Button_Device["+i+"]\"]").isDisplayed())
						click(e.findElementByXPath("//XCUIElementTypeButton[@name=\"WH_HouseholdAddDeviceSelectedPopup_Screen_Button_Device["+i+"]\"]"));
						utils.log().info("IOT Device Radio Button is selected");
					} catch (Exception exp) {
						utils.log().info("IOT Device Radio Button is not displayed ");
					}
					utils.log().info("****************************************************");
					utils.log().info("                                                    ");
				}
			}
			return true;
		}else {
			utils.log().info("Currently there are no IOT devices listed in the Pick A Device dialog");
			return true;
		}
	}
	
	public boolean pickAPhoneDevice() {
		int size = super.getDriver().findElements(MobileBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable")).size();
		utils.log().info("Count of Phone Devices is : " + size);
		
		if(size != 0)
		{
			for (int i = 1; i <= 1; i++) {
				utils.log().info("Selecting Phone Device  : " + i);
				utils.log().info("------------------------------");
						
				List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
				"//XCUIElementTypeApplication[@name=\"SBC Test\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell["+i+"]");

				for (MobileElement e : entity) {
					try {								     
					if (super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"WH_HouseholdAddDeviceSelectedPopup_Screen_Label_Device["+i+"]\"]").isDisplayed())
						utils.log().info("Selecting Phone Device Name " + " : "
								+ super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"WH_HouseholdAddDeviceSelectedPopup_Screen_Label_Device["+i+"]\"]").getText());
					} catch (Exception exp) {
						utils.log().info("Phone Device Name is not displayed ");
					}
					
					try {
					if (super.getDriver().findElementByXPath("//XCUIElementTypeButton[@name=\"WH_HouseholdAddDeviceSelectedPopup_Screen_Button_Device["+i+"]\"]").isDisplayed())
						click(super.getDriver().findElementByXPath("//XCUIElementTypeButton[@name=\"WH_HouseholdAddDeviceSelectedPopup_Screen_Button_Device["+i+"]\"]"));
						utils.log().info("Phone Device Radio Button is selected");
					} catch (Exception exp) {
						utils.log().info("Phone Device Radio Button is not displayed ");
					}
					utils.log().info("****************************************************");
					utils.log().info("                                                    ");
				}
			}
			return true;
		}else {
			utils.log().info("Currently there are no Phone devices listed in the Pick A Device dialog");
			return true;
		}
	}
	
	public boolean pickATabDevice() {
	
		int size = super.getDriver().findElements(MobileBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable")).size();
		utils.log().info("Count of Tab Devices is : " + size);
		
		if(size != 0)
		{
			for (int i = 1; i <= 1; i++) {
				utils.log().info("Selecting Tab Device  : " + i);
				utils.log().info("------------------------------");
						
				List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
				"//XCUIElementTypeApplication[@name=\"SBC Test\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell["+i+"]");

				for (MobileElement e : entity) {
					try {								     
					if (super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"WH_HouseholdAddDeviceSelectedPopup_Screen_Label_Device["+i+"]\"]").isDisplayed())
						utils.log().info("Selecting Tab Device Name " + " : "
								+ super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"WH_HouseholdAddDeviceSelectedPopup_Screen_Label_Device["+i+"]\"]").getText());
					} catch (Exception exp) {
						utils.log().info("Tab Device Name is not displayed ");
					}
					
					try {
					if (super.getDriver().findElementByXPath("//XCUIElementTypeButton[@name=\"WH_HouseholdAddDeviceSelectedPopup_Screen_Button_Device["+i+"]\"]").isDisplayed())
						click(super.getDriver().findElementByXPath("//XCUIElementTypeButton[@name=\"WH_HouseholdAddDeviceSelectedPopup_Screen_Button_Device["+i+"]\"]"));
						utils.log().info("Tab Device Radio Button is selected");
					} catch (Exception exp) {
						utils.log().info("Tab Device Radio Button is not displayed ");
					}
					utils.log().info("****************************************************");
					utils.log().info("                                                    ");
				}
			}
			return true;
		}else {
			utils.log().info("Currently there are no Tab devices listed in the Pick A Device dialog");
			return true;
		}
	}
	
	public boolean pickAComputerDevice() {
		int size = super.getDriver().findElements(MobileBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable")).size();
		utils.log().info("Count of Computer Devices is : " + size);
		
		if(size != 0)
		{
			for (int i = 1; i <= 1; i++) {
				utils.log().info("Selecting Computer Device  : " + i);
				utils.log().info("---------------------------------");
						
				List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
				"//XCUIElementTypeApplication[@name=\"SBC Test\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell["+i+"]");

				for (MobileElement e : entity) {
					try {								     
					if (super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"WH_HouseholdAddDeviceSelectedPopup_Screen_Label_Device["+i+"]\"]").isDisplayed())
						utils.log().info("Selecting Computer Device Name " + " : "
								+ super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"WH_HouseholdAddDeviceSelectedPopup_Screen_Label_Device["+i+"]\"]").getText());
					} catch (Exception exp) {
						utils.log().info("Computer Device Name is not displayed ");
					}
					
					try {
					if (super.getDriver().findElementByXPath("//XCUIElementTypeButton[@name=\"WH_HouseholdAddDeviceSelectedPopup_Screen_Button_Device["+i+"]\"]").isDisplayed())
						click(super.getDriver().findElementByXPath("//XCUIElementTypeButton[@name=\"WH_HouseholdAddDeviceSelectedPopup_Screen_Button_Device["+i+"]\"]"));
						utils.log().info("Computer Device Radio Button is selected");
					} catch (Exception exp) {
						utils.log().info("Computer Device Radio Button is not displayed ");
					}
					utils.log().info("****************************************************");
					utils.log().info("                                                    ");
				}
			}
			return true;
		}else {
			utils.log().info("Currently there are no Computer devices listed in the Pick A Device dialog");
			return true;
		}
	}

	@Override
	public boolean isAt() {
		if (changeDeviceTitle.isDisplayed()) {
			utils.log().info("On CHANGE A DEVICE Dialog");
			return true;
		} else {
			utils.log().info("Not on CHANGE A DEVICE Dialog");
			return false;
		}
	}
}
