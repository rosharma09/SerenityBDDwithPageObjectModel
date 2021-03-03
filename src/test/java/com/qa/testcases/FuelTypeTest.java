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
public class FuelTypeTest {

	@Managed
	WebDriver driverObj;

	@Steps
	HomePageSteps homePageSteps;

	@Steps
	NewCarPageSteps newCarPageSteps;

	@Title(value = "To check the car of fuel type as Petrol")
	@Test
	public void fuelTypeTest1() {
		// GIVEN
		homePageSteps.NavigateTo().navigateToNewCarOption().clickPetrolTypeLabel();

		// WHEN
		newCarPageSteps.selectTheFuelTypeAs("Petrol");

		// THEN
		newCarPageSteps.carForTheSpecifiedFuelTypeAreDisplayed();

		// THEN
		newCarPageSteps.updateTheCarDetailsFor("Petrol");

	}

	@Title(value = "To check the car of fuel type as Diesel")
	@Test
	public void fuelTypeTest2() {
		// GIVEN
		homePageSteps.NavigateTo().navigateToNewCarOption().clickPetrolTypeLabel();

		// WHEN
		newCarPageSteps.selectTheFuelTypeAs("Diesel");

		// THEN
		newCarPageSteps.carForTheSpecifiedFuelTypeAreDisplayed();

		// THEN
		newCarPageSteps.updateTheCarDetailsFor("Diesel");

	}

	@Title(value = "To check the car of fuel type as CNG")
	@Test
	public void fuelTypeTest3() {
		// GIVEN
		homePageSteps.NavigateTo().navigateToNewCarOption().clickPetrolTypeLabel();

		// WHEN
		newCarPageSteps.selectTheFuelTypeAs("CNG");

		// THEN
		newCarPageSteps.carForTheSpecifiedFuelTypeAreDisplayed();

		// THEN
		newCarPageSteps.updateTheCarDetailsFor("CNG");

	}

}
