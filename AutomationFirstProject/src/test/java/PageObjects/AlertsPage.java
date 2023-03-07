package PageObjects;

import TestClasses.TestBase;
import Utils.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AlertsPage {
    Browser browser;

    private WebDriver driver = TestBase.driver;

    //@FindBy(xpath = "//button[@class='btn btn-danger']")
    //private WebElement alertWithOKButton;
    @FindBy(xpath = "//div[@class='tabpane pullleft']")
    private WebElement typesOfAlertsTabPane;

    public AlertsPage(WebDriver driver){
        this.driver = driver;
        browser = new Browser(this.driver);
        PageFactory.initElements(this.driver, this);
    }

    public void TestAlerts(){
        //primul tip de alerta e selectat by default cand deschidem meniul SwitchTo
        //cod testat alerta: click buton, apare alerta, o ichid
        ChooseAlert("Alert with OK & Cancel");
        //cod
        ChooseAlert("Alert with Textbox");
        //cod
    }

    private void ChooseAlert(String myAlert){
        List<WebElement> alertTypesList = driver.findElements(By.xpath("//div[@class='tabpane pullleft']/ul/li"));
        for(WebElement alertType : alertTypesList){
            if(alertType.getText().equals(myAlert)){
                alertType.click();
            }
        }
    }

}
