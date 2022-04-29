package com.cs.arris.Utilities;

import com.cs.arris.Base.ParentClass;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class TapSevenTimes extends ParentClass{
	
	public TestUtils utils = new TestUtils();
	public TouchAction action = new TouchAction(super.getDriver());
	
	@SuppressWarnings("rawtypes")
	public void tapSeven() {
		int x = 187;
		int y = 458;
		PointOption p = new PointOption();
		p.withCoordinates(x, y);
		utils.log().info("Tapping 7 times");
		
		for(int i=1; i <= 7; i++) {
			action.tap(p).release().perform();
		}
	}
}
