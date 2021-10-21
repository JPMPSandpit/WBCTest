package data;

public class GlobalTestVariables
{
    private static String textToSearchFor = "";
    private static String loginName = "";
    private static String password = "";

    private static String voteCount ="";

    public static String getVoteCount()
    {
        return voteCount;
    }

    public static void setVoteCount(String voteCount)
    {
        GlobalTestVariables.voteCount = voteCount;
    }

    public static String getLoginName()
    {
        return loginName;
    }

    public static void setLoginName(String loginName)
    {
        GlobalTestVariables.loginName = loginName;
    }

    public static String getPassword()
    {
        return password;
    }

    public static void setPassword(String password)
    {
        GlobalTestVariables.password = password;
    }

    public static String getTextToSearchFor()
    {
        return textToSearchFor;
    }

    public static void setTextToSearchFor(String text)
    {
        GlobalTestVariables.textToSearchFor = text;
    }
}
