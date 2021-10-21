package tests;

import data.GlobalTestVariables;
import enums.CarMakes;
import enums.CarModels;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

public class CarDetailsTests extends BaseTest
{
    LoginComponent loginComponent;
    RegisterPage registerPage;
    CarRatingsMainPage carRatingsMainPage;
    OverallPage overallPage;
    CarDetailsPage lamborghiniDiabloPage;

    @BeforeMethod
    public void CreateNewUserAndLogIn()
    {
        loginComponent = new LoginComponent(driver);
        loginComponent.RegisterUser();

        registerPage = new RegisterPage(driver);
        registerPage.RegisterNewUser();

        loginComponent = new LoginComponent(driver);
        loginComponent.Login(GlobalTestVariables.getLoginName(), GlobalTestVariables.getPassword());
        loginComponent.GoToHomepage();
    }

    @Test
    public void CommentOnDiablo() throws InterruptedException
    {
        carRatingsMainPage = new CarRatingsMainPage(driver);
        carRatingsMainPage.NavigateToAllCars();

        overallPage = new OverallPage(driver);
        overallPage.FindCar(CarModels.LAMBORGHINI_DIABLO.toString());

        lamborghiniDiabloPage = new CarDetailsPage(driver);
        lamborghiniDiabloPage.EnterCommentAndVote();

        Assert.assertTrue(lamborghiniDiabloPage.IsVoteCountCorrect());
        Assert.assertTrue(lamborghiniDiabloPage.IsCommentPresentAndCorrect());

    }

    @Test
    public void VerifyVoteOrder() throws InterruptedException
    {
        carRatingsMainPage = new CarRatingsMainPage(driver);
        carRatingsMainPage.NavigateToAllCars();

        overallPage = new OverallPage(driver);
        Assert.assertTrue(overallPage.VerifyVoteColumnOrder());
    }

}
