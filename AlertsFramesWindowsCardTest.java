package com.demoqa.tests.scripts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AlertsFramesWindowsCardTest extends BaseTest
{
    private static final Logger logger = LogManager.getLogger(FormsCardTest.class);

    private By alertsFrmaesWindowsCard = By.xpath("//h5[text()='Alerts, Frame & Windows']");

    @Test
    public void verifyAlertsFramesWindowsCardRevealsOption()
    {

        logger.info("🔍 Running AlertsFramesWindowsCardTest: verifyAlertsFramesWindowsCardRevealsOption");

        homePage.scrollToElementJS(alertsFrmaesWindowsCard);
        homePage.clickOnElement(alertsFrmaesWindowsCard);

        List<WebElement> alertsFramesWindowsMenu = driver.findElements(By.xpath("(//ul[@class='menu-list'])[3]/li"));
        logger.info("Total menu items found: {}", alertsFramesWindowsMenu.size());

        Assert.assertEquals(alertsFramesWindowsMenu.size(),5,"Expected exactly 1 menu item to be reveled");

        // Log and validate each item's text
        for (WebElement item : alertsFramesWindowsMenu)
        {
            String text = item.getText().trim();
            logger.info("→ Menu item: '{}'", text);
            Assert.assertFalse(text.isEmpty(), "Forms Menu item text should not be empty");
        }
    }

}
