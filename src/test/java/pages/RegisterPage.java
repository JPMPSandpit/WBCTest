package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import data.GlobalTestVariables;
import utilities.StringUtils;

public class RegisterPage extends BasePage
{
    private final By TextField_Login = By.id("username");
    private final By Textfield_FirstName = By.id("firstName");
    private final By Textfield_LastName = By.id("lastName");
    private final By Textfield_Password = By.id("password");
    private final By Textfield_Confirm_Password = By.id("confirmPassword");
    private final By Label_Alert_Success = By.cssSelector(".result.alert.alert-success");

    private final By Button_Register = By.xpath("//button[.='Register']");
    public RegisterPage(WebDriver driver)
    {
        super (driver);
        WaitForSpinnerToDisappear();
        WaitForElement(TextField_Login);
    }

    public void RegisterNewUser()
    {
        String username = "tester" + StringUtils.ReturnRandomString(5);
        String firstName = StringUtils.ReturnRandomString(5);
        String lastName = StringUtils.ReturnRandomString(5);
        String password = StringUtils.ReturnRandomPassword();

        GlobalTestVariables.setLoginName(username);
        GlobalTestVariables.setPassword(password);

        SetElementValue(TextField_Login, username);
        SetElementValue(Textfield_FirstName, firstName);
        SetElementValue(Textfield_LastName, lastName);
        SetElementValue(Textfield_Password, password);
        SetElementValue(Textfield_Confirm_Password, password);

        ClickElement(Button_Register);
        WaitForElement(Label_Alert_Success);
    }
}
