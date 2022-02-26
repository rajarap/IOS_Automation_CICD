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

public class TurnOnBluetoothDialog extends ParentClass implements Page
{
	//This page is displayed when the Proceed button is clicked on the Troubleshoot-Bluetooth Connection Failed Page
	public TestUtils utils = new TestUtils();
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/dialog_title") 
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/dialog_title']") // text = YOUR BLUETOOTH IS DISABLED
	public MobileElement bluetoothIsDisabledText;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/dialog_description") 
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/dialog_description']") 
	// text = To continue, we need to have Bluetooth enabled to connect with the router. Please enable Bluetooth through the button below or through Settings menu.
	public MobileElement enableBluetoothMessage;
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/btn_dialog_ble_ok']"), // text = NEXT
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[162,1250][918,1387]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/btn_dialog_ble_ok") 
	})
	public MobileElement turnOnBluetoothButton;
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/btn_dialog_ble_cancel']"), // text = NEXT
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[162,1415][918,1552]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/btn_dialog_ble_cancel") 
	})
	public MobileElement cancelButton;
	
	public TurnOnBluetoothDialog()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void clickTurnBTONButton()
	{
		utils.log().info("Turn On Bluetooth Dialog - Clicked on TURN ON BLUETOON Button");
		click(turnOnBluetoothButton);
	}
	
	public void clickCancelButton()
	{
		utils.log().info("Turn On Bluetooth Dialog - Clicked on CANCEL Button");
		click(cancelButton);
	}


	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}
	
}
