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

public class ConnectToBlueToothDialog extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"OK\"]")
	public MobileElement okButton;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Don’t Allow\"]")
	public MobileElement dontAllowButton;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"“SBC Test” Would Like to Use Bluetooth\"]")
	public MobileElement connectToBluetoothText;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"SURFboard Central App needs bluetooth permission to connect to router\"]")
	public MobileElement bluetoothPermissionText;
	
	public ConnectToBlueToothDialog()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void clickOkButton()
	{
		String selector = "**/XCUIElementTypeButton[`label == \"OK\"`]";
		utils.log().info("Connect to Bluetooth Page - Clicked on OK Button");
		click(okButton);
	}
	
	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}
	
}
