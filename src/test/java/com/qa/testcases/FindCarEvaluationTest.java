package com.qa.testcases;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.qa.steps.HomePageSteps;
import com.qa.steps.UsedCarValuationSteps;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources/testdata/CarEvaluationTestData.csv")
@Concurrent(threads = "4")
public class FindCarEvaluationTest {

	private String mfgYr;
	private String mfgMnth;
	private String make;
	private String model;
	private String version;
	private String city;
	private String owner;
	private String kilo;
	private String FairConditionPrice;
	private String GoodConditionPrice;
	

	public void setMfgYr(String mfgYr) {
		this.mfgYr = mfgYr;
	}

	public void setMfgMnth(String mfgMnth) {
		this.mfgMnth = mfgMnth;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public void setKilo(String kilo) {
		this.kilo = kilo;
	}

	public void setFairConditionPrice(String fairConditionPrice) {
		FairConditionPrice = fairConditionPrice;
	}

	public void setGoodConditionPrice(String goodConditionPrice) {
		GoodConditionPrice = goodConditionPrice;
	}

	@Managed
	WebDriver driverObj;

	@Steps
	HomePageSteps homePageSteps;

	@Steps
	UsedCarValuationSteps usedCarEvaluationSteps;

	@Test
	public void findUsedCarEvaluationParameterizedTest() {
		// Given
		homePageSteps.NavigateTo();

		// When
		homePageSteps.navigateToUsedCarEvaluation();

		// Then
		usedCarEvaluationSteps.userIsOnTheUsedCarEvaluationPage();

		// When
		usedCarEvaluationSteps.enterTheCarDetails(mfgYr, mfgMnth, make, model, version, city, owner, kilo);

		//And 
		usedCarEvaluationSteps.clickOnTheChecValueBtn();
		
		//Then
		usedCarEvaluationSteps.evaluatedCarValueIsDisplayedAs(FairConditionPrice,GoodConditionPrice);
	}

}
