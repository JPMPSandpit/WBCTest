package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginComponent;
import pages.UserProfilePage;
import utilities.GlobalTestVariables;
import utilities.PropertiesManager;

public class ProfileTests extends BaseTest
{
    LoginComponent loginComponent;
    UserProfilePage userProfilePage;

    @Test
    public void ChangeUserAddress()
    {
        loginComponent = new LoginComponent(driver);
        loginComponent.Login(PropertiesManager.getUsername(), PropertiesManager.getPassword());
        loginComponent.AccessProfile();

        userProfilePage = new UserProfilePage(driver);
        Assert.assertTrue(userProfilePage.VerifyCorrectFields(PropertiesManager.getUsername(), PropertiesManager.getFirstName(), PropertiesManager.getLastName()));
        userProfilePage.ModifyUserDetails();
        userProfilePage.GoHome();

        loginComponent.AccessProfile();

        userProfilePage = new UserProfilePage(driver);
        Assert.assertTrue(userProfilePage.DoesPageHaveCorrectAddress(GlobalTestVariables.getTextToSearchFor()));
    }
}
