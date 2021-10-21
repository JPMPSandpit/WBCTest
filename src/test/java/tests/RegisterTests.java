package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginComponent;
import pages.RegisterPage;
import utilities.GlobalTestVariables;
import utilities.PropertiesManager;

public class RegisterTests extends BaseTest
{
    LoginComponent loginComponent;
    RegisterPage registerPage;

    @Test
    public void RegisterNewUser()
    {
        loginComponent = new LoginComponent(driver);
        loginComponent.RegisterUser();

        registerPage = new RegisterPage(driver);
        registerPage.RegisterNewUser();

        loginComponent = new LoginComponent(driver);
        loginComponent.Login(GlobalTestVariables.getLoginName(), GlobalTestVariables.getPassword());
        Assert.assertTrue(loginComponent.IsLoginSuccess());
    }
}
