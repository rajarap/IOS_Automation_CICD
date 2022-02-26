package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SamplePage extends ParentClass {
	static TestUtils utils = new TestUtils();
	
	public SamplePage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this); 
	}
	
	public void displayAppiumURL() {
		utils.log("######  displayAppiumURL  ######");
		System.out.println(getProps().getProperty("appiumURL"));
	}
	
	public void displayAppLocation() {
		utils.log("######  displayAppLocation  ######");
		System.out.println(getProps().getProperty("androidAppLocation"));
	}

	public void displayAutomationName() {
		utils.log("######  displayAutomationName  ######");
		System.out.println(getProps().getProperty("androidAutomationName"));
	}
	
	public void displayUDID() {
		utils.log("######  displayUDID  ######");
		System.out.println(getProps().getProperty("androidUDID"));
	}
	
	public void displayAndroidHome() {
		utils.log("######  displayAndroidHome  ######");
		System.out.println(getProps().getProperty("androidHome"));
	}
	
	public void displayJVMLocation() {
		utils.log("######  displayJVMLocation  ######");
		System.out.println(getProps().getProperty("jvmHome"));
	}
}

