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

public class Error_0005_1200_Bluetooth_Connection_Failed_Page extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/btn_generic_error_retry']"),//text = TRY AGAIN
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[119,2004][961,2042]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/btn_generic_error_retry") 
	})
	public MobileElement tryAgainButton;
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/btn_generic_troubleshoot']"),//text = TROUBLESHOOT
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[119,2004][961,2042]"),
		@AndroidBy (id = "com.arris.sbcBeta:id/btn_generic_troubleshoot") 
	})
	public MobileElement troubleShootButton;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/title_text") 
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/title_text']") // text = BLUETOOTH CONNECTION FAILED
	public MobileElement bluetoothConnectionFailedText;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/tv_description_text") 
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/tv_description_text']") // text = 	
	//Please ensure that Bluetooth is enabled and that your mobile device is close to the powered-on router.
	//The above message is displayed when bluetooth is enabled and your mobile device is not close to the router
	public MobileElement bluetoothConnectionFailedMessage1;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/tv_description_text") 
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/tv_description_text']") // text = 	
	//Bluetooth is not enabled or location permission is not enabled on your device.  
	//The above message is displayed when bluetooth is not enable on the mobile device
	public MobileElement bluetoothConnectionFailedMessage2;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/tv_error_code_text") 
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/tv_error_code_text']") // text = 0001-1201
	public MobileElement errorCode;  
	
	public Error_0005_1200_Bluetooth_Connection_Failed_Page()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public String getBluetoothFailedText()
	{
		utils.log().info("Bluetooth Connection Failed Page - Retrieving Bluetooth Connection Failed Text");
		return bluetoothConnectionFailedText.getText();
	}
	
	public String getBluetoothFailedMessage1()
	{
		utils.log().info("Bluetooth Connection Failed Page - Retrieving Bluetooth Connection Failed Message");
		return bluetoothConnectionFailedMessage1.getText();
	}
	
	public String getBluetoothFailedMessage2()
	{
		utils.log().info("Bluetooth Connection Failed Page - Retrieving Bluetooth Connection Failed Message");
		return bluetoothConnectionFailedMessage2.getText();
	}
	
	public String getBluetoothConnectionErrorCode()
	{
		utils.log().info("Bluetooth Connection Failed Page - Retrieving Bluetooth Connection Failed Error Code");
		if (errorCode.isDisplayed())
			return errorCode.getText();
		else
			return "Error code is not displayed on the Bluetooth Connection Failed Page";
	}
	
	//enable bluetooth before clicking try again button
	public void clickTryAgainButton()
	{
		click(tryAgainButton);
		utils.log().info("Bluetooth Connection Failed Page - Clicked Try Again button");
	}
	
	//if try again fails, troubleshoot button will be displayed.
	public void clickTroubleShootButton()
	{
		click(troubleShootButton);
		utils.log().info("Bluetooth Connection Failed Page - Clicked TroubleShoot button");
	}
	
	@Override
	public boolean isAt() {
		if(errorCode.isDisplayed())
		{
			utils.log().info("At Bluetooth Connection Failed Page displayed");
			return true;
		}
		else
		{
			utils.log().info("Bluetooth Connection Failed Page is not displayed");
			return false;
		}
			
	}

}
