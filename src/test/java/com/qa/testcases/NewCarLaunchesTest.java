package com.qa.testcases;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.qa.steps.HomePageSteps;
import com.qa.steps.NewCarLaunchesPageSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class NewCarLaunchesTest {

	@Managed
	WebDriver driverObj;

	@Steps
	HomePageSteps homePageSteps;

	@Steps
	NewCarLaunchesPageSteps newCarLaunchesPageSteps;

	@Title(value = "To check the Car details of the newly launched cars")
	@Test
	public void findNewCarLauchDetails() {

		// GIVEN
		homePageSteps.NavigateTo();

		// WHEN
		homePageSteps.navigateToNewCarLaunches();

		// THEN
		newCarLaunchesPageSteps.allTheNewCarLauchedAreDisplayed();

		// When
		newCarLaunchesPageSteps.clickOnTheNextPage();

		// THEN
		newCarLaunchesPageSteps.allTheNewCarLauchedAreDisplayed();
		
		// When
		newCarLaunchesPageSteps.clickOnTheNextPage();

		// THEN
		newCarLaunchesPageSteps.allTheNewCarLauchedAreDisplayed();
		
		// When
		newCarLaunchesPageSteps.clickOnTheNextPage();

		// THEN
		newCarLaunchesPageSteps.allTheNewCarLauchedAreDisplayed();

	}
}
