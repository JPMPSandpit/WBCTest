package utilities;

import java.util.Properties;
import java.util.Random;

public class StringUtils
{
    static StringUtils stringUtils = new StringUtils();
    private static final String possibleAlphaValues = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvxyz";
    private static final String possibleNumericValues = "0123456789";
    private static final String possibleSpecialValues = "!@#$_";

    public static String ReturnRandomString(int size)
    {
        var builder = new StringBuilder(size);

        for (var i = 0; i < size; i++)
        {
            int randomIndex = (int)(possibleAlphaValues.length() * Math.random());
            char randomChar = possibleAlphaValues.charAt(randomIndex);
            builder.append(randomChar);
        }

        return builder.toString();
    }

    public static String ReturnRandomPassword()
    {
        var builder = new StringBuilder();

        int randomIndex = 0;
        char randomChar;

        for (var i = 0; i < 8; i++)
        {
            randomIndex = (int)(possibleAlphaValues.length() * Math.random());
            randomChar = possibleAlphaValues.charAt(randomIndex);
            builder.append(randomChar);
        }

        randomIndex = (int)(possibleNumericValues.length() * Math.random());
        randomChar = possibleNumericValues.charAt(randomIndex);
        builder.append(randomChar);

        randomIndex = (int)(possibleSpecialValues.length() * Math.random());
        randomChar = possibleSpecialValues.charAt(randomIndex);
        builder.append(randomChar);

        return builder.toString();
    }


}
