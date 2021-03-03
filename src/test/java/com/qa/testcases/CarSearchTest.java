package com.qa.testcases;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.qa.steps.HomePageSteps;
import com.qa.steps.SearchPageSteps;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources/testdata/CarSearchTestData.csv")
public class CarSearchTest {
	

	private String CarName;
	private String CarPrice;
	private String EMI;
	
	public void setCarName(String carName) {
		CarName = carName;
	}
	public void setCarPrice(String carPrice) {
		CarPrice = carPrice;
	}
	public void setEMI(String eMI) {
		EMI = eMI;
	}
	
	@Managed
	WebDriver driverObj;
	
	@Steps
	HomePageSteps homePageSteps;
	
	@Steps
	SearchPageSteps searchPageSteps;
	
	@Title(value = "To test the search feature of the carwale website")
	@Test
	public void carSearchTest() {
		//GIVEN
		homePageSteps.NavigateTo();
		
		//WHEN
		homePageSteps.serachForCar(CarName);
		
		//THEN
		searchPageSteps.carNameIsDisplayedAs(CarName);
		searchPageSteps.carPriceIsDisplayedAs(CarPrice);
		searchPageSteps.carEMIisDisplayedAs(EMI);
	}
}
