package com.demoqa.tests.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ElementCardRadioButtonTest extends BaseTest
{
    private By elementsCard = By.xpath("(//div[@class='card-body'])[1]");

    private By radioCheckvbox = By.xpath("(//ul[@class='menu-list'])[1]//li[@id='item-2']");

    private By maleRadioBtn = By.id("yesRadio");

    private By impressiveRadioBtn = By.id("impressiveRadio");

    private By textToVerify = By.xpath("//span[text()='Impressive']");

    @Test
    public void verifyElementsCardRadioButton()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        wait.until(ExpectedConditions.elementToBeClickable(elementsCard));
        homePage.scrollToElementJS(elementsCard);
        homePage.clickOnElement(elementsCard);

        wait.until(ExpectedConditions.elementToBeClickable(radioCheckvbox));
        homePage.scrollToElementJS(radioCheckvbox);
        homePage.clickOnElement(radioCheckvbox);

        wait.until(ExpectedConditions.presenceOfElementLocated(maleRadioBtn));
        homePage.scrollToElementJS(maleRadioBtn);
        WebElement maleRadio = driver.findElement(maleRadioBtn);
        if (maleRadio.isEnabled()) {
            try {
                maleRadio.click();
            } catch (Exception e) {
                js.executeScript("arguments[0].click();", maleRadio);
            }
        }

        wait.until(ExpectedConditions.presenceOfElementLocated(impressiveRadioBtn));
        homePage.scrollToElementJS(impressiveRadioBtn);
        WebElement impressiveRadio = driver.findElement(impressiveRadioBtn);
        if (impressiveRadio.isEnabled()) {
            try {
                impressiveRadio.click();
            } catch (Exception e) {
                js.executeScript("arguments[0].click();", impressiveRadio);
            }
        }

        WebElement resultText = wait.until(ExpectedConditions.visibilityOfElementLocated(textToVerify));
        String actualText = resultText.getText();
        Assert.assertTrue(actualText.contains("Impressive"));
    }
}
