package com.demoqa.tests.scripts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ElementsTextBoxTest extends BaseTest
{
    public static final Logger logger = LogManager.getLogger(ElementsTextBoxTest.class);

    private By elementsCard = By.xpath("(//div[@class='card-body'])[1]");

    private By textBox = By.xpath("(//ul[@class='menu-list']//span)[1]");

    private By fullName = By.id("userName");

    private By email = By.id("userEmail");

    private By address = By.id("currentAddress");

    private By perAddress = By.id("permanentAddress");

    private By submitBtn = By.id("submit");

    @Test
    public void verifytestElementsTextox()
    {
        logger.info("🔍 Running ElementsTextBoxTest: verifytestElementsTextox");

        homePage.scrollToElementJS(elementsCard);
        homePage.clickOnElement(elementsCard);

        homePage.scrollToElementJS(textBox);
        homePage.clickOnElement(textBox);

        homePage.scrollToElementJS(fullName);
        homePage.enterData(fullName,"Chaitanya Tribhuwan");

        homePage.scrollToElementJS(email);
        homePage.enterData(email,"ct@gmail.com");

        homePage.scrollToElementJS(address);
        homePage.enterData(address,"Punekar");

        homePage.scrollToElementJS(perAddress);
        homePage.enterData(perAddress,"Pune Only");

        homePage.scrollToElementJS(submitBtn);
        homePage.clickOnElement(submitBtn);

    }
}
