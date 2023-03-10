package PageObjects;

import TestClasses.TestBase;
import Utils.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    Browser browser;
    private WebDriver driver = TestBase.driver;

    //region WebElements
    @FindBy(id = "btn1")
    private WebElement signInButton;
    @FindBy(id = "btn2")
    private WebElement skipSignInButton;
    //endregion

    public HomePage(WebDriver driver){
        this.driver = driver;
        browser = new Browser(this.driver);
        PageFactory.initElements(this.driver,this);
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
