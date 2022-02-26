package com.cs.arris.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.Direction;
import com.cs.arris.Utilities.SwipeActions;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class NetworkDevicePrioritySettingsAddDevicePage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Add Device\"]")
	public MobileElement addDeviceTitle;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeOther[@name=\"NavigationBar_Button_Back\"]")
	public MobileElement backIcon;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeOther[@name=\"NavigationBar_Button_Help\"]")
	public MobileElement helpIcon;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_Add_Device_Screen_Button\"]")
	public MobileElement addDeviceButton;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Add_Device_Screen_Label_DeviceError\"]")
	public MobileElement addDeviceErrorMessage;

	public NetworkDevicePrioritySettingsAddDevicePage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public FooterIconsPage getFooterIconsPageObject() {
		FooterIconsPage footerIconsPage = new FooterIconsPage();
		return footerIconsPage;
	}

	public NetworkDevicePrioritySettingsAddDeviceHelpPage getAddDevicePriorityHelpPageObject() {
		NetworkDevicePrioritySettingsAddDeviceHelpPage addDevice = new NetworkDevicePrioritySettingsAddDeviceHelpPage();
		return addDevice;
	}
	
	public NetworkDevicePrioritySettingsSelectAtleatOneDeviceAlertDialog getSelectDeviceAlertDialogObject() {
		NetworkDevicePrioritySettingsSelectAtleatOneDeviceAlertDialog selectDevice = new NetworkDevicePrioritySettingsSelectAtleatOneDeviceAlertDialog();
		return selectDevice;
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
			return true;
		} else {
			utils.log().info("Help button is not displayed");
			return false;
		}
	}

	public boolean clickAddDeviceButton() {
		if (addDeviceButton.isDisplayed()) {
			click(addDeviceButton);
			utils.log().info("                             ");
			utils.log().info("Clicked on Add Device button");
			return true;
		} else {
			utils.log().info("Add Device button is not displayed");
			return false;
		}
	}


	public boolean verifyUIOnAddDevicePage() {
		utils.log().info("                                                 ");
		utils.log().info("*************************************************");
		utils.log().info("Verifying UI Elements on Add Device Settings Page");
		utils.log().info("*************************************************");
		try {
			if (addDeviceTitle.isDisplayed())
				utils.log().info(addDeviceTitle.getText() + " title text is displayed ");
			else
				utils.log().info("Add Device title text is displayed ");

			if (backIcon.isDisplayed())
				utils.log().info("Back Icon is displayed ");
			else
				utils.log().info("Back Icon is not displayed ");

			if (helpIcon.isDisplayed())
				utils.log().info("Help Icon is displayed");
			else
				utils.log().info("Help Icon is not displayed ");

			if (addDeviceButton.isDisplayed())
				utils.log().info("Add Device button is displayed");
			else
				utils.log().info("Add Device button is not displayed ");

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyDeviceListForPrioritization() {
		utils.log().info("                                   ");
		utils.log().info("***********************************");
		utils.log().info("List of Devices on Add Device Page ");
		utils.log().info("***********************************");
		
		int size = super.getDriver().findElements(By.xpath(
		"//XCUIElementTypeApplication[@name=\"SBC Test\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable")).size();

		utils.log().info("Count of device : " + size);
		
		try {
			for (int i = 1; i <= size ; i++) 
			{
				utils.log().info("                          ");
				utils.log().info("Add Device Details  : " + i);
				utils.log().info("--------------------------");

				List<MobileElement> entity = (List<MobileElement>) 
				super.getDriver().findElementsByXPath("//XCUIElementTypeApplication[@name=\"SBC Test\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell["+i+"]");

				for (MobileElement e : entity) 
				{
					if (e.findElementByXPath("//XCUIElementTypeImage[@name=\"Network_Add_Device_Screen_Image_Device["+i+"]\"]").isDisplayed())
						utils.log().info("Device Image is displayed");

					if ((e.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Network_Add_Device_Screen_Label_Device["+i+"]\"]").isDisplayed()))
						utils.log().info("Device Name : " + e.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Network_Add_Device_Screen_Label_Device["+i+"]\"]").getText() + " is displayed");

					if (e.findElementByXPath("//XCUIElementTypeImage[@name=\"Network_Add_Device_Screen_Button_CheckBox["+i+"]\"]").isDisplayed())
						utils.log().info("Checkbox is displayed");
				}
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean selectDeviceFromList() {
		utils.log().info("                                     ");
		utils.log().info("*************************************");
		utils.log().info("Selecting Devices on Add Device Page ");
		utils.log().info("*************************************");
		
//		int size = super.getDriver().findElements(By.xpath(
//		"//androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView")).size();
		
		try {
			for (int i = 1; i <= 1 ; i++) 
			{
				utils.log().info("Selecting Device From Add Device " );
				utils.log().info("---------------------------------");

				List<MobileElement> entity = (List<MobileElement>) 
				super.getDriver().findElementsByXPath("//XCUIElementTypeApplication[@name=\"SBC Test\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell["+i+"]");

					for (MobileElement e : entity) 
					{
						if (e.findElementByXPath("//XCUIElementTypeImage[@name=\"Network_Add_Device_Screen_Image_Device["+i+"]\"]").isDisplayed())
							utils.log().info("Device Image is displayed");

						if ((e.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Network_Add_Device_Screen_Label_Device["+i+"]\"]").isDisplayed()))
							utils.log().info("Device Name : " + e.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Network_Add_Device_Screen_Label_Device["+i+"]\"]").getText() + " is displayed");

						if (e.findElementByXPath("//XCUIElementTypeImage[@name=\"Network_Add_Device_Screen_Button_CheckBox["+i+"]\"]").isDisplayed())
							utils.log().info("Checkbox is displayed");
						click(e.findElementByXPath("//XCUIElementTypeImage[@name=\"Network_Add_Device_Screen_Button_CheckBox["+i+"]\"]"));
						utils.log().info("Clicked on checkbox");
					}
			}
			return true;
		} catch (Exception e) {
			return false;}
	}


	@Override
	public boolean isAt() {
		if (addDeviceTitle.isDisplayed()) {
			utils.log().info("On Add Device Settings Page");
			return true;
		} else {
			utils.log().info("Not on Add Device Settings Page");
			return false;
		}
	}
}
