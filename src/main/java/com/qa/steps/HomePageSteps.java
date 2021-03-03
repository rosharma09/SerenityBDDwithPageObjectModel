package com.qa.steps;

import com.qa.pages.FindNewCarPage;
import com.qa.pages.HomePage;
import com.qa.pages.UpcomingNewCarPage;
import com.qa.pages.UsedCarEvaluationPage;

import net.thucydides.core.annotations.Step;

public class HomePageSteps {

	HomePage homePageObj;
	UpcomingNewCarPage upcomingNewCarPageObj;
	UsedCarEvaluationPage usedCarEvalPageObj;

	@Step
	public HomePageSteps NavigateTo() {
		homePageObj.open();
		return this;
	}

	@Step
	public FindNewCarPage navigateToNewCarOption() {
		return homePageObj.findNewCarFunctionality();
	}

	@Step
	public void findNewUpcomingCars() {
		upcomingNewCarPageObj = homePageObj.upComingNewNewCarFunctionality();

	}

	@Step
	public void navigateToUsedCarEvaluation() {
		usedCarEvalPageObj = homePageObj.getToUsedCarEvaluationSection();
	}

	@Step
	public void navigateToNewCarLaunches() {
		homePageObj.findNewCarLaunches();
	}

	@Step("User search for the car : {0}")
	public void serachForCar(String carName) {
		homePageObj.searchCar(carName);
	}

}
