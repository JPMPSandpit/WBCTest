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

import javax.annotation.Nullable;
import java.util.Objects;

public class BasePage
{
    //src="/img/spin.gif"
    protected WebDriver driver;
    protected WebDriverWait wait;

    private static int TimeoutInSeconds = 15;

    protected By Spinner_Main = By.cssSelector("[src='/img/spin.gif']");

    public BasePage(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, TimeoutInSeconds);
    }

    public WebElement FindElement(By locator)
    {
        return wait.until(driver -> driver.findElement(locator));
    }

    public void SetElementValue(By locator, String value)
    {
        WaitForElement(locator);
        WebElement element = FindElement(locator);
        element.clear();
        element.sendKeys(value);
    }

    public void ClickElement(By locator)
    {
        WaitForElementToBeClickable(locator);
        FindElement(locator).click();
    }

    public void WaitForElement(By locator)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void WaitForElementToBeClickable(By locator)
    {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void WaitForElementToDisappear(By locator)
    {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public boolean DoesElementExist(By locator)
    {
        return driver.findElements(locator).size() != 0;
    }

    protected void WaitForSpinnerToDisappear()
    {
        WaitForElementToDisappear(Spinner_Main);
    }
}
