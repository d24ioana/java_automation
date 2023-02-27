package PageObjects;

import Utils.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {
    Browser browser;
    private WebDriver driver;

    private WebElement emailField = driver.findElement(By.xpath("//input[@placeholder='E mail']"));
    private WebElement passwordField = driver.findElement(By.xpath("//input[@placeholder='Password']"));
    private WebElement enterButton = driver.findElement(By.id("enterbtn"));
    private WebElement errorMessage = driver.findElement(By.id("errormsg"));

    public SignInPage(WebDriver driver){
        this.driver = driver;
        browser = new Browser(this.driver);
    }

    public SignInPage LoginWithInvalidCredentials(){
        emailField.sendKeys("email@gmail.com");
        passwordField.sendKeys("password");
        enterButton.click();
        return new SignInPage(driver);
    }

    /*public SignInPage LoginWithValidCredentials(){
        emailField.sendKeys("");
        passwordField.sendKeys("");
        enterButton.click();
        return new
    }*/
}
