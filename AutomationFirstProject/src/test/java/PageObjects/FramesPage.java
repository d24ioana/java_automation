package PageObjects;

import TestClasses.TestBase;
import Utils.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FramesPage {
    Browser browser;
    private WebDriver driver = TestBase.driver;

    //region WebElements
    @FindBy(xpath = "//ul[@class='nav nav-tabs ']/li")
    List<WebElement> framesTypesList;
    @FindBy(id = "singleframe")
    WebElement singleFrame;
    @FindBy(xpath = "//iframe[@src='MultipleFrames.html']")
    WebElement parentIframe;
    @FindBy(xpath = "//iframe[@style='float: left;height: 250px;width: 400px']")
    WebElement nestedIframe;
    @FindBy(xpath = "//input[@type='text']")
    WebElement textBoxInIframes;
    //endregion

    public FramesPage(WebDriver driver){
        this.driver = driver;
        browser = new Browser(this.driver);
        PageFactory.initElements(this.driver,this);
    }

    public void TestFrames(){
        ChooseIframeType("Single Iframe");
        HandleSingleIframe();
        ChooseIframeType("Iframe with in an Iframe");
        HandleIframeWithAnIframe();
    }

    private void ChooseIframeType(String myiFrame){
        for(WebElement iframeType : framesTypesList){
            if(iframeType.getText().equalsIgnoreCase(myiFrame)){
                iframeType.click();
            }
        }
    }

    private void HandleSingleIframe(){
        driver.switchTo().frame(singleFrame);
        textBoxInIframes.sendKeys("Hello");
        driver.switchTo().defaultContent();
    }

    private void HandleIframeWithAnIframe(){
        driver.switchTo().frame(parentIframe);
        driver.switchTo().frame(nestedIframe);
        textBoxInIframes.sendKeys("Goodbye");
        driver.switchTo().defaultContent();
    }

}
