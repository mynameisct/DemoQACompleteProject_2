package com.demoqa.tests.scripts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class BookStoreAppCardTest extends BaseTest
{
    private static final Logger logger = LogManager.getLogger(InteractionsCardTest.class);

    private By BookStoreAppCard = By.xpath("(//div[@class='card-body'])[6]");

    @Test
    public void verifyBookStoreAppCardMenus()
    {
        logger.info("🔍 Running BookStoreAppCardTest: verifyBookStoreAppCardMenus");

        homePage.scrollToElementJS(BookStoreAppCard);
        homePage.clickOnElement(BookStoreAppCard);

        List<WebElement> bookStoreAppCardMenu = driver.findElements(By.xpath("(//ul[@class='menu-list'])[6]/li"));
        logger.info("Total menu items found: {}", bookStoreAppCardMenu.size());

        Assert.assertEquals(bookStoreAppCardMenu.size(),4,"Expected exactly 4 menu item to be reveled");

        // Log and validate each item's text
        for (WebElement item : bookStoreAppCardMenu)
        {
            String text = item.getText().trim();
            logger.info("→ Menu item: '{}'", text);
            Assert.assertFalse(text.isEmpty(), "Forms Menu item text should not be empty");
        }
    }
}
