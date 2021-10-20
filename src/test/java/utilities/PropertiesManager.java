package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class PropertiesManager
{
    private static String filePath = System.getProperty("user.dir") + "\\src\\main\\config\\Configuration.properties";


    private static String testUrl;
    private static String username;
    private static String password;
    private static String firstName;
    private static String lastName;

    public static void main(String[] args) throws IOException
    {
        FileInputStream fileInputStream = new FileInputStream(filePath);
        Properties properties = new Properties();
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
