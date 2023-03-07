package Utils;

import TestClasses.TestBase;
import jdk.jfr.Timespan;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Browser {
    WebDriver driver = TestBase.driver;

    public Browser(WebDriver driver){
        this.driver = driver;
    }

    //Methods that can be used by all pages (HomePage, RegisterPage,...):
    public void WaitForElementToBeDisplayed(int seconds, WebElement webElement){
        new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(ExpectedConditions.visibilityOf(webElement));
    }

    public void HoverOnElement(WebElement element){
        Actions builder = new Actions(driver);
        builder.moveToElement(element).build().perform();
    }

}
