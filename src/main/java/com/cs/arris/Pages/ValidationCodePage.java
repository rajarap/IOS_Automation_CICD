package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class ValidationCodePage extends ParentClass implements Page
{
	TestUtils utils = new TestUtils();
	SoftAssert softAssert;
	
	@AndroidFindBy (xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[3]") 
	private MobileElement validationCodeText;
	
	@AndroidFindBy (xpath ="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[4]")
	private MobileElement validationCodeMessage;
	
	@AndroidFindBy (xpath ="com.arris.sbcBeta:id/ivDialogClose")
	private MobileElement closeDialog;
	
	public ValidationCodePage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	
	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}
	

}
