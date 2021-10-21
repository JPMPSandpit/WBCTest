package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import data.PropertiesManager;

import java.io.IOException;

public class BaseTest
{
    protected WebDriver driver;
    //protected PropertiesManager propertiesManager;

    @BeforeMethod
    public void testSetup() throws IOException
    {
        PropertiesManager.initializeProperties();
        String webDriverLocation = System.getProperty("user.dir") + "\\src\\test\\webdrivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",webDriverLocation);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(PropertiesManager.getUrl());
    }

    @AfterMethod
    public void testCleanup()
    {
        driver.quit();
    }
}
