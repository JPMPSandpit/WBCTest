package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

    private By Spinner_Main = By.cssSelector("[src='/img/spin.gif']");
    private By Link_Buggy_Rating_Home = By.xpath("//a[.='Buggy Rating']");

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
        ScrollToElement(locator);
        element.clear();
        element.sendKeys(value);
    }

    public void GoHome()
    {
        ClickElement(Link_Buggy_Rating_Home);
    }

    public void ClickElement(By locator)
    {
        WaitForElementToBeClickable(locator);
        ScrollToElement(locator);
        FindElement(locator).click();
    }

    protected void WaitForElement(By locator)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void WaitForElementToBeClickable(By locator)
    {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void WaitForElementToDisappear(By locator)
    {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected boolean DoesElementExist(By locator)
    {
        if (driver.findElements(locator).size() > 0)
        {
            return true;
        }

        else
        {
            return false;
        }
    }

    protected void WaitForSpinnerToDisappear()
    {
        WaitForElementToDisappear(Spinner_Main);
    }

    protected void ScrollToElement(By locator)
    {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
