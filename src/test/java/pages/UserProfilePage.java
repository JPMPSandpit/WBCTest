package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import data.GlobalTestVariables;
import utilities.StringUtils;

public class UserProfilePage extends BasePage
{
    private final By TextField_Login = By.id("username");
    private final By TextField_FirstName = By.id("firstName");
    private final By TextField_LastName = By.id("lastName");
    private final By TextField_Address = By.id("address");
    private final By Button_Save = By.xpath("//button[.='Save']");
    private final By Label_Alert_Success = By.cssSelector(".result.alert.alert-success");

    public UserProfilePage(WebDriver driver)
    {
        super (driver);
        WaitForSpinnerToDisappear();
        WaitForElement((TextField_FirstName));
    }

    public boolean VerifyCorrectFields(String login, String firstName, String lastName)
    {
        boolean isLoginCorrect = FindElement(TextField_Login).getAttribute("value").contains(login) ? true : false;
        boolean isFirstNameCorrect = FindElement(TextField_FirstName).getAttribute("value").contains(firstName) ? true : false;
        boolean isLastNameCorrect = FindElement(TextField_LastName).getAttribute("value").contains(lastName) ? true : false;

        return (isLoginCorrect && isFirstNameCorrect && isLastNameCorrect) ? true : false;
    }

    public void ModifyUserDetails()
    {
        String textToInput = StringUtils.ReturnRandomString(10);
        SetElementValue(TextField_Address, textToInput);
        GlobalTestVariables.setTextToSearchFor(textToInput);
        ClickElement(Button_Save);
        WaitForElement(Label_Alert_Success);
    }

    public boolean DoesPageHaveCorrectAddress(String address)
    {
        return FindElement(TextField_Address).getAttribute("value").contains(address) ? true : false;
    }
}
