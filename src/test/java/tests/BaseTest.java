package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import utilities.PropertiesManager;

import java.io.IOException;

public class BaseTest
{
    protected WebDriver driver;
    //protected PropertiesManager propertiesManager;

    @BeforeSuite
    public void testSetup() throws IOException
    {
        PropertiesManager.initializeProperties();
        String webDriverLocation = System.getProperty("user.dir") + "\\src\\test\\webdrivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",webDriverLocation);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(PropertiesManager.getUrl());
    }

    @AfterSuite
    public void testCleanup()
    {
        driver.quit();
    }
}
