package com.qa.steps;

import java.util.Map;

import com.qa.pages.NewCarLauchedPage;

import net.thucydides.core.annotations.Step;

public class NewCarLaunchesPageSteps {

	NewCarLauchedPage newCarLaunchedPageObj;

	@Step
	public void allTheNewCarLauchedAreDisplayed() {

		System.out.println(newCarLaunchedPageObj.getNewLaunchedCarDetails());
	}

	@Step
	public void clickOnTheNextPage() {
		newCarLaunchedPageObj.clickonNextPage();
	}

}
