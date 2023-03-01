package TestClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class TestBase {
    public static WebDriver driver;

    @BeforeClass //Before Method inainte de fiecare test, BeforeClass - inainte de fiecare clasa de test ?!?
    public void SetUp(){
        var browser = "edge";
        switch(browser){
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                //break;
        }
        driver.manage().window().maximize();
        driver.get("https://demo.automationtesting.in/Index.html");
    }

    @AfterClass
    public void AfterMethod(){
        driver.quit(); //close all tabs
        //driver.close(); //close the current tab
    }





}
