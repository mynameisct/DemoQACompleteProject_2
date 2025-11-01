package com.demoqa.tests.scripts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WidgetsTest extends BaseTest
{

    private static final Logger logger = LogManager.getLogger(WidgetsTest.class);

    private By widgetsCard = By.xpath("(//div[@class='card-body'])[4]");

    @Test
    public void verifyWidgetsCardMenus()
    {
        logger.info("🔍 Running WidgetsTest: verifyWidgetsCardMenus");

        homePage.scrollToElementJS(widgetsCard);
        homePage.clickOnElement(widgetsCard);

         List<WebElement> widgetsMenu = driver.findElements(By.xpath("(//ul[@class='menu-list'])[4]/li"));
         logger.info("Total menu items found: {}", widgetsMenu.size());

        Assert.assertEquals(widgetsMenu.size(),9,"Expected exactly 9 menu item to be reveled");

        // Log and validate each item's text
        for (WebElement item : widgetsMenu)
        {
            String text = item.getText().trim();
            logger.info("→ Menu item: '{}'", text);
            Assert.assertFalse(text.isEmpty(), "Forms Menu item text should not be empty");
        }
    }
}
