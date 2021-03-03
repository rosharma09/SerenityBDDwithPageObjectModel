package com.qa.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.qa.base.TestBase;

public class FindNewCarPage extends TestBase {

	private String carTitle = "xpath=//ul//h3";
	private String bodyTypeLabel = "xpath=//span[text() = 'BODY TYPE']";
	private String FuelTypeLabel = "xpath=//span[text() = 'FUEL TYPE']";
	private String carNames = "xpath=//h2/span";
	private String carPrices = "xpath=//parent::h2/parent::a//following-sibling::div/div[1]/span";

	public void clickOnTheBrand(String carBrand) {
		clickOnElement("xpath=//div[text()='" + carBrand + "']");
	}

	public Map<String, String> getCarPriceDetails() {
		Map<String, String> carPriceHashMap = new HashMap<String, String>();

		Iterator<WebElement> it = getElements(carTitle).iterator();
		while (it.hasNext()) {
			carPriceHashMap.put(it.next().getText(),
					it.next().findElement(By.xpath("//parent::a/following-sibling::div[1]/span[1]")).getText());
		}

		return carPriceHashMap;
	}

	public void clickBodyTypeLabel() {
		clickOnElement(bodyTypeLabel);
	}

	public void clickOnBodyType(String bodyType) {
		clickOnElement("xpath=//span[text() = '" + bodyType + "']");
	}

	public void clickPetrolTypeLabel() {
		clickOnElement(FuelTypeLabel);
	}

	public void selectFuelTypeAs(String fuelType) {
		clickOnElement("xpath=//span[text() ='" + fuelType + "']");
	}

	public List<String> getFuelSpecificCarNames() {
		List<String> carNameList = new ArrayList<String>();

		try {
			Iterator<WebElement> it = getElements(carNames).iterator();
			while (it.hasNext()) {
				carNameList.add(it.next().getText());
			}
		} catch (ElementNotFoundException e) {
			e.getMessage();
		}

		return carNameList;
	}

	public List<String> getFuelSpecificCarPrices() {
		List<String> carPriceList = new ArrayList<String>();

		try {
			Iterator<WebElement> it = getElements(carPrices).iterator();
			while (it.hasNext()) {
				carPriceList.add(it.next().getText());
			}
		} catch (ElementNotFoundException e) {
			e.getMessage();
		}

		return carPriceList;
	}

}
