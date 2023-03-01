package TestClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestTest {
    @Test
    public void TestLogin() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.automationtesting.in/Index.html");
        driver.manage().window().maximize();
        WebElement signInButton = driver.findElement(By.id("btn1"));
        signInButton.click();
        WebElement emailField = driver.findElement(By.xpath("//input[@placeholder='E mail']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        WebElement enterButton = driver.findElement(By.id("enterbtn"));
        emailField.sendKeys("email");
        passwordField.sendKeys("pass");
        enterButton.click();
        WebElement errorMessage = driver.findElement(By.id("errormsg"));
        Assert.assertTrue(errorMessage.isDisplayed());
    }
}
