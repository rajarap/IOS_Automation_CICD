package com.cs.arris.Pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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

public class ParentalControlUserProfileAddRuleDatePickerDialog extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();
	String dateStr;
	String hh;
	String mm;
	String med;

	@AndroidBy(id = "android:id/timePickerLayout")
	public MobileElement datePicker;

	@AndroidFindBy(id = "android:id/button1")
	public MobileElement okButton;

	@AndroidFindBy(id = "android:id/button2")
	public MobileElement cancelButton;
	
	@AndroidFindBy(xpath = "//android.widget.NumberPicker[1]/android.widget.EditText[@resource-id ='android:id/numberpicker_input']")
	public MobileElement hour;
	
	@AndroidFindBy(xpath = "//android.widget.NumberPicker[2]/android.widget.EditText[@resource-id ='android:id/numberpicker_input']")
	public MobileElement min;
	
	@AndroidFindBy(xpath = "//android.widget.NumberPicker/android.widget.EditText[@resource-id ='android:id/numberpicker_input']")
	public MobileElement median;

	public ParentalControlUserProfileAddRuleDatePickerDialog() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public boolean clickOkButton() {
		if (okButton.isDisplayed()) {
			click(okButton);
			utils.log().info("Clicked on OK Button");
			return true;
		} else {
			utils.log().info("OK button is not displayed");
			return false;
		}
	}

	public boolean clickCancelButton() {
		if (cancelButton.isDisplayed()) {
			click(cancelButton);
			utils.log().info("Clicked on Cancel Button");
			return true;
		} else {
			utils.log().info("Cancel button is not displayed");
			return false;
		}
	}

	public boolean verifyUIOnDatePickerDialog() {
		try {
			if (okButton.isDisplayed())
				utils.log().info(okButton.getText() + " button is displayed ");
			else
				utils.log().info("Ok button is not displayed");

			if (cancelButton.isDisplayed())
				utils.log().info(cancelButton.getText() + " button is displayed ");
			else
				utils.log().info("Cancel button is not displayed");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean pickTime() {
		try {
			LocalTime localTime = java.time.LocalTime.now();
			// utils.log().info("Local Time is" + localTime); //19:12:55.514827

			DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
			dateStr = dateFormat.format(new Date()).toString();
		//	utils.log().info("Current Time is  : " + dateStr); // 07.16 PM
			String strPattern = "^0+";
			String dateString = dateStr.replaceAll(strPattern, ""); // 7.16 PM

			String[] str = dateString.split(" "); // 7.16 PM
			med = str[1];
			if (str[0].length() == 4) {
				hh = str[0].substring(0, 1);
				mm = str[0].substring(2);
			} else {
				hh = str[0].substring(0, 2);
				mm = str[0].substring(3);
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean pickHour() {
		try {
			this.pickTime();
			utils.log().info("Current Time is  : " + dateStr); // 07.16 PM
			Integer hrInt = Integer.valueOf(hh);
			Integer hr = hrInt++;
			if (hr == 12) {
				hr = hr -= 11;
				if (med.equals("PM"))
					med = "AM";
				if (med.equals("AM"))
					med = "PM";

				String hrs = Integer.toString(hr);
				utils.log().info("Picked hour is  : " +  hrs);
				sendKeys(hour, hrs);
			} else {
				String hrs = Integer.toString(hr);
				utils.log().info("Picked hour is  : " +  hrs);
				sendKeys(hour, hrs);
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean pickMinute() {
		try {
			this.pickTime();
			Integer minInt = Integer.valueOf(mm);
			Integer mint = minInt += 5;
			if (mint == 59) {
				mint = mint -= 55;
				String mins = Integer.toString(mint);
				utils.log().info("Picked minute is  : " +  mins);
				sendKeys(min, mins);
			} else {
				String mins = Integer.toString(mint);
				utils.log().info("Picked minute is  : " +  mins);
				sendKeys(min, mins);
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean pickMedian() {
		try {
			utils.log().info("Picked median is  : " + med);
			sendKeys(median, med);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean pickYourTime() {
	try {
			MobileElement hour = (MobileElement) super.getDriver().findElement(By
					.xpath("//android.widget.LinearLayout/android.widget.LinearLayout/android.widget.NumberPicker[1]"));
			MobileElement minute = (MobileElement) super.getDriver().findElement(By
					.xpath("//android.widget.LinearLayout/android.widget.LinearLayout/android.widget.NumberPicker[2]"));
			MobileElement median = (MobileElement) super.getDriver().findElement(
					By.xpath("//android.widget.TimePicker/android.widget.LinearLayout/android.widget.NumberPicker"));

			HashMap<String, Object> params = new HashMap<>();
			params.put("order", "next");
			params.put("offset", 0.15);
			params.put("element", hour);
			super.getDriver().executeScript("mobile: swipeGesture", params);

			params.put("order", "next");
			params.put("offset", 0.15);
			params.put("element", minute);
			super.getDriver().executeScript("mobile: swipeGesture", params);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@Override
	public boolean isAt() {
		if (okButton.isDisplayed()) {
			utils.log().info("On Date Picker Dialog");
			return true;
		} else {
			utils.log().info("Not on Date Picker Dialog");
			return false;
		}
	}
}
