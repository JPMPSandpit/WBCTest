package pages;

import data.GlobalTestVariables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.StringUtils;

public class CarDetailsPage extends BasePage
{
    private final By TextField_Comment = By.id("comment");
    private final By Label_Current_Vote = By.xpath("//h4[contains(., 'Votes')]//strong");
    private final By Button_Vote = By.cssSelector(".btn.btn-success");

    private final By Label_Vote_Success = By.xpath("//*[.='Thank you for your vote!']");
    private final By Datarow_Latest_Comment = By.xpath("//table[@class='table']//tr[1]");

    public CarDetailsPage(WebDriver driver)
    {
        super (driver);
        WaitForSpinnerToDisappear();
        WaitForElement(TextField_Comment);
    }

    public void EnterCommentAndVote()
    {
        String textToInput = StringUtils.ReturnRandomString(15);
        SetElementValue(TextField_Comment, textToInput);

        GlobalTestVariables.setTextToSearchFor(textToInput);
        ClickElement(Button_Vote);

        String currentVoteCount = FindElement(Label_Current_Vote).getAttribute("innerText");
        int voteCountNow = Integer.parseInt(currentVoteCount) + 1;

        GlobalTestVariables.setVoteCount(String.valueOf(voteCountNow));
        WaitForElement(Label_Vote_Success);
    }

    public boolean IsVoteCountCorrect()
    {
        return FindElement(Label_Current_Vote).getAttribute("innerText").equals(GlobalTestVariables.getVoteCount());
    }

    public boolean IsCommentPresentAndCorrect()
    {
        return FindElement(Datarow_Latest_Comment).getAttribute("innerText").contains(GlobalTestVariables.getTextToSearchFor());
    }
}
