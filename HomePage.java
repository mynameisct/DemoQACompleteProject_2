package com.demoqa.page.objects;

import com.demoqa.base.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage
{

    private By elementsCard = By.xpath("(//div[@class='card mt-4 top-card'])[1]");

    public HomePage(WebDriver driver)
    {
        super(driver);
    }

    public void clickOnElementsCard()
    {
        scrollToElement(elementsCard);
        click(elementsCard);
    }
}
