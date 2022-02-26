package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.offset.PointOption;

public class MailErrorLogsPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();
	public TouchAction action = new TouchAction(getDriver());
	

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Mail.sendButton\"]")
	public MobileElement sendButton;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Mail.cancelSendButton\"]")
	public MobileElement cancelButton;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"ComposeRecipientAddButton\"]")
	public MobileElement addEmailAddressButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"#mobdevsupport@commscope.com\"]")
	public MobileElement existingEmailAddressButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"toField\"]")
	public MobileElement toFieldTextBox;
	
	public MailErrorLogsPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public boolean clickCancelButton() {
		if (cancelButton.isDisplayed()) {
			click(cancelButton); 
			utils.log().info("Clicked Cancel Button");
			return true;
		} else {
			return false;
		}
	}
	
	public boolean clickSendButton() {
		if (sendButton.isDisplayed()) {
			click(sendButton); 
			utils.log().info("Clicked Send Button");
			return true;
		} else {
			return false;
		}
	}
	
	public boolean enterEmailAddress() {
		if (toFieldTextBox.isDisplayed()) {
			clear(toFieldTextBox);
			sendKeys(toFieldTextBox, super.getProps().getProperty("emailid"));
			utils.log().info("Entered email address in To field");
			return true;
		} else {
			return false;
		}
	}
	
	public void checkError() {
		int x = 187;
		int y = 458;
		PointOption p = new PointOption();
		p.withCoordinates(x, y);
		
		for(int i=0; i <= 7; i++) {
			action.tap(p);
			action.release().perform();
		}
	}

	

	@Override
	public boolean isAt() {
		if (sendButton.isDisplayed()) {
			utils.log().info("On Error Log File Email Compose Page");
			return true;
		} else {
			utils.log().info("Not on Error Log File Email Compose Page");
			return false;
		}
	}
}
