package com.qa.testcases;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.qa.steps.HomePageSteps;
import com.qa.steps.NewCarPageSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class FindNewCarbyBrandTest {

	@Managed
	WebDriver driverObj;

	@Steps
	HomePageSteps homePageSteps;

	@Steps
	NewCarPageSteps newCarPageSteps;

	@Title(value = "To check the find new car of brand Tata Using the find new car feature")
	@Test
	public void findNewcarByBrand() {
		// Given
		homePageSteps.NavigateTo();

		// And
		homePageSteps.navigateToNewCarOption();

		// When
		newCarPageSteps.searchNewCarwithBrandAs("Tata");

		// Then
		newCarPageSteps.carsForTheBrandAreDisplayed();
	}

	@Title(value = "To check the find new car of brand Kia Using the find new car feature")
	@Test
	public void findNewcarByBrand1() {
		// Given
		homePageSteps.NavigateTo();

		// And
		homePageSteps.navigateToNewCarOption();

		// When
		newCarPageSteps.searchNewCarwithBrandAs("Kia");

		// Then
		newCarPageSteps.carsForTheBrandAreDisplayed();
	}

	@Title(value = "To check the find new car of brand Hyundai Using the find new car feature")
	@Test
	public void findNewcarByBrand2() {
		// Given
		homePageSteps.NavigateTo();

		// And
		homePageSteps.navigateToNewCarOption();

		// When
		newCarPageSteps.searchNewCarwithBrandAs("Hyundai");

		// Then
		newCarPageSteps.carsForTheBrandAreDisplayed();
	}

	@Title(value = "To check the find new car of brand Mercedes-Benz Using the find new car feature")
	@Test
	public void findNewcarByBrand3() {
		// Given
		homePageSteps.NavigateTo();

		// And
		homePageSteps.navigateToNewCarOption();

		// When
		newCarPageSteps.searchNewCarwithBrandAs("Mercedes-Benz");

		// Then
		newCarPageSteps.carsForTheBrandAreDisplayed();
	}

}
