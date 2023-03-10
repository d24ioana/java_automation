package PageObjects;

import TestClasses.TestBase;
import Utils.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    Browser browser;
    private WebDriver driver = TestBase.driver;

    //region WebElements
    @FindBy(xpath = "//input[@placeholder='E mail']")
    private WebElement emailField;
    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement passwordField;
    @FindBy(id = "enterbtn")
    private WebElement enterButton;
    @FindBy(id = "errormsg")
    private WebElement errorMessage;
    //endregion

    public SignInPage(WebDriver driver){
        this.driver = driver;
        browser = new Browser(this.driver);
        PageFactory.initElements(this.driver,this);
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
