package com.qa.pages;

import com.qa.base.TestBase;

public class SearchPage extends TestBase {

	private String carNameheader = "xpath=//h1";
	private String carPriceDisplayed = "xpath=//div[@class = 'o-fznVCs o-fHmpzP o-fzptZB']//div[@class = 'o-cpnuEd o-NBTwp o-SoIQT']/span";
	private String carEMIdisplayed = "xpath=//div[@class = ' o-efHQCX VGxBt8 o-cpnuEd']/div/div[1]";
	
	public String getCarNameDisplayed() {

		return getElementUsingLocator(carNameheader).getText();

	}

	public String getCarPriceDisplayed() {
		return getElementUsingLocator(carPriceDisplayed).getText();
	}

	public String getCarEMIDisplayed() {
		return getElementUsingLocator(carEMIdisplayed).getText();
	}

}
