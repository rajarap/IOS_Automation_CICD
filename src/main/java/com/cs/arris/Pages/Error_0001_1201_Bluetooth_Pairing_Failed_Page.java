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

public class Error_0001_1201_Bluetooth_Pairing_Failed_Page extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/btn_generic_error_retry]"), //text= TRY AGAIN
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[119,2004][961,2042]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/btn_generic_error_retry") 
	})
	public MobileElement tryAgainButton;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/title_text") 
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/title_text]") // text = BLUETOOTH PAIRING FAILED
	public MobileElement bluetoothPairingTitleText;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/tv_description_text") 
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/title_text_troubleshoot']") 
	// text = Please ensure that Bluetooth is enabled and that your mobile device is close to the powered-on router.
	public MobileElement enableBluetoothText;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/tv_error_code_text") // text = 0001-1201
	public MobileElement errorCode;
	
	public Error_0001_1201_Bluetooth_Pairing_Failed_Page()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public String getBluetoothPairingText()
	{
		utils.log().info("Bluetooth Pairing Failed Page - Retrieving Bluetooth Pairing Failed Text");
		return bluetoothPairingTitleText.getText();
	}
	
	public String getEnableBluetoothdMessage()
	{
		utils.log().info("Bluetooth Pairing Failed Page - Retrieving Enable Bluetooth Pairing Text");
		return enableBluetoothText.getText();
	}
	
	public String getBluetoothPairingErrorCode()
	{
		utils.log().info("Bluetooth Pairing Failed Page - Retrieving Bluetooth Pairing Failed Error Code");
		if (errorCode.isDisplayed())
			return errorCode.getText();
		else
			return "Error code is not displayed on the Bluetooth Connection Failed Page";
	}
	
	public void clickTryAgainButton()
	{
		click(tryAgainButton);
		utils.log().info("Bluetooth Pairing Failed Page - Clicked Try Again button");
	}
	
	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}
	

}
