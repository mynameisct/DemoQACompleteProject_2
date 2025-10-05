package com.demoqa.base.page;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;

public class BasePage
{

    protected WebDriver driver;

    protected WebDriverWait wait;

    protected Logger logger = LogManager.getLogger(this.getClass());

    public BasePage(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected void click(By element)
    {
        logger.info("Clicking on element: " + element);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected void Type(WebElement element, String text)
    {
        logger.info("Typing text: '" + text + "' into element: " + element);
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }

    public String getText(WebElement element) {
        String text = wait.until(ExpectedConditions.visibilityOf(element)).getText();
        logger.info("Extracted text: '" + text + "' from element: " + element);
        return text;
    }

    protected void scrollToElement(By locator)
    {
        WebElement element = driver.findElement(locator);
        logger.info("Scrolling to element: " + locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}