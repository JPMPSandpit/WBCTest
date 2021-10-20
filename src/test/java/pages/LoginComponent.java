package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.PropertiesManager;

public class LoginComponent extends BasePage
{

    private By TextField_Username = By.cssSelector("input[name='login']");
    private By TextField_Password = By.cssSelector("input[name='password']");
    private By Button_Login = By.linkText("Login");
    private By Button_Register = By.linkText("Register");

    private By Label_User_Greeting = By.cssSelector(".nav-link.disabled");
    private By Label_Invalid_Credentials = By.xpath("//*[.='Invalid username/password']");

    public LoginComponent(WebDriver driver)
    {
        super (driver);
        WaitForSpinnerToDisappear();
    }

    public void Login(String userName, String password)
    {
        SetElementValue(TextField_Username, userName);
        SetElementValue(TextField_Password, password);
        ClickElement(Button_Login);
    }

    public boolean IsLoginSuccess()
    {
        return DoesElementExist(Label_User_Greeting);
    }

    public boolean IsLoginFailed()
    {
        return DoesElementExist(Label_Invalid_Credentials);
    }
}
