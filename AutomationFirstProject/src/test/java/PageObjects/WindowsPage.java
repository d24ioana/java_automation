package PageObjects;

import TestClasses.TestBase;
import Utils.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class WindowsPage {
    Browser browser;

    private WebDriver driver = TestBase.driver;

    @FindBy(xpath = "//div[@class='tabpane pullleft']")
    private WebElement typesOfSeleniumWindows;

    public WindowsPage(WebDriver driver){
        this.driver = driver;
        browser = new Browser(this.driver);
        PageFactory.initElements(this.driver,this);
    }

    public void TestSeleniumWindows(){
        //first type e selectat by default cand deschidem meniul
        HandleFirstTypeOfSeleniumWindows();
        ChooseWindowType("open new seperate windows");
        HandleSecondTypeOfSeleniumWindows();
        ChooseWindowType("open seperate multiple windows");
        HandleThirdTypeOfSeleniumWindows();
    }

    private void ChooseWindowType(String myWindowType){
        List<WebElement> seleniumWindowsTypesList = driver.findElements(By.xpath("//div[@class='tabpane pullleft']/ul/li"));
        for(WebElement seleniumWindowsType : seleniumWindowsTypesList){
            if(seleniumWindowsType.getText().equalsIgnoreCase(myWindowType)){
                seleniumWindowsType.click();
            }
        }
    }

    private void HandleFirstTypeOfSeleniumWindows(){
        WebElement tabbedWindowsButton = driver.findElement(By.xpath("//a[@target='_blank']/button"));
        tabbedWindowsButton.click();
        WaitForNewWindowsToBeOpenedAndCheckTotalNumberOfWindows(2);
        GetWindowsHandlesAndCloseTheChildWindows();
    }

    private void HandleSecondTypeOfSeleniumWindows(){
        WebElement newSeparateWindowsButton = driver.findElement(By.xpath("//button[@onclick='newwindow()']"));
        newSeparateWindowsButton.click();
        WaitForNewWindowsToBeOpenedAndCheckTotalNumberOfWindows(2);
        GetWindowsHandlesAndCloseTheChildWindows();
    }

    private void HandleThirdTypeOfSeleniumWindows(){
        WebElement separateMultipleWindowsButton = driver.findElement(By.xpath("//button[@onclick='multiwindow()']"));
        separateMultipleWindowsButton.click();
        WaitForNewWindowsToBeOpenedAndCheckTotalNumberOfWindows(3);
        GetWindowsHandlesAndCloseTheChildWindows();
    }

    private void WaitForNewWindowsToBeOpenedAndCheckTotalNumberOfWindows(int noOfWindows) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.numberOfWindowsToBe(noOfWindows));
    }

    private void GetWindowsHandlesAndCloseTheChildWindows(){
        String mainWindow = driver.getWindowHandle(); //parent window
        Set<String> allOpenedWindows = driver.getWindowHandles();
        for(String currentWindow : allOpenedWindows){
            if(!mainWindow.equalsIgnoreCase(currentWindow)){
                driver.switchTo().window(currentWindow);
                //childWindow.manage().window().maximize();
                driver.close();
            }
        }
        driver.switchTo().window(mainWindow);
    }

}
