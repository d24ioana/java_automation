package TestClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;


public class TestBase {
    public static WebDriver driver;

    @BeforeClass //Before Method inainte de fiecare test, BeforeClass - inainte de fiecare clasa de test ?!?
    public void SetUp(){
        var browser = "chrome";
        switch(browser){
            case "chrome":
                InitialiseChrome();
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

    @AfterMethod
    public void AfterMethod(){
        //driver.quit(); //close all tabs
        //driver.close(); //close the current tab
    }

    private void InitialiseChrome() {
        ChromeOptions options = new ChromeOptions();
        //block pop-ups:
        //options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
        //block ads with addblocker extension:
        //https://www.reddit.com/r/learnpython/comments/4zzn69/how_do_i_get_adblockplus_to_work_with_selenium/
        options.addArguments("--load-extension=C:\\Git\\java_automation\\AutomationFirstProject\\src\\test\\java\\Utils\\1.47.2_0", "--remote-allow-origins=*");
        //primul argument e pentru extensia de addBlock, al doilea pentru ceva problema la selenium pentru
        //chrome ver 111.0.5563.65
        driver = new ChromeDriver(options);
    }
}
