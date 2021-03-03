package com.qa.base;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class TestBase extends PageObject {

	/***** COMMON FUNCTIONALITIES *****/

	/**
	 * In order to identify the element on the UI, this function can take the input
	 * as the string of the locator and use it to identify the locator statergy and
	 * return the webELementFacade
	 * 
	 * @param locatorStratergyToUse --> Provide the string for the locator stratergy
	 *                              to be used to identify the element on the UI
	 * @return The WebElementFacade reference variable for the element in picture
	 */
	public WebElementFacade getElementUsingLocator(String locatorStratergyToUse) {

		try {
			return find(getLocator(locatorStratergyToUse));
		} catch (NoSuchElementException e) {
			e.getMessage();
		}

		return null;

	}

	/**
	 * To get all the elements with the locator stratergy
	 * 
	 * @param locatorStratergyToUse
	 * @return List<WebElementFacade>
	 */
	public List<WebElement> getElements(String locatorStratergyToUse) {
		try {
			return getDriver().findElements(getLocator(locatorStratergyToUse));
		} catch (ElementNotFoundException e) {
			e.getMessage();
		}

		return null;
	}

	/**
	 * To click on an element with with locator stratergy
	 * 
	 * @param locatorStratergyToUse
	 */
	public void clickOnElement(String locatorStratergyToUse) {

		int tryCount = 0;
		try {
			WebElementFacade clickOnElement = waitFor(getElementUsingLocator(locatorStratergyToUse));
			if (clickOnElement.isClickable() && tryCount < 3) {
				clickOnElement.click();
			} else {
				clickOnElement(locatorStratergyToUse);
				tryCount++;
			}
		} catch (ElementNotFoundException e) {
			e.getMessage();
		}

	}

	/**
	 * Enter text into an element
	 * 
	 * @param locatorStratergy
	 * @param text
	 */
	public void enterTextInto(String locatorStratergy, String text) {
		try {
			System.out.println("Entering the text: " + text);
			waitFor(getElementUsingLocator(locatorStratergy)).sendKeys(text);
		} catch (ElementNotFoundException e) {
			e.getMessage();
		}
	}

	/**
	 * To mouse over any element using the locator stratergy of the element on the
	 * UI
	 * 
	 * @param locatorStratergyToUse
	 */
	public void moveMouseTo(String locatorStratergyToUse) {
		try {
			WebElementFacade mouseOver = waitFor(getElementUsingLocator(locatorStratergyToUse));
			System.out.println("Moving the mouse over element: " + mouseOver.getText());
			withAction().moveToElement(mouseOver).perform();
		} catch (ElementNotFoundException e) {
			e.getMessage();
		}
	}

	private By getLocator(String locatorStratergyToUse) {

		By by = null;
		char[] locator = locatorStratergyToUse.toCharArray();
		int counter = 0;
		for (Character l : locator) {
			if (l.equals('=')) {
				break;
			} else {
				counter++;
			}
		}

		try {

			if (locatorStratergyToUse.substring(0, counter).toUpperCase().equals(String.valueOf(Locators.XPATH))) {
				by = By.xpath(String.valueOf(locator).substring(counter + 1));
				System.out.println("Identified the element by " + String.valueOf(Locators.XPATH));
				System.out.println(
						String.valueOf(Locators.XPATH) + " : " + String.valueOf(locator).substring(counter + 1));
			}

			else if (locatorStratergyToUse.substring(0, counter).toUpperCase()
					.equals(String.valueOf(Locators.CSSSELECTOR))) {
				by = By.cssSelector(String.valueOf(locator).substring(counter + 1));
				System.out.println("Identified the element by " + String.valueOf(Locators.CSSSELECTOR));
				System.out.println(
						String.valueOf(Locators.CSSSELECTOR) + " : " + String.valueOf(locator).substring(counter + 1));
			}

			else if (locatorStratergyToUse.substring(0, counter).toUpperCase().equals(String.valueOf(Locators.ID))) {
				by = By.id(String.valueOf(locator).substring(counter + 1));
				System.out.println("Identified the element by " + String.valueOf(Locators.ID));
				System.out
						.println(String.valueOf(Locators.ID) + " : " + String.valueOf(locator).substring(counter + 1));
			}

			else if (locatorStratergyToUse.substring(0, counter).toUpperCase()
					.equals(String.valueOf(Locators.LINKTEXT))) {
				by = By.linkText(String.valueOf(locator).substring(counter + 1));
				System.out.println("Identified the element by " + String.valueOf(Locators.LINKTEXT));
				System.out.println(
						String.valueOf(Locators.LINKTEXT) + " : " + String.valueOf(locator).substring(counter + 1));
			}

			else if (locatorStratergyToUse.substring(0, counter).toUpperCase()
					.equals(String.valueOf(Locators.PARTIALLINKTEXT))) {
				by = By.linkText(String.valueOf(locator).substring(counter + 1));
				System.out.println("Identified the element by " + String.valueOf(Locators.PARTIALLINKTEXT));
				System.out.println(String.valueOf(Locators.PARTIALLINKTEXT) + " : "
						+ String.valueOf(locator).substring(counter + 1));
			}

			else if (locatorStratergyToUse.substring(0, counter).toUpperCase().equals(String.valueOf(Locators.NAME))) {
				by = By.name(String.valueOf(locator).substring(counter + 1));
				System.out.println("Identified the element by " + String.valueOf(Locators.NAME));
				System.out.println(
						String.valueOf(Locators.NAME) + " : " + String.valueOf(locator).substring(counter + 1));
			}

			else if (locatorStratergyToUse.substring(0, counter).toUpperCase()
					.equals(String.valueOf(Locators.CLASSNAME))) {
				by = By.className(String.valueOf(locator).substring(counter + 1));
				System.out.println("Identified the element by " + String.valueOf(Locators.CLASSNAME));
				System.out.println(
						String.valueOf(Locators.CLASSNAME) + " : " + String.valueOf(locator).substring(counter + 1));
			}

			else if (locatorStratergyToUse.substring(0, counter).toUpperCase()
					.equals(String.valueOf(Locators.TAGNAME))) {
				by = By.tagName(String.valueOf(locator).substring(counter + 1));
				System.out.println("Identified the element by " + String.valueOf(Locators.TAGNAME));
				System.out.println(
						String.valueOf(Locators.TAGNAME) + " : " + String.valueOf(locator).substring(counter + 1));
			}

			return by;
		} catch (NullPointerException e) {
			e.getMessage();
		} catch (Throwable e) {
			e.getMessage();
		}

		return null;
	}

	/**
	 * To select the option in the dropdown menu using the visible text
	 * 
	 * @param locator
	 * @param text
	 */
	public void selectOptionFromDropDownUsingText(String locator, String text) {

		int tryCount = 0;
		WebElementFacade dropDown = waitFor(getElementUsingLocator(locator));
		if (dropDown.isEnabled() && tryCount <= 3) {
			dropDown.selectByVisibleText(text);
		} else {
			selectOptionFromDropDownUsingText(locator, text);
			tryCount++;
		}
	}

	/**
	 * TO select the option from the dropdown provided the value
	 * 
	 * @param locator
	 * @param Value
	 */
	public void selectOptionFromDropDownUsingValue(String locator, String Value) {
		waitFor(getElementUsingLocator(locator)).selectByValue(Value);
	}

	/**
	 * To select the option from the dropdown using the index value of the option
	 * 
	 * @param locator
	 * @param index
	 */
	public void selectOptionFromDropDownUsingIndex(String locator, int index) {
		waitFor(getElementUsingLocator(locator)).selectByIndex(index);
	}

	public String getText(String locator) {
		return getElementUsingLocator(locator).getText();
	}

	/***** BUSINESS RELATED COMMON FUNCTIONALITIES *****/

	/**
	 * In order to write the details to the file we can use the method and provide
	 * the file name as the parameter
	 * 
	 * @param fileName
	 */
	public void writeCarPriceInFile(String fileName, List<String> CarName, List<String> carPrice) {

		String info = fileName + "Car brand name and price \n";
		File file = new File(fileName);

		try {
			FileWriter fw = new FileWriter(file, true);

			// if you want to write the linesperator ("\n) as they are in the txt you should
			// use the following Code:

			fw.write(info);
			String lineSeparator = System.getProperty("line.separator");

			for (int i = 0; i < CarName.size(); i++) {
				fw.write("Car Name: " + CarName.get(i) + " Car Price: " + carPrice.get(i));
				fw.write(lineSeparator);
			}

			fw.flush();
			fw.close();

			FileUtils.copyFile(file, new File(".//CarDetails//" + fileName + ".txt"));
			FileUtils.deleteQuietly(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getHeading() {
		try {
			return getText("xpath=//h1");
		} catch (NoSuchElementException e) {
			e.getMessage();
		}
		return null;
	}

	public int carCountLabel() {

		try {
			String carCountLabelText = getText("xpath=//div[@id = 'headingContent']/following-sibling::h2");
			String[] carCountLabelSplit = carCountLabelText.split(" ");

			return Integer.parseInt(carCountLabelSplit[0]);
		} catch (NoSuchElementException e) {
			e.getMessage();
		}
		return 0;

	}
}
