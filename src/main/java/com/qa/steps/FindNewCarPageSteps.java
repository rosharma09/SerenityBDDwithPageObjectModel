package com.qa.steps;

import java.util.List;

import com.qa.pages.UpcomingNewCarPage;

import net.thucydides.core.annotations.Step;

public class FindNewCarPageSteps {
	
	UpcomingNewCarPage upcomingNewCarPageObj;

	@Step
	public void upcomingCarsAredisplayed() {
		List<String> carNames = upcomingNewCarPageObj.getAllNewUpcomingCarsName();
		System.out.println("Below are the car names displayed");
		for (String car : carNames) {
			System.out.println(car);
		}
	}

}
