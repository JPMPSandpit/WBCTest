package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CarRatingsMainPage extends BasePage
{
    private final By Link_Overall_Rating = By.xpath("//a[contains(@href, 'overall')]");

    public CarRatingsMainPage(WebDriver driver)
    {
        super (driver);
        WaitForSpinnerToDisappear();
        WaitForElement(Link_Overall_Rating);
    }

    public void NavigateToAllCars()
    {
        ClickElement(Link_Overall_Rating);
    }

}
