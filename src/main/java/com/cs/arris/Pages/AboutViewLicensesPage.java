package com.cs.arris.Pages;

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
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class AboutViewLicensesPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"cross\"]")
	public MobileElement closeButton;

	@AndroidFindBy(xpath = "//android.view.View[@bounds='[49,338][1031,1010]']")
	// @AndroidFindBy (xpath =
	// "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.widget.TextView")
	public MobileElement deviceImage;

	@AndroidFindBy(xpath = "//android.widget.TextView[@bounds='[49,1007][1031,1225]']")
	// @AndroidFindBy (xpath =
	// "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.widget.ListView/android.view.View[1]")
	public MobileElement surfboardWarranty;

	@AndroidFindBy(xpath = "//android.widget.TextView[@bounds='[49,1222][1031,1451]']")
	public MobileElement surfboardimage;

	@AndroidFindBy(xpath = "//android.widget.TextView[@bounds='[49,1451][1031,1561]']")
	public MobileElement copyright;

	@AndroidFindBy(xpath = "//android.widget.TextView[@bounds='[49,1558][1031,1668]']")
	public MobileElement arrisWarranty;

	@AndroidFindBy(xpath = "//android.view.View[@bounds='[49,1330][1031,1414]']")
	public MobileElement contents;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Safety and regulatory information']/android.widget.TextView")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Safety and regulatory information\"])[1]")
	public MobileElement safetyAndRegulationLink;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Caring for the environment by recycling your ARRIS equipment']/android.widget.TextView")
	public MobileElement caringForEnvironmentLink;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='FCC statements']/android.widget.TextView")
	public MobileElement fccStatementsLink;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='FCC Interference Statement']/android.widget.TextView")
	public MobileElement fccInterferenceLink;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='FCC Declaration of Conformity']/android.widget.TextView")
	public MobileElement fccDeclarationLink;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='FCC Radiation Exposure Statement']/android.widget.TextView")
	public MobileElement fccRadiationLink;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Industry Canada (IC) Statement']/android.widget.TextView")
	public MobileElement industryCanadaLink;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='IC Radiation Exposure Statement']/android.widget.TextView")
	public MobileElement icRadiationLink;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Avis D'Industrie Canada (IC)']/android.widget.TextView")
	public MobileElement canadaIndustries;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Déclaration de IC Sur L'Exposition Aux Rayonnements']/android.widget.TextView")
	public MobileElement declarationAndExposition;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Wireless LAN information']/android.widget.TextView")
	public MobileElement wirelessLAN;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Restrictions on the use of wireless devices']/android.widget.TextView")
	public MobileElement wirelessRestrictions;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Open Source software information']/android.widget.TextView")
	public MobileElement openSourceInformation;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Software license']/android.widget.TextView")
	public MobileElement softwareLicense;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Privacy notice.']/android.widget.TextView")
	public MobileElement privacyNotice;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Warranty information']/android.widget.TextView")
	public MobileElement warrantyInformation;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Retail purchasers – retail devices']/android.widget.TextView")
	public MobileElement retailPurchase;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Retail purchasers – refurbished retail devices']/android.widget.TextView")
	public MobileElement retailDevices;

	public AboutViewLicensesPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public boolean clickCloseButton() {
		super.swipeUp();
		if (closeButton.isDisplayed()) {
			click(closeButton); 
			utils.log().info("Clicked Close Button");
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyUIOnLicensesPage() {
		try {
			if (deviceImage.isDisplayed())
				utils.log().info("mAX Router Image is displayed");
			else
				utils.log().info("mAX Router Image is not displayed");

			if (surfboardWarranty.isDisplayed())
				utils.log().info("Surfboard Warranty Text : " + surfboardWarranty.getText() + " is displayed");
			else
				utils.log().info("Surfboard Warranty Text is not displayed");

			if (surfboardimage.isDisplayed())
				utils.log().info("Surfboard Image is displayed");
			else
				utils.log().info("Surfboard Image is not displayed");

			if (copyright.isDisplayed())
				utils.log().info("Copyright Text : " + copyright.getText() + " is displayed");
			else
				utils.log().info("Copyright Text is not displayed");

			if (arrisWarranty.isDisplayed())
				utils.log().info("ARRIS warranty Text : " + arrisWarranty.getText() + " is displayed");
			else
				utils.log().info("ARRIS warranty Text is not displayed");

			if (contents.isDisplayed())
				utils.log().info(contents.getText() + " text is displayed");
			else
				utils.log().info("Contents Text is not displayed");

			if (safetyAndRegulationLink.isDisplayed())
				utils.log().info(safetyAndRegulationLink.getText() + " Link is displayed");
			else
				utils.log().info("Safety and regulatory information Link is not displayed");

			if (caringForEnvironmentLink.isDisplayed())
				utils.log().info(caringForEnvironmentLink.getText() + " Link is displayed");
			else
				utils.log().info("Caring for the environment by recycling your ARRIS equipment Link is not displayed");

			if (fccStatementsLink.isDisplayed())
				utils.log().info(fccStatementsLink.getText() + " Link is displayed");
			else
				utils.log().info("FCC statements Link is not displayed");

			if (fccInterferenceLink.isDisplayed())
				utils.log().info(fccInterferenceLink.getText() + " Link is displayed");
			else
				utils.log().info("FCC Interference Statement Link is not displayed");

			if (fccDeclarationLink.isDisplayed())
				utils.log().info(fccDeclarationLink.getText() + " Link is displayed");
			else
				utils.log().info("FCC Declaration of Conformity Link is not displayed");

			if (fccRadiationLink.isDisplayed())
				utils.log().info(fccRadiationLink.getText() + " Link is displayed");
			else
				utils.log().info("FCC Radiation Exposure Statement Link is not displayed");

			super.swipeUp();
			super.pause(3);

			if (industryCanadaLink.isDisplayed())
				utils.log().info(industryCanadaLink.getText() + " Link is displayed");
			else
				utils.log().info("Industry Canada (IC) Statement Link is not displayed");

			if (icRadiationLink.isDisplayed())
				utils.log().info(icRadiationLink.getText() + " Link is displayed");
			else
				utils.log().info("IC Radiation Exposure Statement Link is not displayed");

			if (canadaIndustries.isDisplayed())
				utils.log().info(canadaIndustries.getText() + " Link is displayed");
			else
				utils.log().info("Avis D'Industrie Canada (IC) Link is not displayed");

			if (declarationAndExposition.isDisplayed())
				utils.log().info(declarationAndExposition.getText() + " Link is displayed");
			else
				utils.log().info("Déclaration de IC Sur L'Exposition Aux Rayonnements Link is not displayed");

			if (wirelessLAN.isDisplayed())
				utils.log().info(wirelessLAN.getText() + " Link is displayed");
			else
				utils.log().info("Wireless LAN information Link is not displayed");

			if (wirelessRestrictions.isDisplayed())
				utils.log().info(wirelessRestrictions.getText() + " Link is displayed");
			else
				utils.log().info("Restrictions on the use of wireless devices Link is not displayed");

			if (openSourceInformation.isDisplayed())
				utils.log().info(openSourceInformation.getText() + " Link is displayed");
			else
				utils.log().info("Open Source software information Link is not displayed");

			if (softwareLicense.isDisplayed())
				utils.log().info(softwareLicense.getText() + " Link is displayed");
			else
				utils.log().info("Software license Link is not displayed");

			if (privacyNotice.isDisplayed())
				utils.log().info(privacyNotice.getText() + " Link is displayed");
			else
				utils.log().info("Privacy notice. Link is not displayed");

			if (warrantyInformation.isDisplayed())
				utils.log().info(warrantyInformation.getText() + " Link is displayed");
			else
				utils.log().info("Warranty information Link is not displayed");

			if (retailPurchase.isDisplayed())
				utils.log().info(retailPurchase.getText() + " Link is displayed");
			else
				utils.log().info("Retail purchasers – Retail devices Link is not displayed");

			if (retailDevices.isDisplayed())
				utils.log().info(retailDevices.getText() + " Link is displayed");
			else
				utils.log().info("Retail purchasers – refurbished retail devices Link is not displayed");

			return true;

		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean isAt() {
		if (safetyAndRegulationLink.isDisplayed()) {
			utils.log().info("On View Licenses Page");
			return true;
		} else {
			utils.log().info("Not on View Licenses Help Page");
			return false;
		}
	}
}
