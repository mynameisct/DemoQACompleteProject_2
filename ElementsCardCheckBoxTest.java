package com.demoqa.tests.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class ElementsCardCheckBoxTest extends BaseTest
{

    private By elemenstCard = By.xpath("(//div[@class='card-body'])[1]");

    private By checkBox = By.xpath("(//ul[@class='menu-list'])[1]//li[@id='item-1']");

    private By expandCheckbox = By.xpath("(//button[@title='Toggle'])[1]");

    private By expandAll = By.xpath("//button[@title='Expand all']");

    private By finalCheckAll = By.xpath("(//span[@class='rct-title'])[1]");

    @Test
    public void verifyCheckbox()
    {
        homePage.scrollToElementJS(elemenstCard);
        homePage.clickOnElement(elemenstCard) ;

        homePage.scrollToElementJS(checkBox);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(checkBox));
        homePage.clickOnElement(checkBox);

        homePage.scrollToElementJS(expandCheckbox);
        wait.until(ExpectedConditions.elementToBeClickable(expandCheckbox));
        homePage.clickOnElement(expandCheckbox);

        homePage.scrollToElementJS(expandAll);
        wait.until(ExpectedConditions.elementToBeClickable(expandAll));
        homePage.clickOnElement(expandAll);

        homePage.scrollToElementJS(finalCheckAll);
        wait.until(ExpectedConditions.elementToBeClickable(finalCheckAll));
        homePage.clickOnElement(finalCheckAll);
    }
}
