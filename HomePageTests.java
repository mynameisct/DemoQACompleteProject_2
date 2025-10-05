package com.demoqa.tests.scripts;

import com.demoqa.base.test.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTest
{
    By textToVerify = By.xpath("//*[contains(text(),'Please select an item from left')]");

    @Test
    public void clickOnElementsCard()
    {
        homePage.clickOnElementsCard();
        WebElement element = driver.findElement(textToVerify);
        String actualText = homePage.getText(element); // ✅ This will trigger your logger
        Assert.assertTrue(actualText.contains("start practice"));
    }
}
