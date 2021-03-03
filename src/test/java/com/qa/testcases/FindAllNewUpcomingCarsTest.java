package com.qa.testcases;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.qa.steps.FindNewCarPageSteps;
import com.qa.steps.HomePageSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class FindAllNewUpcomingCarsTest {

	@Managed
	WebDriver driverObj;

	@Steps
	HomePageSteps homePageSteps;
	
	@Steps
	FindNewCarPageSteps findNewCarPageSteps;

	@Test
	public void findANewCarTest() {
		// Given
		homePageSteps.NavigateTo();
		
		//When 
		homePageSteps.findNewUpcomingCars();

		// Then
		findNewCarPageSteps.upcomingCarsAredisplayed();
	}
}
