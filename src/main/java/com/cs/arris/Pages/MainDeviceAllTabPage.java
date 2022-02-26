package com.cs.arris.Pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.Direction;
import com.cs.arris.Utilities.SwipeActions;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class MainDeviceAllTabPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();
	public List<String> signal = new ArrayList<String>();
	public TouchAction action = new TouchAction(getDriver());
	public String fiveGhzDevice;
	public String twoFourGhzDevice;
	public String txtDevices;
	public String execDevices;
	public String medDevices;
	public String prDevices;
	public String connDevices;
	public int allDevicesCount;
	public int fiveGHzDevicesCount;
	public int twoFourGHzDevicesCount;
	public int counter = 1;
	public int counter5 = 0;
	public int counter24 = 0;
	public int counterEthernet = 0;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"NavigationBar_Title\"]")
	public MobileElement mainTitle;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Home\"]")
	public MobileElement backIcon;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"NavigationBar_Button_Help\"]")
	public MobileElement helpIcon;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"All\"]")
	public MobileElement allTab;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"5.0 GHz\"]")
	public MobileElement fiveGhzTab;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"2.4 GHz\"]")
	public MobileElement twentyFourGhzTab;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Ethernet\"]")
	public MobileElement ethernetTab;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"Device_Detail_Screen_Image_Main\"]")
	public MobileElement mainRouterImage;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Device_Detail_Screen_Label_DeviceCount\"]")
	public MobileElement totalDeviceImage;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Device_Detail_Screen_Label_GreenCount\"]")
	public MobileElement excellentDeviceImage;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Device_Detail_Screen_Label_OrangeCount\"]")
	public MobileElement mediumDeviceImage;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Device_Detail_Screen_Label_RedCount\"]")
	public MobileElement poorDeviceImage;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Device_Detail_Screen_Label_Name\"]")
	public MobileElement mainRouterName;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Device_Detail_Screen_Button_Edit\"]")
	public MobileElement mainRouterEditName;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Device_Detail_Screen_Label_Status\"]")
	public MobileElement mainRouterStatus;

	// ====================LED Settings=====================
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Device_Detail_Screen_HeaderView_LED\"])[1]")
	public MobileElement ledSettingsButton;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"Device_Detail_Screen_Image_Brightness\"]")
	public MobileElement ledColorImage;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"Device_Detail_Screen_Image_Moon\"]")
	public MobileElement ledMoonColorImage;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"Device_Detail_Screen_Image_Icon\"]")
	public MobileElement ledSunColorImage;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Device_Detail_Screen_Label\"]")
	public MobileElement chooseColorBrightnessLabel;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSlider[@name=\"Device_Detail_Screen_Slider\"]")
	public MobileElement seekBar;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"Device_Detail_Screen_Image_Scale\"]")
	public MobileElement scale;


	// ====================LED Settings=====================
	
	

	// ====================Connected Devices=====================
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Device_Detail_Screen_HeaderLabel_Connected\"])[1]")
	public MobileElement connectedDevicesCountText;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Device_Detail_Screen_HeaderView_Connected\"])[1]")
	public MobileElement connectedDevicesExpandButton;

//	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeImage[`name == \"Device_Detail_Screen_HeaderImage_Connected\"`][1]")
//	public MobileElement connectedDevicesExpandImage;

	// ====================Connected Devices=====================

	// ====================Main Router Details=====================

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Device_Detail_Screen_HeaderView_Details\"])[1]")
	public MobileElement routerDetailsButton;

