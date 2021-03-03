package com.qa.testcases;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.qa.steps.HomePageSteps;
import com.qa.steps.NewCarPageSteps;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources/testdata/BodyTypeTestData.csv")
@Concurrent(threads = "4")
public class BodyTypeTest {

	private String BodyType;

	public void setBodyType(String bodyType) {
		BodyType = bodyType;
	}

	@Managed
	WebDriver driverObj;

	@Steps
	HomePageSteps homePageSteps;

	@Steps
	NewCarPageSteps newCarPageSteps;

	@Title(value = "To search the car based on the body type")
	@Test
	public void carBodyTypeSearchTest() {

		// GIVEN
		homePageSteps.NavigateTo();

		// WHEN
		homePageSteps.navigateToNewCarOption();

		// AND
		newCarPageSteps.clickOnBodyType();

		// AND
		newCarPageSteps.selectTheBodyTypeAs(BodyType);

	}

}
