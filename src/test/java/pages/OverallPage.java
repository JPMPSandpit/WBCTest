package pages;

import enums.ColumnNames;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class OverallPage extends BasePage
{
    private By Link_Forward = By.xpath("//a[.='»'][@class='btn']");
    private By Link_Backward = By.xpath("//a[.='«'][@class='btn']");

    private int pageNumber = 1;
    private int initialPageNumber = 1;

    private By Label_Page_Number = By.xpath("//*[.='«']/../input");
    private By DataRows_VoteCount = By.xpath("//table//tr/td[5]");
    private By Label_Total_Pages = By.xpath("//*[.='«']/..");
    public OverallPage(WebDriver driver)
    {
        super (driver);
        WaitForSpinnerToDisappear();
        WaitForElement(By.xpath(GetLinkLocator(ColumnNames.VOTES.toString())));
    }

    public void SortByColumn(String columnName)
    {
        ClickElement(By.xpath(GetLinkLocator(columnName)));
    }

    public void FindCar(String carMakeAndModel) throws InterruptedException
    {
        while(!DoesElementExist(By.xpath(GetImageLocator(carMakeAndModel))))
        {
            if(DoesElementExist(Link_Forward))
            {
                ClickElement(Link_Forward);
            }
            else
            {
                ClickElement(Link_Backward);
            }
            Thread.sleep(1000);
        }
        SelectCar(carMakeAndModel);
    }

    public boolean VerifyVoteColumnOrder()
    {
        while(!IsLastPage())
        {
            List<WebElement> elements = FindElements(DataRows_VoteCount);

            for (int i=0; i<elements.size(); i++)
            {
                if(!(i == elements.size() - 1))
                {
                    int numberOne = Integer.parseInt(elements.get(i).getAttribute("innerText"));
                    int numberTwo = Integer.parseInt(elements.get(i+1).getAttribute("innerText"));

                    if(numberOne < numberTwo)
                    {
                        return false;
                    }
                }
            }
            ClickElement(Link_Forward);

            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException in){}
        }

        return true;
    }


    private void SavePageNumber()
    {
        this.pageNumber = Integer.parseInt(FindElement(Label_Page_Number).getAttribute("value"));
    }
    private void SelectCar(String carMakeAndModel)
    {
        ClickElement(By.xpath(GetImageLocator(carMakeAndModel)));
    }

    private String GetImageLocator(String carMakeAndModel)
    {
        return String.format("//img[@title='%s']", carMakeAndModel);
    }

    private String GetLinkLocator(String linkName)
    {
        return String.format("//a[.='%s']", linkName);
    }

    private boolean IsLastPage()
    {
        ScrollToElement(Label_Page_Number);
        int currentPageNumber = Integer.parseInt(FindElement(Label_Page_Number).getAttribute("value"));

        String totalPages = FindElement(Label_Total_Pages).getAttribute("innerText");

        totalPages = totalPages.substring(totalPages.indexOf("of")+2).trim();

        int lastPageNumber = Integer.parseInt(totalPages);

        return currentPageNumber == lastPageNumber;
    }

}
