package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddRemoveCartTest 
{
    public static void main(String[] args) throws InterruptedException 
    {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        Thread.sleep(3000);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        Thread.sleep(5000);

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        System.out.println("Item added");

        Thread.sleep(5000);

        driver.findElement(By.className("shopping_cart_link")).click();

        Thread.sleep(5000);  

        driver.findElement(By.className("shopping_cart_link")).click();
        System.out.println("Item removed");

        Thread.sleep(5000);
        driver.quit();
    }
}