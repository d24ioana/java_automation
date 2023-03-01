package PageObjects;

import TestClasses.TestBase;
import Utils.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    Browser browser;
    private WebDriver driver = TestBase.driver;

    private WebElement signInButton = driver.findElement(By.id("btn1"));
    private WebElement skipSignInButton = driver.findElement(By.id("btn2"));

    public HomePage(WebDriver driver){
        this.driver = driver;
        browser = new Browser(this.driver);
    }

    public SignInPage SignIn(){
        signInButton.click();
        return new SignInPage(driver);
    }

    public RegisterPage SkipSignIn(){
        skipSignInButton.click();
        return new RegisterPage(driver);
    }
}
