package PageObjects;

import TestClasses.TestBase;
import Utils.Browser;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AlertsPage {
    Browser browser;

    private WebDriver driver = TestBase.driver;

    @FindBy(xpath = "//div[@class='tabpane pullleft']")
    private WebElement typesOfAlertsTabPane;

    public AlertsPage(WebDriver driver){
        this.driver = driver;
        browser = new Browser(this.driver);
        PageFactory.initElements(this.driver, this);
    }

    public void TestAlerts() {
        //primul tip de alerta e selectat by default cand deschidem meniul SwitchTo
        HandleFirstTypeOfAlert();
        ChooseAlert("Alert with OK & Cancel");
        HandleSecondTypeOfAlert("ok");
        HandleSecondTypeOfAlert("cancel");
        ChooseAlert("Alert with Textbox");
        HandleThirdTypeOfAlert("ok","Ioana");
        HandleThirdTypeOfAlert("cancel","");
    }

    private void ChooseAlert(String myAlert){
        List<WebElement> alertTypesList = driver.findElements(By.xpath("//div[@class='tabpane pullleft']/ul/li"));
        for(WebElement alertType : alertTypesList){
            if(alertType.getText().equals(myAlert)){
                alertType.click();
            }
        }
    }

    private void HandleFirstTypeOfAlert() {
        WebElement alertWithOKButton = driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
        alertWithOKButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    private void HandleSecondTypeOfAlert(String whatToDoWithAlert){
        WebElement alertWithOKAndCancelButton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        WebElement messageShowedAfterHandlingAlert = driver.findElement(By.id("demo"));
        alertWithOKAndCancelButton.click();
        Alert alert = driver.switchTo().alert();
        if(whatToDoWithAlert.equalsIgnoreCase("ok")) {
            alert.accept();
            Assert.assertEquals(messageShowedAfterHandlingAlert.getText(),"You pressed Ok");
        }
        else if(whatToDoWithAlert.equalsIgnoreCase("cancel")) {
            alert.dismiss();
            Assert.assertEquals(messageShowedAfterHandlingAlert.getText(), "You Pressed Cancel");
        }
    }

    private void HandleThirdTypeOfAlert(String whatToDoWithAlert, String textToInsert){
        WebElement alertWithTextboxButton = driver.findElement(By.xpath("//button[@class='btn btn-info']"));
        WebElement messageShowedAfterHandlingAlert = driver.findElement(By.id("demo1"));
        alertWithTextboxButton.click();
        Alert alert = driver.switchTo().alert();
        if(whatToDoWithAlert.equalsIgnoreCase("ok")){
            alert.sendKeys(textToInsert);
            alert.accept();
            Assert.assertEquals(messageShowedAfterHandlingAlert.getText(),"Hello " + textToInsert + " How are you today");
        }
        else if(whatToDoWithAlert.equalsIgnoreCase("cancel")){
            alert.dismiss();
        }
    }

}
