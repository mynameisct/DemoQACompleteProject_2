package com.demoqa.tests.scripts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

public class ElementsCardTest extends BaseTest
{

    private static final Logger logger = LogManager.getLogger(ElementsCardTest.class);

    private By elementsCard = By.xpath("(//div[@class='card-body'])[1]");

    @Test
    public void verifyElementsCardRevealsMenuList()
    {
        homePage.scrollToElementJS(elementsCard);
        homePage.clickOnElement(elementsCard);

        List<WebElement> menuItems = driver.findElements(By.xpath("(//ul[@class='menu-list'])[1]/li"));
        logger.info("Total menu items found: {}", menuItems.size());

        // Assert total count is exactly 9
        Assert.assertEquals(menuItems.size(), 9, "Expected exactly 9 menu items to be revealed");

        // Log and validate each item's text
        for (WebElement item : menuItems)
        {
            String text = item.getText().trim();
            logger.info("→ Menu item: '{}'", text);
            Assert.assertFalse(text.isEmpty(), "Menu item text should not be empty");
        }
    }
}
