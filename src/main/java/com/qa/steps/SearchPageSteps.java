package com.qa.steps;

import org.junit.Assert;

import com.qa.pages.SearchPage;

import net.thucydides.core.annotations.Step;

public class SearchPageSteps {

	SearchPage searchPageObj;

	@Step("The car name should be displayed as {0}")
	public void carNameIsDisplayedAs(String carName) {
		String carNameDisplayed = searchPageObj.getCarNameDisplayed();
		System.out.println("Actual car name displayed: " + carNameDisplayed);
		System.out.println("Expected car name to be displayed: " + carName);
		Assert.assertTrue("Expected and Actual car Name are not same", carNameDisplayed.equals(carName));
	}

	@Step("The car price should be displayed as {0}")
	public void carPriceIsDisplayedAs(String carPrice) {
		String carPriceDisplayed = searchPageObj.getCarPriceDisplayed();
		System.out.println("Actual car price displayed: " + carPriceDisplayed);
		System.out.println("Expected car price to be displayed: " + carPrice);
		Assert.assertTrue("Expected and actual car price are not same", carPriceDisplayed.equals(carPrice));

	}

	@Step("The car EMI should be displayed as {0}")
	public void carEMIisDisplayedAs(String eMI) {
		String carEMIDisplayed = searchPageObj.getCarEMIDisplayed();
		System.out.println("Actual car EMI displayed: "+carEMIDisplayed);
		System.out.println("Expected car EMI to be displayed: "+eMI);
		Assert.assertTrue("The expected and actual car EMI displayed are not same", carEMIDisplayed.equals(eMI));
	}

}
