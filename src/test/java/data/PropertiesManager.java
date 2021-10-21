package data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class PropertiesManager
{
    private static String filePath = System.getProperty("user.dir") + "\\src\\test\\config\\Configuration.properties";
    static Properties properties = new Properties();

    private static String testUrl;
    private static String username;
    private static String password;
    private static String firstName;
    private static String lastName;

    public static void initializeProperties() throws IOException
    {
        FileInputStream fileInputStream = new FileInputStream(filePath);
        properties.load(fileInputStream);

        testUrl = properties.getProperty("testUrl");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
        firstName = properties.getProperty("firstName");
        lastName = properties.getProperty("lastName");
    }

    public static String getUrl()
    {
        return testUrl;
    }
    public static String getUsername()
    {
        return username;
    }
    public static String getPassword()
    {
        return password;
    }
    public static String getFirstName()
    {
        return firstName;
    }
    public static String getLastName()
    {
        return lastName;
    }

}
