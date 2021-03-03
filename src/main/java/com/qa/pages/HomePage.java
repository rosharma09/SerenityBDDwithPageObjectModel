package com.qa.pages;

import java.util.Iterator;

import org.openqa.selenium.WebElement;

import com.qa.base.TestBase;

public class HomePage extends TestBase {

	// o-cpnuEd o-XylGE _1fftdA
	String allCarOptionsList = "className=o-bkmzIL o-cpnuEd";
	String newCarMenuOption = "xpath=//*[text() = 'NEW CARS']";
	String findNewCarOption = "xpath=//*[text() = 'Find New Cars']";
	String findUpcomingCarOption = "xpath=//*[text() = 'Upcoming Cars']";
	String usedCarOption = "xpath=//*[text() = 'USED CARS']";
	String checkCarEvaluation = "xpath=//*[text() = 'Check Car Valuation']";
	String newCarLaunchesOption = "xpath=//*[text() = 'New Launches']";
	String headerSearchBar = "xpath=//header//input";
	String carOptionsDisplayed = "xpath=//div[@class = 'o-eEgygU o-eZTujG o-eemiLE  ']//li/div/span/mark";

	public FindNewCarPage findNewCarFunctionality() {
		moveMouseTo(newCarMenuOption);
		clickOnElement(findNewCarOption);
		return this.switchToPage(FindNewCarPage.class);

	}

	public UpcomingNewCarPage upComingNewNewCarFunctionality() {
		moveMouseTo(newCarMenuOption);
		clickOnElement(findUpcomingCarOption);
		return new UpcomingNewCarPage();

	}

	public UsedCarEvaluationPage getToUsedCarEvaluationSection() {
		moveMouseTo(usedCarOption);
		clickOnElement(checkCarEvaluation);
		return new UsedCarEvaluationPage();
	}

	public void findNewCarLaunches() {
		moveMouseTo(newCarMenuOption);
		clickOnElement(newCarLaunchesOption);
	}

	public void searchCar(String carName) {
		System.out.println("Searching for the car: " + carName);
		enterTextInto(headerSearchBar, carName);
		
		waitFor(getElementUsingLocator("xpath=//div[@class = 'o-eEgygU o-eZTujG o-eemiLE  ']//li"));
		String carOptionsDisplayed = "xpath=//div[@class = 'o-eEgygU o-eZTujG o-eemiLE  ']//li/div/span";
		Iterator<WebElement> it = getElements(carOptionsDisplayed).iterator();

		while (it.hasNext()) {
			String currentOptionText = it.next().getText();
			System.out.println("Checking the car Option: " +currentOptionText);
			if (currentOptionText.equals(carName)) {
				clickOn(it.next());
				break;
			}
		}
	}

}
