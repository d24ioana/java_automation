package PageObjects;

import TestClasses.TestBase;
import Utils.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WindowsPage {
    Browser browser;

    private WebDriver driver = TestBase.driver;

    @FindBy(xpath = "")
    private WebElement element;

    public WindowsPage(WebDriver driver){
        this.driver = driver;
        browser = new Browser(this.driver);
        PageFactory.initElements(this.driver,this);
    }


}
