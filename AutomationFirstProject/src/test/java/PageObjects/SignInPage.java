package PageObjects;

import TestClasses.TestBase;
import Utils.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {
    Browser browser;
    private WebDriver driver = TestBase.driver;

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

    public boolean LoginErrorDisplayed() {
        return errorMessage.isDisplayed();
    }

    public String GetLoginErrorMessage() {
        return errorMessage.getText();
    }

    /*public SignInPage LoginWithValidCredentials(){
        emailField.sendKeys(""); //do i need to selectelementbyvalue first?
        passwordField.sendKeys("");
        enterButton.click();
        return new
    }*/
}