package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginComponent;
import utilities.PropertiesManager;

public class LoginTests extends BaseTest
{
    LoginComponent loginComponent;

    @Test
    public void LoginTestValid()
    {
        loginComponent = new LoginComponent(driver);
        loginComponent.Login(PropertiesManager.getUsername(), PropertiesManager.getPassword());
        Assert.assertTrue(loginComponent.IsLoginSuccess());
    }

    @Test
    public void LoginTestInvalid()
    {
        loginComponent = new LoginComponent(driver);
        loginComponent.Login(PropertiesManager.getUsername(), PropertiesManager.getPassword() + "222");
        Assert.assertTrue(loginComponent.IsLoginFailed());
    }

}
