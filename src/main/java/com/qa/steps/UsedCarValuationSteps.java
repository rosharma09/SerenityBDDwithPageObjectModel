package com.qa.steps;

import org.junit.Assert;

import com.qa.pages.UsedCarEvaluationPage;

import net.thucydides.core.annotations.Step;

public class UsedCarValuationSteps {

	UsedCarEvaluationPage usedCarEvalPageObj;

	@Step("User is redirected to the car evaluation page")
	public void userIsOnTheUsedCarEvaluationPage() {
		String expectedTitle = "Check value of your car for FREE - CarWale";
		String ActualPageTitle = usedCarEvalPageObj.getTitle();
		System.out.println("Current Page Title: " + ActualPageTitle);
		System.out.println("Expected Page Title: " + ActualPageTitle);
		Assert.assertTrue("Title doesn't match", ActualPageTitle.equals(expectedTitle));
	}

	@Step("User enter the required details on the car evaluation page")
	public void enterTheCarDetails(String mfgYr, String mfgMnth, String make, String model, String version, String city,
			String owner, String kilo) {

		usedCarEvalPageObj.enterTheCarDetails(mfgYr, mfgMnth, make, model, version, city, owner, kilo);

	}

	@Step("user click on the calculate value button")
	public void clickOnTheChecValueBtn() {
		usedCarEvalPageObj.clickOnCheckValBtn();
	}

	@Step("The fair price and good price are displayed as {0} and {1}")
	public void evaluatedCarValueIsDisplayedAs(String fairConditionPrice, String goodConditionPrice) {
		String fairPrice = usedCarEvalPageObj.getFairConditionPrice();
		String goodPrice = usedCarEvalPageObj.getGoodConditionPrice();

		System.out.println("Expected fair Price: " + fairConditionPrice);
		System.out.println("Actual fair Price: " + fairPrice);
		Assert.assertTrue("Expected and Actual fair price are not same", fairPrice.equals(fairConditionPrice));
		
		System.out.println("Expected fair Price: " + goodConditionPrice);
		System.out.println("Actual fair Price: " + goodPrice);
		Assert.assertTrue("Expected and Actual fair price are not same", goodPrice.equals(goodConditionPrice));
	}

}
