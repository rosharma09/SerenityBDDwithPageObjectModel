package com.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.qa.base.TestBase;

import net.serenitybdd.core.pages.WebElementFacade;

public class UpcomingNewCarPage extends TestBase {

	String newUpcomingCarList = "xpath=//ul[@class = 'o-fznVme']/li";

	public List<String> getAllNewUpcomingCarsName() {
		List<WebElement> upcomingCarList = getElements(newUpcomingCarList);
		List<String> carNames = new ArrayList<String>();

		for (WebElement car : upcomingCarList) {
			carNames.add(car.findElement(By.tagName("span")).getText());
		}

		return carNames;
	}
}
