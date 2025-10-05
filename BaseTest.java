package com.demoqa.base.test;

import com.demoqa.page.objects.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest
{
    protected WebDriver driver;

    protected HomePage homePage;

    @BeforeMethod
    public void setUp()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void tearDown()
    {
        if(driver!=null)
            driver.quit();
    }


}
