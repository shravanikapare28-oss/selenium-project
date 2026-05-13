package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestCases 
{
    public static void main(String[] args) throws InterruptedException 
    {

        String[][] testData = {
            {"standard_user", "secret_sauce"},   // valid
            {"wrong_user", "secret_sauce"},      // invalid username
            {"standard_user", "wrong_pass"},     // invalid password
            {"wrong_user", "wrong_pass"},        // both wrong
            {"", ""},                            // empty both
            {"standard_user", ""},               // empty password
            {"", "secret_sauce"}                 // empty username
        };

        for (int i = 0; i < testData.length; i++) 
        {
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.saucedemo.com/");
            driver.manage().window().maximize();
            Thread.sleep(2000);
            driver.findElement(By.id("user-name")).sendKeys(testData[i][0]);
            driver.findElement(By.id("password")).sendKeys(testData[i][1]);
            driver.findElement(By.id("login-button")).click();
            Thread.sleep(2000);
            if(driver.getCurrentUrl().contains("inventory")) 
            {
                System.out.println("Test Case " + (i+1) + ": Login Successful");
            } 
            else 
            {
                String errorMsg = driver.findElement(By.cssSelector("h3[data-test='error']")).getText();
                System.out.println("Test Case " + (i+1) + ": Login Failed");
                System.out.println("Error: " + errorMsg);
            }
            driver.quit();
        }
    }
}