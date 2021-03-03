package com.qa.steps;

import java.util.List;
import java.util.Map;

import com.qa.pages.FindNewCarPage;

import net.thucydides.core.annotations.Step;

public class NewCarPageSteps {

	FindNewCarPage findNewCarPage;

	@Step
	public void searchNewCarwithBrandAs(String carBrand) {
		findNewCarPage.clickOnTheBrand(carBrand);
	}

	@Step
	public void carsForTheBrandAreDisplayed() {
		Map<String, String> carPriceDetails = findNewCarPage.getCarPriceDetails();
		System.out.println(carPriceDetails);

	}

	@Step
	public void clickOnBodyType() {
		findNewCarPage.clickBodyTypeLabel();
	}

	@Step
	public void selectTheBodyTypeAs(String bodyType) {
		findNewCarPage.clickOnBodyType(bodyType);
		String heading = findNewCarPage.getHeading();
		int carCount = findNewCarPage.carCountLabel();

		System.out.println("Body Type Label Displayed: " + heading);
		System.out.println("Car count displayed :" + carCount);
		// Assert.assertTrue("Body Type Clicked and Body type displayed are not same",
		// heading.contains(bodyType));

	}
	
	@Step
	public void clickOnPetrolType() {
		findNewCarPage.clickPetrolTypeLabel();
	}

	@Step
	public void selectTheFuelTypeAs(String fuelType) {
		findNewCarPage.selectFuelTypeAs(fuelType);
	}

	@Step
	public void carForTheSpecifiedFuelTypeAreDisplayed() {
		List<String> carName = findNewCarPage.getFuelSpecificCarNames();
		List<String> carPrices = findNewCarPage.getFuelSpecificCarPrices();

		System.out.println(carName);
		System.out.println(carPrices);
		
	}

	@Step
	public void updateTheCarDetailsFor(String fuelType) {
		List<String> carName = findNewCarPage.getFuelSpecificCarNames();
		List<String> carPrices = findNewCarPage.getFuelSpecificCarPrices();
		findNewCarPage.writeCarPriceInFile(fuelType, carName, carPrices);
	}

}
