package TestClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class TestBase {
    public WebDriver driver;

    @BeforeMethod //inainte de fiecare test, BeforeClass - inainte de fiecare clasa de test ?!?
    public void SetUp(){
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        //driver = new EdgeDriver()
        driver.get("https://demo.automationtesting.in/Index.html");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void AfterTest(){
        driver.quit(); //close all tabs
        //driver.close(); //close the current tab
    }

    //webdriver manager dependency - we dont need to download the .exe driver files for each browser
    //seleniumhq are feature-ul asta de la ver 4.6 in sus.
    //firefox driver nu merge fara gecko driver (testele pica la rulare), iar webdriver manager nu il are configurat
    //fara un repository in pom.xml, iar maven nu mai accepta repositories in pom
    // //System.setProperty("webdriver.gecko.driver", "./src/test/java/resources/geckodriver.exe");
    // nu e compatibila ver de selenium cu ver de java?!?




}
