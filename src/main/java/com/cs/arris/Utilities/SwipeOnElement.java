package com.cs.arris.Utilities;

import org.openqa.selenium.Dimension;

import com.cs.arris.Base.ParentClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class SwipeOnElement extends ParentClass {
	public TestUtils utils = new TestUtils();
	
	//method to left and right swipe on the screen based on coordinates
	public void swipeAction(int Xcoordinate, int Ycoordinate, String direction) 
	{
	    //get device width and height
	    Dimension dimension = super.getDriver().manage().window().getSize();
	    int deviceHeight = dimension.getHeight();
	    int deviceWidth = dimension.getWidth();
	    utils.log().info("Height x Width of device is: " + deviceHeight + " x " + deviceWidth);

	    switch (direction) {
	        case "Left":
	        	utils.log().info("Swipe Right to Left");
	            //define starting and ending X and Y coordinates
	            int startX=deviceWidth - Xcoordinate;
	            int startY=Ycoordinate; // (int) (height * 0.2);
	            int endX=Xcoordinate;
	            int endY=Ycoordinate;
	            //perform swipe from right to left
	            new TouchAction((AppiumDriver) driver).longPress(PointOption.point(startX, startY)).moveTo(PointOption.point(endX, endY)).release().perform();
	            break;

	        case "Right":
	        	utils.log().info("Swipe Left to Right");
	            //define starting X and Y coordinates
	            startX=Xcoordinate;
	            startY=Ycoordinate;
	            endX=deviceWidth - Xcoordinate;
	            endY=Ycoordinate;
	            //perform swipe from left to right
	            new TouchAction((AppiumDriver) driver).longPress(PointOption.point(startX, startY)).moveTo(PointOption.point(endX, endY)).release().perform();
	            break;
	    }
	}
	

//	int elementX= driver.findElement(elementLocator).getLocation().getX();
//	int elementY= driver.findElement(elementLocator).getLocation().getY();

}