//	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage[@name=\"Device_Detail_Screen_HeaderImage_Details\"])[1]")
//	public MobileElement mainRouterExpandImage;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Device_Detail_Screen_Label_ChannelTitle\"]")
	public MobileElement channelLabel;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Device_Detail_Screen_Label_5GHzDevice\"]")
	public MobileElement fiveGhzDeviceCount;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Device_Detail_Screen_Label_24GhzDevice\"]")
	public MobileElement twoFourGhzDeviceCount;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Device_Detail_Screen_Label_WANTitle\"]")
	public MobileElement wanIPAddressLabel;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Device_Detail_Screen_Label_WAN\"]")
	public MobileElement mainDeviceWANIPAddress;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Device_Detail_Screen_Label_LANTitle\"]")
	public MobileElement lanIPAddressLabel;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Device_Detail_Screen_Label_LAN\"]")
	public MobileElement mainDeviceLANIPAddress;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Device_Detail_Screen_Label_MacTitle\"]")
	public MobileElement macAddressLabel;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Device_Detail_Screen_Label_Mac\"]")
	public MobileElement mainDeviceMACAddress;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Device_Detail_Screen_Label_SerialTitle\"]")
	public MobileElement serialNumberLabel;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Device_Detail_Screen_Label_SN\"]")
	public MobileElement mainDeviceSerialNumber;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Device_Detail_Screen_Label_FirmwareTitle\"]")
	public MobileElement firmwareLabel;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Device_Detail_Screen_Label_Firmware\"]")
	public MobileElement firmwareVersion;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Device_Detail_Screen_Label_ModelTitle\"]")
	public MobileElement mainDeviceModelNoLabel;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Device_Detail_Screen_Label_Model\"]")
	public MobileElement mainDeviceModelNumber;

	// ====================Main Router Details=====================

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Device_Detail_Screen_Button\"]")
	public MobileElement restartRouterButton;
	
	//======================  Device Counts ====================
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Device_Detail_Screen_Label_DeviceCount\"]")
	public MobileElement totalDevices;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Device_Detail_Screen_Label_GreenCount\"]")
	public MobileElement excellentDevices;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Device_Detail_Screen_Label_OrangeCount\"]")
	public MobileElement mediumDevices;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Device_Detail_Screen_Label_RedCount\"]")
	public MobileElement poorDevices;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Device_Detail_Screen_HeaderLabel_Connected\"])[1]")
	public MobileElement connectedDevices;

	//======================  Device Counts ====================

	public MainDeviceAllTabPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public HomePage getHomePageObject() {
		HomePage homePage = new HomePage();
		return homePage;
	}

	public FooterIconsPage getFooterIconsPageObject() {
		FooterIconsPage footerIconsPage = new FooterIconsPage();
		return footerIconsPage;
	}

	public MainRouterDetailsHelpPage getMainRouterDetailsHelpPageObject() {
		MainRouterDetailsHelpPage routerDetialsHelpPage = new MainRouterDetailsHelpPage();
		return routerDetialsHelpPage;
	}

	public EditMainDeviceNameDialog getEditMainDeviceNameDialogObject() {
		EditMainDeviceNameDialog editDeviceNameDialog = new EditMainDeviceNameDialog();
		return editDeviceNameDialog;
	}

	public EditDeviceNameDialog getEditDeviceNameDialogObject() {
		EditDeviceNameDialog editDevNameDialog = new EditDeviceNameDialog();
		return editDevNameDialog;
	}

	public MainDevice5GHzTabPage get5GHzPageObject() {
		MainDevice5GHzTabPage device5GHz = new MainDevice5GHzTabPage();
		return device5GHz;
	}

	public MainDevice24GHzTabPage get24GHzPageObject() {
		MainDevice24GHzTabPage device24GHz = new MainDevice24GHzTabPage();
		return device24GHz;
	}

	public MainDeviceEthernetTabPage getEthernetPageObject() {
		MainDeviceEthernetTabPage ethernetDevice = new MainDeviceEthernetTabPage();
		return ethernetDevice;
	}
	
	public MainDeviceRestartRouterDialog getRestartRouterDialogeObject() {
		MainDeviceRestartRouterDialog restartRouter = new MainDeviceRestartRouterDialog();
		return restartRouter;
	}
	
	public void getAllDevicesCount() {
		allDevicesCount = super.getAllCountOfDevices(connectedDevicesCountText.getText());
		utils.log().info("Number of online devices connected to the main mAX Router is : " + allDevicesCount);
	}

	public void get5GHzDevicesCount() {
		fiveGHzDevicesCount = super.get5GHzCountOfDevices(fiveGhzDeviceCount.getText());
		utils.log().info("Number of 5GHz devices connected to the main mAX Router is : " + fiveGHzDevicesCount);
	}

	public void get24GHzDevicesCount() {
		twoFourGHzDevicesCount = super.get24GHzCountOfDevices(twoFourGhzDeviceCount.getText());
		utils.log().info("Number of 2.4GHz devices connected to the main mAX Router is : " + twoFourGHzDevicesCount);
	}
	
	public void clickLEDExpandButton()
	{
		//super.getDriver().findElementByXPath("(//XCUIElementTypeImage[@name=\"Device_Detail_Screen_HeaderImage_LED\"])[1]").click();
		click(ledSettingsButton);
	}

	public boolean verifyUIOnLedSettings() {
		
		utils.log().info("                         ");
		utils.log().info("**************************");
		utils.log().info("LED Settings Verficiation");
		utils.log().info("*************************");
		try {
			try {
				if (ledSettingsButton.isDisplayed()) {
					click(ledSettingsButton);
					utils.log().info("Clicked on LED Settings button");}
			} catch (Exception e) {
				utils.log().info("LED SEttings text is not displayed");
			}

			try {
				if (ledColorImage.isDisplayed())
					utils.log().info("Brightness Icon is displayed");
			} catch (Exception e) {
				utils.log().info("Brightness Icon is not displayed");
			}

			try {
				if (ledMoonColorImage.isDisplayed())
					utils.log().info("Moon Image is displayed");
			} catch (Exception e) {
				utils.log().info("Moon Image is not displayed");
			}

			try {
				if (ledSunColorImage.isDisplayed())
					utils.log().info("Sun Brightness image is displayed");
			} catch (Exception e) {
				utils.log().info("Sun Brightness image is not displayed");
			}

			try {
				if (chooseColorBrightnessLabel.isDisplayed())
					utils.log().info("Choose Color Brightness label is displayed");
			} catch (Exception e) {
				utils.log().info("Choose Color Brightness label is not displayed");
			}
			
			try {
				if (seekBar.isDisplayed())
					utils.log().info("Seekbar is displayed");
			} catch (Exception e) {
				utils.log().info("Seekbar is not displayed");
			}
			
			try {
				if (scale.isDisplayed())
					utils.log().info("Scale is displayed");
			} catch (Exception e) {
				utils.log().info("Scale is not displayed");
			}

			click(ledSettingsButton);

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean clickAllTab() {
		if (allTab.isDisplayed()) {
			click(allTab);
			utils.log().info("Clicked on All tab ");
			return true;
		} else {
			utils.log().info("All Tab is not displayed ");
			return false;
		}
	}

	public boolean click5GhzTab() {
		if (fiveGhzTab.isDisplayed()) {
			click(fiveGhzTab);
			utils.log().info("Clicked on 5GHz tab ");
			return true;
		} else {
			utils.log().info("5GHz Tab is not displayed ");
			return false;
		}
	}

	public boolean click24GhzTab() {
		if (twentyFourGhzTab.isDisplayed()) {
			click(twentyFourGhzTab);
			utils.log().info("Clicked on 2.4GHz tab ");
			return true;
		} else {
			utils.log().info("2.4GHz Tab is not displayed ");
			return false;
		}
	}

	public boolean clickEthernetTab() {
		if (ethernetTab.isDisplayed()) {
			click(ethernetTab);
			utils.log().info("Clicked on Ethernet tab ");
			return true;
		} else {
			utils.log().info("Ethernet Tab is not displayed ");
			return false;
		}
	}

	public boolean clickHelpButton() {
		if (helpIcon.isDisplayed()) {
			click(helpIcon);
			utils.log().info("Clicked on Main Router Help tab ");
			return true;
		} else {
			utils.log().info("Help Icon is not displayed ");
			return false;
		}
	}

	public boolean clickBackButton() {
		if (backIcon.isDisplayed()) {
			click(backIcon);
			utils.log().info("Clicked on Back button ");
			return true;
		} else {
			utils.log().info("Back Button is not displayed ");
			return false;
		}
	}

	public boolean clickMainDeviceEditIcon() {
		if (mainRouterEditName.isDisplayed()) {
			click(mainRouterEditName);
			utils.log().info("Clicked on Main Router Edit Icon ");
			return true;
		} else {
			utils.log().info("Main Router Edit Icon is not displayed");
			return false;
		}
	}

	public boolean clickDeviceNameEditIcon() {
		this.getAllDevicesCount();
		try {
			if (allDevicesCount > 0) {
						List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath("//XCUIElementTypeApplication[@name=\"SBC Test\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]");

						for (MobileElement e : entity) {
							try {
								if (super.getDriver().findElementByXPath("//XCUIElementTypeButton[@name=\"Device_Detail_Screen_Button_EditDevice[1]\"]").isDisplayed())
									click(super.getDriver().findElementByXPath("//XCUIElementTypeButton[@name=\"Device_Detail_Screen_Button_EditDevice[1]\"]"));
							} catch (Exception exp) {
								utils.log().info("Device Name is not available ");
							}
						}
				return true;
			}else {utils.log().info("There are no devices connected to the Main Router ");return true;}
			} catch (Exception ex) {
				utils.log().info("Unable to retrieve Device Name");
			return false;
			}
	}

	public boolean verifyUIOnMainDevicePage() {
		utils.log().info("                                           ");
		utils.log().info("*******************************************");
		utils.log().info("Details of UI Elements on the All Tab Page ");
		utils.log().info("*******************************************");
		try {
			try {
				if (mainTitle.isDisplayed())
					utils.log().info(mainTitle.getText() + " Title text is displayed ");
			} catch (Exception e) {
				utils.log().info("Main title text is not displayed");
			}

			try {
				if (backIcon.isDisplayed())
					utils.log().info("Back Icon image is displayed ");
			} catch (Exception e) {
				utils.log().info("Back Icon image is not displayed");
			}

			try {
				if (helpIcon.isDisplayed())
					utils.log().info("Help Icon is displayed");
			} catch (Exception e) {
				utils.log().info("Help Icon is not displayed");
			}

			try {
				if (allTab.isDisplayed())
					utils.log().info("All tab is displayed");
			} catch (Exception e) {
				utils.log().info("All tab is not displayed");
			}

			try {
				if (fiveGhzTab.isDisplayed())
					utils.log().info("5GHz tab is displayed");
			} catch (Exception e) {
				utils.log().info("5GHz tab is not displayed");
			}

			try {
				if (twentyFourGhzTab.isDisplayed())
					utils.log().info("2.4GHz tab is displayed");
			} catch (Exception e) {
				utils.log().info("2.4GHz tab is not displayed");
			}

			try {
				if (ethernetTab.isDisplayed())
					utils.log().info("Ethernet tab is displayed");
			} catch (Exception e) {
				utils.log().info("Ethernet tab is not displayed");
			}

			try {
				if (mainRouterImage.isDisplayed())
					utils.log().info("Main Router image is displayed");
			} catch (Exception e) {
				utils.log().info("Main Router image is not displayed");
			}

			try {
				if (totalDeviceImage.isDisplayed()) 
					utils.log().info(totalDeviceImage.getText() + " devices are connected to the Main Router ");
			} catch (Exception e) {
				utils.log().info("Count of devices connected to the Main Router is not displayed");
			}
			
			try {
				if (excellentDeviceImage.isDisplayed()) 
					utils.log().info(excellentDeviceImage.getText() + " excellent devices are connected to the Main Router");
			} catch (Exception e) {
				utils.log().info("Count of excellent devices connected to the Main Router is not displayed");
			}
			
			try {
				if (mediumDeviceImage.isDisplayed()) 
					utils.log().info(mediumDeviceImage.getText() + " medium devices are connected to the Main Router");
			} catch (Exception e) {
				utils.log().info("Count of medium devices connected to the Main Router is not displayed");
			}
			
			try {
				if (poorDeviceImage.isDisplayed()) 
					utils.log().info(poorDeviceImage.getText() + " poor devices are connected to the Main Router");
			} catch (Exception e) {
				utils.log().info("Count of poor devices connected to the Main Router is not displayed");
			}

			try {
				if (mainRouterName.isDisplayed())
					utils.log().info("Main Router Device Name is " + mainRouterName.getText());
			} catch (Exception e) {
				utils.log().info("Main Router Name is not displayed");
			}

			try {
				if (mainRouterStatus.isDisplayed())
					utils.log().info("Main Router Status " + mainRouterStatus.getText());
			} catch (Exception e) {
				utils.log().info("Main Router Status is not displayed");
			}
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// To verify the details of all connected devices
	public boolean verifyConnectedDeviceDetails() {
		utils.log().info("                                               ");
		utils.log().info("***********************************************");
		utils.log().info("Details of All Devices Connected to Main Router");
		utils.log().info("***********************************************");

		this.getAllDevicesCount();
		
			if (allDevicesCount > 0) {
				
				click(connectedDevicesExpandButton);
								
				for (int i = 1; i <= allDevicesCount; i++) {
					
					utils.log().info("Connected Device  : " + i);
					utils.log().info("--------------------------");
					
					List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
					"//XCUIElementTypeApplication[@name=\"SBC Test\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell["+i+"]");

					for (MobileElement e : entity) {
						try {
							if (super.getDriver().findElementByXPath("//XCUIElementTypeButton[@name=\"Device_Detail_Screen_Button_Device["+i+"]\"]").isDisplayed())
								utils.log().info("Device Image is displayed");
						} catch (Exception exp) {
							utils.log().info("Device Image is not displayed ");	}

						try {
							if (super.getDriver().findElementByXPath("//XCUIElementTypeButton[@name=\"Device_Detail_Screen_Button_DeviceName["+i+"]\"]").isDisplayed())
								utils.log().info("Device Name : " + super.getDriver().findElementByXPath("//XCUIElementTypeButton[@name=\"Device_Detail_Screen_Button_DeviceName["+i+"]\"]").getText());
						} catch (Exception exp) {
							utils.log().info("Device Name is not available ");}

						try {
							if (super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_Detail_Screen_Label_Speed["+i+"]\"]").isDisplayed()) 
								utils.log().info("Device Signal Strength : " + super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_Detail_Screen_Label_Speed["+i+"]\"]").getText());
						} catch (Exception exp) {
							utils.log().info("Device Signal Strength data is not available ");}

						try {
							if (super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_Detail_Screen_Label_Download["+i+"]\"]").isDisplayed()) 
								utils.log().info("Device Download Speed : " + super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_Detail_Screen_Label_Download["+i+"]\"]").getText());
						} catch (Exception exp) {
							utils.log().info("Device Download Speed data is not available ");
						}

						try {
							if (super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_Detail_Screen_Label_Upload["+i+"]\"]").isDisplayed())
								utils.log().info("Device Upload Speed : " + super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_Detail_Screen_Label_Upload["+i+"]\"]").getText());
						} catch (Exception exp) {
							utils.log().info("Device Upload Speed data is not available ");
						}

						try {
							if (super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_Detail_Screen_Label_IPTitle["+i+"]\"]").isDisplayed()
									&& super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_Detail_Screen_Label_IP["+i+"]\"]").isDisplayed()) 
								utils.log().info(super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_Detail_Screen_Label_IPTitle["+i+"]\"]").getText()
										+ " : "
										+ super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_Detail_Screen_Label_IP["+i+"]\"]").getText());
						} catch (Exception exp) {
							utils.log().info("IP Address Details are not available or displayed ");
						}

						try {
							if (super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_Detail_Screen_Label_MacTitle["+i+"]\"]").isDisplayed()
									&& super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_Detail_Screen_Label_Mac["+i+"]\"]").isDisplayed()) 
								utils.log().info(super.getDriver().findElementByXPath(
										"//XCUIElementTypeStaticText[@name=\"Device_Detail_Screen_Label_MacTitle["+i+"]\"]").getText()
										+ " : "
										+ super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_Detail_Screen_Label_Mac["+i+"]\"]").getText());
						} catch (Exception exp) {
							utils.log().info("MAC Address Details are not available or displayed ");
						}

						try {
							if (super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_Detail_Screen_Label_ChannelTitle["+i+"]\"]").isDisplayed()
									&& super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_Detail_Screen_Label_Channel["+i+"]\"]").isDisplayed()) 
								utils.log().info(super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_Detail_Screen_Label_ChannelTitle["+i+"]\"]").getText()
										+ " : "
										+ super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_Detail_Screen_Label_Channel["+i+"]\"]").getText());
						} catch (Exception exp) {
							utils.log().info("Channel Details are not available or displayed ");
						}

						try {
							if (super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_Detail_Screen_Label_RSSITitle["+i+"]\"]").isDisplayed()
									&& super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_Detail_Screen_Label_RSSI["+i+"]\"]").isDisplayed()) 
								utils.log().info(super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_Detail_Screen_Label_RSSITitle["+i+"]\"]")	.getText()
										+ " : "
										+ super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_Detail_Screen_Label_RSSI["+i+"]\"]").getText());
						} catch (Exception exp) {
							utils.log().info("RSSI Details are not available or displayed ");
						}

						utils.log().info("****************************************************");
						utils.log().info("                                                    ");
					}
					if(i >= 1)
						super.swipeConnectedDevices(Direction.UP);
				}
				super.swipeDown();
				click(connectedDevicesExpandButton);
				return true;
			} else {
				utils.log().info("Currently there are no devices connected to the main Router ");
				click(connectedDevicesExpandButton);
				return true;
			}
	}

	public boolean verifyMainRouterDetails() {
		try {
			
			click(routerDetailsButton);
			
			super.swipeUp();
			utils.log().info("                                  ");
			utils.log().info("**********************************");
			utils.log().info("Details of MAIN Router Device     ");
			utils.log().info("**********************************");

			try {
				if (channelLabel.isDisplayed() && fiveGhzDeviceCount.isDisplayed()) 
					this.fiveGhzDevice = fiveGhzDeviceCount.getText();
				utils.log().info("Channel 1 : " + this.fiveGhzDevice);
			} catch (Exception e) {
				utils.log().info("Channel 5GHz count details is not displayed ");
			}

			try {
				if (channelLabel.isDisplayed() && twoFourGhzDeviceCount.isDisplayed())
					this.twoFourGhzDevice = twoFourGhzDeviceCount.getText();
				utils.log().info("Channel 2 : " + this.twoFourGhzDevice);
			} catch (Exception e) {
				utils.log().info("Channel 2.4GHz count details is not displayed ");
			}

			try {
			if (wanIPAddressLabel.isDisplayed() && mainDeviceWANIPAddress.isDisplayed())
					utils.log().info(wanIPAddressLabel.getText() + " : " + mainDeviceWANIPAddress.getText());
			} catch (Exception e) {
					utils.log().info("WAN IP Address of the Main Router is not displayed ");
			}

			try {
				if (lanIPAddressLabel.isDisplayed() && mainDeviceLANIPAddress.isDisplayed())
					utils.log().info(lanIPAddressLabel.getText() + " : " + mainDeviceLANIPAddress.getText());
			} catch (Exception e) {
				utils.log().info("LAN IP Address of the Main Router is not displayed ");
			}

			try {
				if (macAddressLabel.isDisplayed() && mainDeviceMACAddress.isDisplayed())
					utils.log().info(macAddressLabel.getText() + " : " + mainDeviceMACAddress.getText());
			} catch (Exception e) {
				utils.log().info("MAC Address of the Main Router is not displayed ");
			}

			try {
				if (serialNumberLabel.isDisplayed() && mainDeviceSerialNumber.isDisplayed())
						utils.log().info(serialNumberLabel.getText() + " : " + mainDeviceSerialNumber.getText());
			} catch (Exception e) {
				utils.log().info("Serial No. of the Main Router is not displayed ");
			}

			try {
				if (firmwareLabel.isDisplayed() && firmwareVersion.isDisplayed())
						utils.log().info(firmwareLabel.getText() + " : " + firmwareVersion.getText());
			} catch (Exception e) {
				utils.log().info("Firmware version is not displayed ");
			}

			try {
				if (mainDeviceModelNoLabel.isDisplayed() && mainDeviceModelNumber.isDisplayed())
						utils.log().info(mainDeviceModelNoLabel.getText() + " : " + mainDeviceModelNumber.getText());
			} catch (Exception e) {
				utils.log().info("Model No. of the Main Router is not displayed ");
			}

			try {
				if (restartRouterButton.isDisplayed())
					utils.log().info("Restart Router Button is displayed");
			} catch (Exception e) {
				utils.log().info("Restart Router Button is not displayed");
			}

			click(routerDetailsButton);
//			super.swipeDown();
			return true;
			
		} catch (Exception e) {
			utils.log().info("Issue when verifying Main Router Details");
			return false;
		}
	}

	public boolean allTabvalidations() {
		utils.log().info("                                     ");
		utils.log().info("*************************************");
		utils.log().info("Device Count Validations on All Tab  ");
		utils.log().info("*************************************");
		try {
			
			 txtDevices = super.getDriver().findElementByAccessibilityId("Device_Detail_Screen_Label_DeviceCount").getText();
			 execDevices = super.getDriver().findElementByAccessibilityId("Device_Detail_Screen_Label_GreenCount").getText();
			 medDevices = super.getDriver().findElementByAccessibilityId("Device_Detail_Screen_Label_OrangeCount").getText();
			 prDevices = super.getDriver().findElementByAccessibilityId("Device_Detail_Screen_Label_RedCount").getText();
			 connDevices = String.valueOf(getAllCountOfDevices(super.getDriver().findElementByXPath("(//XCUIElementTypeStaticText[@name=\"Device_Detail_Screen_HeaderLabel_Connected\"])[1]").getText()));
			
			try {
				if(txtDevices.equals(connDevices)) {
					utils.log().info("Total Count of devices displayed to the main Router Image are : " + txtDevices);
					utils.log().info("Total Count of 5GHz devices connected to the main Router are : " + connDevices);
					utils.log().info("Count of devices displayed on the main Router Image is equal to the count of all devices connected to the main Router");
				}else {
					utils.log().info("Count of devices displayed on the main Router Image is not equal to the count of all devices connected to the main Router");
				}
			}catch(Exception e) {}
			
			try {
				String sumOfDevices = String.valueOf(Integer.valueOf(execDevices) + Integer.valueOf(medDevices) + Integer.valueOf(prDevices));
				if(sumOfDevices.equals(txtDevices)) {
					utils.log().info("Total Count of execellent devices connected to the main Router are : " + execDevices);
					utils.log().info("Total Count of medium devices connected to the main Router are : " + medDevices);
					utils.log().info("Total Count of poor devices connected to the main Router are : " + prDevices);
					utils.log().info("Total Count of execellent, medium and poor devices are equal the count of devices displayed on the main Router Image");
				}else {
					utils.log().info("Total Count of execellent, medium and poor devices are not equal the count of devices displayed on the main Router Image");
				}
			}catch(Exception e) {}
			return true;
		} catch (Exception e) {
			utils.log().info("Issue in validating count of devices");
			return false;
		}
	}
		
		public void mobileSwipeSeekBar(Direction dir) {
		    final int ANIMATION_TIME = 200; // ms
		    final HashMap<String, String> scrollObject = new HashMap<String, String>();
		    MobileElement element = (MobileElement) getDriver().findElement(MobileBy.iOSClassChain("**/XCUIElementTypeSlider[`name == \"Device_Detail_Screen_Slider\"`]"));
		    switch (dir) {
		        case LEFT: 
			            action.press(PointOption.point(286, 449)).waitAction( WaitOptions.waitOptions(Duration.ofMillis(1300)))
		                    .moveTo(PointOption.point(185, 449)).release().perform();
			            scrollObject.put("direction", dir.name().toLowerCase());
			            break;
		        case RIGHT: 
		            	action.press(PointOption.point(185, 449)).waitAction( WaitOptions.waitOptions(Duration.ofMillis(1300)))
                    		.moveTo(PointOption.point(286, 449)).release().perform();
		            scrollObject.put("direction", dir.name().toLowerCase());
		            break;
		        default:
		            throw new IllegalArgumentException("mobileSwipeElementIOS(): dir: '" + dir + "' NOT supported");
		    }
		    scrollObject.put("element", element.getId());
		    try {
		        getDriver().executeScript("mobile:swipe", scrollObject);
		        Thread.sleep(ANIMATION_TIME); 
		    } catch (Exception e) {
		        System.err.println("mobileSwipeElementIOS(): FAILED\n" + e.getMessage());
		    }
		}
	
	public void swipe(Direction dir) {
	    Dimension size;
		size = getDriver().manage().window().getSize();
		

	    int startX = 0;
	    int endX = 0;
	    int startY = 0;
	    int endY = 0;

	    switch (dir) {
	        case RIGHT:
	            startY = (int) (size.height / 2);
	            startX = (int) (size.width * 0.90);
	            endX = (int) (size.width * 0.05);
	            action.press(PointOption.point(427, 878)).waitAction( WaitOptions.waitOptions(Duration.ofMillis(1300)))
	                    .moveTo(PointOption.point(427, 554)).release().perform();

	            break;

	        case LEFT:
	            startY = (int) (size.height / 2);
	            startX = (int) (size.width * 0.05);
	            endX = (int) (size.width * 0.90);
	            action.press(PointOption.point(427, 878)).waitAction( WaitOptions.waitOptions(Duration.ofMillis(1300)))
	                    .moveTo(PointOption.point(427, 254)).release().perform();

	            break;

	        case UP:
	            endY = (int) (size.height * 0.50);
	            startY = (int) (size.height * 0.30);
	            startX = (size.width / 2);
	            action.press(PointOption.point(169, 492)).waitAction( WaitOptions.waitOptions(Duration.ofMillis(1300)))
                .moveTo(PointOption.point(1697, 400)).release().perform();
	            break;


	        case DOWN:
	            startY = (int) (size.height * 0.70);
	            endY = (int) (size.height * 0.30);
	            startX = (size.width / 2);
	            action.press(PointOption.point(427, 878)).waitAction( WaitOptions.waitOptions(Duration.ofMillis(1300)))
                .moveTo(PointOption.point(427, 554)).release().perform();

	            break;
	    }
	}

	@Override
	public boolean isAt() {
		if (mainTitle.isDisplayed()) {
			utils.log().info("On MAIN Router - All Tab Page ");
			return true;
		} else {
			utils.log().info("Not on MAIN Page");
			return false;
		}
	}
}