package com.qa.testcases;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.qa.steps.HomePageSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class FindNewCarTest {

	@Managed
	WebDriver driverObj;
	
	@Steps
	HomePageSteps homePageSteps;
	
	@Test
	public void findANewCarTest() {
		homePageSteps.NavigateTo();
		homePageSteps.navigateToNewCarOption();
	}
}
