package com.cs.arris.Pages;

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

public class NetworkDevicePrioritySettings extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Device Priority Settings\"]")
	public MobileElement devicePriorityTitle;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeOther[@name=\"NavigationBar_Button_Back\"]")
	public MobileElement backIcon;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeOther[@name=\"NavigationBar_Button_Help\"]")
	public MobileElement helpIcon;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Device_Priority_Screen_Button_Label_Device\"]")
	public MobileElement deviceLevelPrioritizationLabel;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Device_Priority_Screen_Label_Priority\"]")
	public MobileElement networkDevicePriorityLabel;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeSwitch[@name=\"Device_Priority_Screen_Button_Switch\"]")
	public MobileElement devicePrioritySettingToggleButton;
	
//	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Device Priority Settings\"]")
//	public MobileElement enabledDevicePrioritySettingToggleButton;
//	
//	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Device Priority Settings\"]")
//	public MobileElement disabledDevicePrioritySettingToggleButton;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Device_Priority_Screen_Button\"]")
	public MobileElement addDeviceButton;


	public NetworkDevicePrioritySettings() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public FooterIconsPage getFooterIconsPageObject() {
		FooterIconsPage footerIconsPage = new FooterIconsPage();
		return footerIconsPage;
	}

	public NetworkDevicePrioritySettingsHelpPage getDevicePriorityHelpPageObject() {
		NetworkDevicePrioritySettingsHelpPage devicePrioritySettings = new NetworkDevicePrioritySettingsHelpPage();
		return devicePrioritySettings;
	}

	public NetworkDevicePrioritySettingsAddDevicePage getAddDevicePriorityPageObject() {
		NetworkDevicePrioritySettingsAddDevicePage addDevice = new NetworkDevicePrioritySettingsAddDevicePage();
		return addDevice;
	}
	
	public NetworkAddDeviceSelectOneDeviceOfHighestPriorityDialog getAddedTwoHighestPriorityDevicesDialogObject() {
		NetworkAddDeviceSelectOneDeviceOfHighestPriorityDialog twoDeviceWithHighestPriority = new NetworkAddDeviceSelectOneDeviceOfHighestPriorityDialog();
		return twoDeviceWithHighestPriority;
	}

	public boolean clickBackButton() {
		if (backIcon.isDisplayed()) {
			click(backIcon);
			utils.log().info("Clicked on Back Button");
			return true;
		} else {
			utils.log().info("Back Button is not displayed");
			return false;
		}
	}

	public boolean clickHelpButton() {
		if (helpIcon.isDisplayed()) {
			click(helpIcon);
			utils.log().info("Clicked on Help Button");
			return true;
		} else {
			utils.log().info("Help button is not displayed");
			return false;
		}
	}
	
	public boolean clickAddDeviceButton() {
		if (addDeviceButton.isDisplayed()) {
			click(addDeviceButton);
			utils.log().info("Clicked on Add Device Button");
			return true;		
		}else{
			utils.log().info("Add Device button is not displayed");
			return false;
		}
	}
	
	public boolean enableDevicePrioritySettings() {
		try {
			String str = super.getDriver().findElement(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch[`name == \"Device_Priority_Screen_Button_Switch\"`]")).getAttribute("value");
			int value = Integer.parseInt(str);
			if(value == 0)  //disabled
			{
				super.getDriver().findElement(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch[`name == \"Device_Priority_Screen_Button_Switch\"`]")).click();
				utils.log().info("Device Priority Settings is enabled");
			}else {
				utils.log().info("Device Priority Settings is already enabled");
			}
			return true;
		} catch(Exception e) {
			utils.log().info("Issue in enabling Device Priority Settings");
			return true;
		}
	}

	public boolean disableDevicePrioritySettings() {
		try {
			String str = super.getDriver().findElement(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch[`name == \"Device_Priority_Screen_Button_Switch\"`]")).getAttribute("value");
			int value = Integer.parseInt(str);
			if(value == 1)
			{
				super.getDriver().findElement(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch[`name == \"Device_Priority_Screen_Button_Switch\"`]")).click();
				utils.log().info("Device Priority Settings is disabled");
			}else {
				utils.log().info("Device Priority Settings is already disabled");
			}
			return true;
		} catch(Exception e) {
			utils.log().info("Issue in disabling Device Priority Settings");
			return true;
		}
	}

	public boolean verifyUIOnDevicePrioritySettingsPage() {
		utils.log().info("                                                       ");
		utils.log().info("*******************************************************");
		utils.log().info("Verifying UI Elements on Device Priority Settings Page ");
		utils.log().info("*******************************************************");
		try {
			if (devicePriorityTitle.isDisplayed())
				utils.log().info(devicePriorityTitle.getText() + " title text is displayed ");
			else
				utils.log().info("Device Priority Settings title text is not displayed");

			if (backIcon.isDisplayed())
				utils.log().info("Back Icon is displayed ");
			else
				utils.log().info("Back Icon is not displayed");

			if (helpIcon.isDisplayed())
				utils.log().info("Help Icon is displayed");
			else
				utils.log().info("Help Icon is not displayed");
			
			if (deviceLevelPrioritizationLabel.isDisplayed()) 
				utils.log().info("Device Level Prioritization Label is displayed");
			else
				utils.log().info("Device Level Prioritization Label is not displayed");
			
			if (devicePrioritySettingToggleButton.isDisplayed()) 
				utils.log().info("Device Level Prioritization toggle button is displayed");
			else
				utils.log().info("Device Level Prioritization toggle button is not displayed");

			if (addDeviceButton.isDisplayed()) 
				utils.log().info("Add Device button is displayed");
			else
				utils.log().info("Add Device button is not displayed");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyUIOnNetworkPrioritizedDevices() 
	{
		utils.log().info("                                                                                ");
		utils.log().info("********************************************************************************");
		utils.log().info("Verifying UI Elements after Adding Devices to the Device Priority Settings Page ");
		utils.log().info("********************************************************************************");
		
//		int size = super.getDriver().findElementsByXPath("androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView").size();
//		utils.log().info("Size of Prioritized Device List : " + size);
		
		 try 
		 {
			for (int i = 1; i <= 2; i++)
			{
				utils.log().info("                          ");
				utils.log().info("Prioritized Device  : " + i);
				utils.log().info("--------------------------");

				List<MobileElement> entity = (List<MobileElement>) 
				super.getDriver().findElementsByXPath("//XCUIElementTypeApplication[@name=\"SBC Test\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell["+i+"]");

				for (MobileElement e : entity) 
				{
					if (e.findElementByXPath("//XCUIElementTypeImage[@name=\"Device_Priority_Screen_Image_Device["+i+"]\"]").isDisplayed())
						utils.log().info("Device Image is displayed");
				
					if (e.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_Priority_Screen_Label_Device["+i+"]\"]").isDisplayed())
						utils.log().info("Device Name: " + e.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_Priority_Screen_Label_Device["+i+"]\"]").getText());
				
					if (e.findElementByXPath("//XCUIElementTypeButton[@name=\"Device_Priority_Screen_Button_Highest["+i+"]\"]").isDisplayed())
						utils.log().info("Highest Priority Radion Button option is displayed");

					if (e.findElementByXPath("//XCUIElementTypeButton[@name=\"Device_Priority_Screen_Button_High["+i+"]\"]").isDisplayed())
						utils.log().info("High Priority Radion Button option is displayed");

					if (e.findElementByXPath("//XCUIElementTypeButton[@name=\"Device_Priority_Screen_Button_Normal["+i+"]\"]").isDisplayed())
						utils.log().info("Normal Priority Radio Button is displayed");			
				}
			}
			return true;
		}catch(Exception e){
			utils.log().info("No Device found to prioritize");
			return false;}
	}
	
	public boolean verifyTwoDevicesWithHighestPriority() {
		utils.log().info("                                   ");
		utils.log().info("***********************************");
		utils.log().info(" Devices Assigned Highest Priority ");
		utils.log().info("***********************************");
	
		try {
			for (int i = 1; i <= 2; i++) {
			utils.log().info("Prioritized Device  : " + i);
			utils.log().info("--------------------------");

			List<MobileElement> entity = (List<MobileElement>)
			super.getDriver().findElementsByXPath("//XCUIElementTypeApplication[@name=\"SBC Test\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell["+i+"]");

			for (MobileElement e : entity) {
				if (e.findElementByXPath("//XCUIElementTypeImage[@name=\"Device_Priority_Screen_Image_Device["+i+"]\"]").isDisplayed())
					utils.log().info("Device Image is displayed");
			
				if (e.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_Priority_Screen_Label_Device["+i+"]\"]").isDisplayed())
					utils.log().info("Device Name: " + e.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_Priority_Screen_Label_Device["+i+"]\"]").getText());
				
				try
				{
					if (e.findElementByXPath("//XCUIElementTypeButton[@name=\"Device_Priority_Screen_Button_Highest["+i+"]\"]").isDisplayed()) {			
							click(e.findElementByXPath("//XCUIElementTypeButton[@name=\"Device_Priority_Screen_Button_Highest["+i+"]\"]"));
							super.pause(15);
							utils.log().info("Highest Priority Radion Button option is selected");
						}
				}catch(Exception exp) {
					utils.log().info("Highest Priority Radion Button is not displayed");
				}			
			}
		}
			return true;
		}catch(Exception e){
			utils.log().info("No Device found to prioritize");
			return false;
		}
	}

	@Override
	public boolean isAt() {
		if (devicePriorityTitle.isDisplayed()) {
			utils.log().info("On Device Priortization Settings Page");
			return true;
		} else {
			utils.log().info("Not on Device Priortization Settings Page");
			return false;
		}
	}
}
