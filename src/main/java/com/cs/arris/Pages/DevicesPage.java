package com.cs.arris.Pages;

import java.util.List;

import org.openqa.selenium.By;
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

public class DevicesPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();
	HomePage homePage = new HomePage();
	public List<MobileElement> onlineDeviceList;
	public List<MobileElement> offlineDeviceList;
	public MobileElement me;
	public int offlineDeviceCount;
	public int onlineDeviceCount;
	public int counter = 1;
	public String connectedDeviceName;
	public String editedDeviceName;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"NavigationBar_Title\"]")
	public MobileElement onlineDeviceTitle;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"NavigationBar_Title\"]")
	public MobileElement offlineDeviceTitle;

//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Online\"]")
//	public MobileElement cloudIcon;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Online\"]")
	public MobileElement onlineButton;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Offline\"]")
	public MobileElement offlineButton;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Home\"]")
	public MobileElement backButton;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"NavigationBar_Button_Help\"]")
	public MobileElement helpIcon;


	public DevicesPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public int getOnlineDeviceCount() {
		this.getOnlineDevicesCount();
		return onlineDeviceCount;
	}

	public int getOfflineDeviceCount() {
		this.getOfflineDevicesCount();
		return offlineDeviceCount;
	}

	public String getOnlineButtonText() {
		return onlineButton.getText();
	}

	public String getOfflineButton() {
		return offlineButton.getText();
	}

	public String getBackButton() {
		return backButton.getText();
	}

	public DevicesHelpPage getDevicesHelpPageObject() {
		DevicesHelpPage devicesHelpPage = new DevicesHelpPage();
		return devicesHelpPage;
	}

	public EditDeviceNameDialog getEditDeviceNameDialogObject() {
		EditDeviceNameDialog editDeviceNameDialog = new EditDeviceNameDialog();
		return editDeviceNameDialog;
	}
	public FooterIconsPage getFooterIconsPageObject() {
		FooterIconsPage footerIconsPage = new FooterIconsPage();
		return footerIconsPage;
	}

	public boolean clickOnlineTab() {
		if (onlineButton.isDisplayed()) {
			click(onlineButton);
			utils.log().info("Clicked on Online Tab");
			return true;
		} else {
			utils.log().info("Online Tab is not displayed");
			return false;
		}
	}

	public boolean clickOfflineTab() {
		if (offlineButton.isDisplayed()) {
			click(offlineButton);
			utils.log().info("Clicked on Offile Tab");
			return true;
		} else {
			utils.log().info("Offline Tab is not displayed");
			return false;
		}
	}

	public boolean clickBackButton() {
		if (backButton.isDisplayed()) {
			click(backButton);
			utils.log().info("Clicked on Back Button");
			return true;
		} else {
			utils.log().info("Back Tab is not displayed");
			return false;
		}
	}

	public boolean clickHelpButton() {
		if (helpIcon.isDisplayed()) {
			click(helpIcon);
			utils.log().info("Clicked on Help Button");
			return true;
		} else {
			utils.log().info("HElp Tab is not displayed");
			return false;
		}
	}

	public void getOnlineDevicesCount() {
		clickOnlineTab();
		onlineDeviceCount = getCountOfDevices(onlineDeviceTitle.getText());
		utils.log().info("Number of online devices connected to the main mAX Router are : " + onlineDeviceCount);
	}
	
	public void getOnlineDeviceNameCount() {
		onlineDeviceCount = getCountOfDevices(onlineDeviceTitle.getText());
	}

	public void getOfflineDevicesCount() {
		clickOfflineTab();
		utils.log().info("Offline Device Page Title : " + offlineDeviceTitle.getText());
		offlineDeviceCount = getCountOfDevices(offlineDeviceTitle.getText());
		utils.log().info("Number of offline devices connected to the main mAX Router are : " + offlineDeviceCount);
	}

	// To verify the details of online devices
	public boolean verifyOnlineDeviceDetails() {
		this.getOnlineDevicesCount();
		
		utils.log().info("                                                   ");
		utils.log().info("***************************************************");
		utils.log().info("Details of Online Devices Connected to Main Device ");
		utils.log().info("***************************************************");

		if (this.onlineDeviceCount > 0) {
			for (int i = 1; i <= onlineDeviceCount; i++) {
				utils.log().info("Online Device : " + i);
				utils.log().info("----------------------");

				List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
				"//XCUIElementTypeApplication[@name=\"SBC Test\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell["+i+"]");
					
				for (MobileElement e : entity) 
				{	
					super.pause(5);
					click(super.getDriver().findElementByXPath("//XCUIElementTypeButton[@name=\"Device_List_Screen_Button_Expand["+i+"]\"]"));
					
					try {
						if (super.getDriver().findElementByXPath("//XCUIElementTypeImage[@name=\"Device_List_Screen_Image_Device["+i+"]\"]").isDisplayed())
							utils.log().info("Device Image is displayed");
					} catch (Exception exp) {
						utils.log().info("Device Image is not displayed");
					}

					try {
						if (super.getDriver().findElementByXPath("//XCUIElementTypeButton[@name=\"Device_List_Screen_Button_Expand["+i+"]\"]").isDisplayed())
							utils.log().info("Expand Button Image is displayed");
					} catch (Exception exp) {
						utils.log().info("Expand button is not available");
					}

					try {
						if (super.getDriver().findElementByXPath("//XCUIElementTypeButton[@name=\"Device_List_Screen_Label_Device["+i+"]\"]").isDisplayed())
							utils.log().info("Device Name: " + super.getDriver().findElementByXPath("//XCUIElementTypeButton[@name=\"Device_List_Screen_Label_Device["+i+"]\"]").getText());
					} catch (Exception exp) {
						utils.log().info("Device Name is not available ");
					}

					try {
						if (super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_List_Screen_Label_Speed["+i+"]\"]").isDisplayed())
							utils.log().info("Device Signal Strength : " + super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_List_Screen_Label_Speed["+i+"]\"]").getText());
					} catch (Exception exp) {
						utils.log().info("Device Signal Strength is not available ");
					}

					try {
						if (super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_List_Screen_Label_Download["+i+"]\"]").isDisplayed())
							utils.log().info("Device Download Speed : " + super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_List_Screen_Label_Download["+i+"]\"]").getText());
					} catch (Exception exp) {
						utils.log().info("Device Download Speed data is not available");
					}

					try {
						if (super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_List_Screen_Label_Upload["+i+"]\"]").isDisplayed())
							utils.log().info("Device Upload Speed : " + super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_List_Screen_Label_Upload["+i+"]\"]").getText());
					} catch (Exception exp) {
						utils.log().info("Device Upload Speed data is not available ");
					}

					try {
						if (super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_List_Screen_Label_IPAddressTitle["+i+"]\"]").isDisplayed()  &&  
								super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_List_Screen_Label_IPAddress["+i+"]\"]").isDisplayed())
							utils.log().info(super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_List_Screen_Label_IPAddressTitle["+i+"]\"]").getText() + " : " + 
								super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_List_Screen_Label_IPAddress["+i+"]\"]").getText());
					} catch (Exception exp) {
						utils.log().info("Device IP Label and IP Address are not available ");
					}

					try {
						if (super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_List_Screen_Label_MacTitle["+i+"]\"]").isDisplayed() &&
								super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_List_Screen_Label_Mac["+i+"]\"]").isDisplayed())
							utils.log().info(super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_List_Screen_Label_MacTitle["+i+"]\"]").getText() + " : " +
									super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_List_Screen_Label_Mac["+i+"]\"]").getText());
					} catch (Exception exp) {
						utils.log().info("MAC Address Label and MAC Address is not displayed");
					}

					try {
						if (super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_List_Screen_Label_ChannelTitle["+i+"]\"]").isDisplayed() &&
								super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_List_Screen_Label_Channel["+i+"]\"]").isDisplayed())
							utils.log().info(super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_List_Screen_Label_ChannelTitle["+i+"]\"]").getText() + " : " +
									super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_List_Screen_Label_Channel["+i+"]\"]").getText());
					} catch (Exception exp) {
						utils.log().info("Channel Label and Device Channel Number is not displayed");
					}

					try {
						if (super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_List_Screen_Label_StatusTitle["+i+"]\"]").isDisplayed() &&
								super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_List_Screen_Label_Status["+i+"]\"]").isDisplayed())
							utils.log().info(super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_List_Screen_Label_StatusTitle["+i+"]\"]").getText() + " : " +
									super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_List_Screen_Label_Status["+i+"]\"]").getText());
					} catch (Exception exp) {
						utils.log().info("Status Label and Device Status is not displayed");
					}

					try {
						if (super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_List_Screen_Label_RSSITitle["+i+"]\"]").isDisplayed() &&
								super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_List_Screen_Label_RSSI["+i+"]\"]").isDisplayed())
							utils.log().info(super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_List_Screen_Label_RSSITitle["+i+"]\"]").getText() + " : " +
									super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_List_Screen_Label_RSSI["+i+"]\"]").getText());
					} catch (Exception exp) {
						utils.log().info("RSSI Label and RSSI data is not displayed");
					}

					super.pause(5);
					
					click(super.getDriver().findElementByXPath("//XCUIElementTypeButton[@name=\"Device_List_Screen_Button_Expand["+i+"]\"]"));
					

					utils.log().info("****************************************************");
					utils.log().info("                                                    ");
				}
				if (i >= 5)
					super.swipeUp();
			}
			return true;
		} else {
			utils.log().info("Either there are no devices connected to the main mAX router or all devices are currently offline");
			return true;
		}
	}

	// To verify the details of online devices
	public boolean verifyOfflineDeviceDetails() {
		try {
			this.getOfflineDevicesCount();
			utils.log().info("                                                   ");
			utils.log().info("****************************************************");
			utils.log().info("Details of Offline Devices Connected to Main Device ");
			utils.log().info("****************************************************");
			
			if (offlineDeviceCount > 0) {
				for (int i = 1; i <= offlineDeviceCount; i++) {
					utils.log().info("Offline Device : " + i);
					utils.log().info("----------------------");

					List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
					"//XCUIElementTypeApplication[@name=\"SBC Test\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell["+i+"]");
					
					for (MobileElement e : entity) {
						if (super.getDriver().findElementByXPath("//XCUIElementTypeImage[@name=\"Device_List_Screen_Image_Device["+i+"]\"]").isDisplayed())
							utils.log().info("Device Image is displayed");
						else
							utils.log().info("Device Image is not available : ");

						if (super.getDriver().findElementByXPath("//XCUIElementTypeButton[@name=\"Device_List_Screen_Button_DeviceName["+i+"]\"]").isDisplayed())
							utils.log().info("Device Name  : " + super.getDriver().findElementByXPath("//XCUIElementTypeButton[@name=\"Device_List_Screen_Button_DeviceName["+i+"]\"]").getText());
						else
							utils.log().info("Device Name is not available ");

						if (super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_List_Screen_Label_LastLoginTitle["+i+"]\"]").isDisplayed() &&
								super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_List_Screen_Label_LastLogin["+i+"]\"]").isDisplayed())
							utils.log().info(super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_List_Screen_Label_LastLoginTitle["+i+"]\"]").getText() + " : " +
									super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_List_Screen_Label_LastLogin["+i+"]\"]").getText());
						else
							utils.log().info("Last Online data is not available ");

						utils.log().info("****************************************************");
						utils.log().info("                                                    ");
					}
					if (i >= 7)
						super.swipeUp();
				}
			} else {
				utils.log().info("Either there are no devices connected to the main mAX router or all devices are currently online");
				return true;
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyUIOnDevicesPage() {
		utils.log().info("                                            ");
		utils.log().info("********************************************");
		utils.log().info("Details of UI Elements on the Devices Page  ");
		utils.log().info("********************************************");

		try {
			try {
				if (onlineDeviceTitle.isDisplayed())
					utils.log().info("Device Title - " + onlineDeviceTitle.getText() + " is displayed");
			} catch (Exception e) {
				utils.log().info("Device Title is not displayed");
			}

			try {
				if (backButton.isDisplayed())
					utils.log().info("Back Icon is displayed");
			} catch (Exception e) {
				utils.log().info("Back Icon is displayed");
			}

			try {
				if (helpIcon.isDisplayed())
					utils.log().info("Help Icon is displayed");
			} catch (Exception e) {
				utils.log().info("Help Icon is displayed");
			}

			try {
				if (onlineButton.isDisplayed())
					utils.log().info("Online Tab is displayed");
			} catch (Exception e) {
				utils.log().info("Online Tab is not displayed");
			}

			try {
				if (offlineButton.isDisplayed())
					utils.log().info("Offline Tab is displayed");
			} catch (Exception e) {
				utils.log().info("Offline Tab is not displayed");
			}

//			if (mainDeviceName.isDisplayed())
//				utils.log().info("Main Device name - " + mainDeviceName.getText() + " - is displayed");
//			else
//				utils.log().info("Main Device name is not displayed");
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean verifyEditDeviceName() {
		try {
			this.getOnlineDeviceNameCount();
			if (this.onlineDeviceCount > 0) 
			{
				for (int i = 1; i <= 1; i++) 
				{
					List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
					"//XCUIElementTypeApplication[@name=\"SBC Test\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell["+i+"]");

					//List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath("//XCUIElementTypeButton[@name=\"Device_List_Screen_Button_ViewMore["+i+"]\"]");
					
					for (MobileElement e : entity) 
					{
						if (super.getDriver().findElementByXPath("//XCUIElementTypeButton[@name=\"Device_List_Screen_Label_Device["+i+"]\"]").isDisplayed()) 
						{
							utils.log().info("Device Name: " + super.getDriver().findElementByXPath("//XCUIElementTypeButton[@name=\"Device_List_Screen_Label_Device["+i+"]\"]").getText());
							
							this.connectedDeviceName = super.getDriver().findElementByXPath("//XCUIElementTypeButton[@name=\"Device_List_Screen_Label_Device["+i+"]\"]").getText();
							
							click(super.getDriver().findElementByXPath("//XCUIElementTypeButton[@name=\"Device_List_Screen_Button_EditDevice["+i+"]\"]"));
							if (this.getEditDeviceNameDialogObject().isAt())
							{
								this.getEditDeviceNameDialogObject().editDeviceName();
								this.getEditDeviceNameDialogObject().clickSaveButton();
							}
						}
					}
				}
			} else {
				utils.log().info("Either there are no devices connected to the main mAX router or all devices are currently offline");
			}
			return true;
		} catch (Exception ex) {
			utils.log().info("Error in Online Devices Page ");
			return false;
		}
	}

	@Override
	public boolean isAt() {
		if (onlineDeviceTitle.isDisplayed()) {
			utils.log().info("On Devices Page");
			return true;
		} else {
			utils.log().info("Not on Devices Page");
			return false;
		}
	}
}
