package com.demoqa.tests.scripts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FormsCardTest extends BaseTest
{
    private static final Logger logger = LogManager.getLogger(FormsCardTest.class);

    private By formsCard = By.xpath("(//div[@class='card-body'])[2]");

    @Test
    public void verifyFormsCardRevealsOption()
    {

        logger.info("🔍 Running FormsCardTest: verifyFormsCardRevealsOption");

        homePage.scrollToElementJS(formsCard);
        homePage.clickOnElement(formsCard);

        List<WebElement> formsMenu = driver.findElements(By.xpath("//span[text()='Practice Form']"));
        logger.info("Total menu items found: {}", formsMenu.size());

        Assert.assertEquals(formsMenu.size(),1,"Expected exactly 1 menu item to be reveled");

        // Log and validate each item's text
        for (WebElement item : formsMenu)
        {
            String text = item.getText().trim();
            logger.info("→ Menu item: '{}'", text);
            Assert.assertFalse(text.isEmpty(), "Forms Menu item text should not be empty");
        }
    }

}
