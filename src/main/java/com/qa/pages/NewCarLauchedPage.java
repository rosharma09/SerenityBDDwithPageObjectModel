package com.qa.pages;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.qa.base.TestBase;

import net.serenitybdd.core.pages.WebElementFacade;

public class NewCarLauchedPage extends TestBase {

	private String carName = "xpath=//ul//h3";
	private String nextPageNavigator = "xpath=//a[@class = 'o-cYOpxG o-cpnuEd o-dsiSgT o-NBTwp o-eemiLE o-OisZk o-cRLvC o-elzeOy']";
	private String newCarLauchesHeader = "xpath=//h1";
	private Map<String, String> carDetails;

	public Map<String, String> getNewLaunchedCarDetails() {

		carDetails = new HashMap<String, String>();

		if (getElementUsingLocator(newCarLauchesHeader).isDisplayed()) {

			Iterator<WebElement> it = getElements(carName).iterator();

			while (it.hasNext()) {

				carDetails.put(it.next().getText(),
						it.next().findElement(By.xpath("//parent::a/following-sibling::div[1]/span[1]")).getText());
			}

		}
		return carDetails;
	}

	public void clickonNextPage() {
		clickOnElement(nextPageNavigator);
	}

}
