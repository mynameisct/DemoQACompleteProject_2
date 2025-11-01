package com.demoqa.tests.scripts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class InteractionsCardTest extends BaseTest
{
    private static final Logger logger = LogManager.getLogger(InteractionsCardTest.class);

    private By InteractionsCard = By.xpath("(//div[@class='card-body'])[5]");

    @Test
    public void verifyInteractionsCardMenus()
    {
        logger.info("🔍 Running InteractionsCardTest: verifyInteractionsCardMenus");

        homePage.scrollToElementJS(InteractionsCard);
        homePage.clickOnElement(InteractionsCard);

        List<WebElement> InteractionsMenu = driver.findElements(By.xpath("(//ul[@class='menu-list'])[5]/li"));
        logger.info("Total menu items found: {}", InteractionsMenu.size());

        Assert.assertEquals(InteractionsMenu.size(),5,"Expected exactly 5 menu item to be reveled");

        // Log and validate each item's text
        for (WebElement item : InteractionsMenu)
        {
            String text = item.getText().trim();
            logger.info("→ Menu item: '{}'", text);
            Assert.assertFalse(text.isEmpty(), "Forms Menu item text should not be empty");
        }
    }

}
