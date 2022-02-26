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

public class Error_0000_1401_Downloading_Firmware_File_Failed_Page extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/btn_generic_error_retry]"), //text= TRY AGAIN
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[119,2004][961,2042]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/btn_generic_error_retry") 
	})
	public MobileElement tryAgainButton;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/title_text") 
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/title_text]") // text = DOWNLOADING OF THE FILE FAILED.
	public MobileElement downloadingFileFailedTitle;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/tv_description_text") 
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/title_text_troubleshoot']") 
	// text = The download of your firmware file failed. Please restart your router to re-download the file.
	public MobileElement downloadingFileFailedMessage;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/tv_error_code_text]") // text = 0000-1401
	public MobileElement errorCode;
	
	public Error_0000_1401_Downloading_Firmware_File_Failed_Page()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public String getDownloadingFirmwareFileText()
	{
		utils.log().info("Downloading Firmware File Failed Page - Retrieving Downloading Firmware File Failed Text");
		return downloadingFileFailedTitle.getText();
	}
	
	public String getDownloadingFirmwareFileMessage()
	{
		utils.log().info("Downloading Firmware File Failed Page - Retrieving Downloading Firmware File Failed Text");
		return downloadingFileFailedMessage.getText();
	}
	
	public String getDownloadingFirmwareFileErrorCode()
	{
		utils.log().info("Downloading Firmware File Failed Page - Retrieving Downloading Firmware File Failed Error Code");
		if (errorCode.isDisplayed())
			return errorCode.getText();
		else
			return "Error code is not displayed on the BDownloading Firmware File Failed Page";
	}
	
	public void clickTryAgainButton()
	{
		click(tryAgainButton);
		utils.log().info("Downloading Firmware File Failed Page - Clicked Try Again button");
	}
	
	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}
	

}
