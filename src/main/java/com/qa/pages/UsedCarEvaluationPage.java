package com.qa.pages;

import com.qa.base.TestBase;

public class UsedCarEvaluationPage extends TestBase {

	/**
	 * Check car eval fields
	 */
	private String mfgYearDropDown = "id=cmbYear";
	private String mfgMonthDropDown = "id=cmbMonth";
	private String makeDropDown = "id=cmbMake";
	private String modelDropDown = "id=cmbModel";
	private String versionDropDown = "id=cmbVersion";
	private String cityDropDown = "id=cmbValuationCity";
	private String ownerDropDown = "id=ddlOwners";
	private String kilomtrTxtBox = "id=txtKms";

	/**
	 * Buttons available on the page
	 */

	/**
	 * To check the evaluated prices
	 */

	private String fairPrice = "xpath=//div[text() = 'Fair Condition']/following-sibling::div[@class = 'price-pos']";
	private String goodPrice = "xpath=//div[text() = 'Good Condition']/following-sibling::div[@class = 'price-pos']";

	private String checkEvalBtn = "id=valuation-result-btn";

	public void enterTheCarDetails(String mfgYr, String mfgMnth, String make, String model, String version, String city,
			String owner, String kilo) {

		selectOptionFromDropDownUsingText(mfgYearDropDown, mfgYr);
		selectOptionFromDropDownUsingText(mfgMonthDropDown, mfgMnth);
		selectOptionFromDropDownUsingText(makeDropDown, make);
		selectOptionFromDropDownUsingText(modelDropDown, model);
		selectOptionFromDropDownUsingText(versionDropDown, version);
		selectOptionFromDropDownUsingText(cityDropDown, city);
		selectOptionFromDropDownUsingText(ownerDropDown, owner);

		enterTextInto(kilomtrTxtBox, kilo);

	}

	public void clickOnCheckValBtn() {

		clickOnElement(checkEvalBtn);
	}

	
	/**
	 * To fetch the price for the fair condition of the car
	 * @return String --> the string value of the car in fair condition
	 */
	public String getFairConditionPrice() {
		return getElementUsingLocator(fairPrice).getText();
	}

	/**
	 * To fetch the price for the fair condition of the car
	 * @return String --> the string value of the car in good condition
	 */
	public String getGoodConditionPrice() {
		return getElementUsingLocator(goodPrice).getText();
	}

}
