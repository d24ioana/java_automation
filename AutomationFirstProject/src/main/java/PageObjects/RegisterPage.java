package PageObjects;

import Utils.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {
    Browser browser;
    private WebDriver driver;

    private WebElement firstNameField = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
    private WebElement lastNameField = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
    private WebElement addressTextArea = driver.findElement(By.xpath("//textarea[@ng-model='Adress']"));
    private WebElement emailField = driver.findElement(By.xpath("//input[@type='email']"));
    private WebElement phoneField = driver.findElement(By.xpath("//input[@type='tel']"));
    private WebElement maleRadio = driver.findElement(By.xpath("//input[@value='Male']"));
    private WebElement femaleRadio = driver.findElement(By.xpath("//input[@value='FeMale']"));
    private WebElement cricketCheckbox = driver.findElement(By.id("checkbox1"));
    private WebElement moviesCheckbox = driver.findElement(By.id("checkbox2"));
    private WebElement hockeyCheckbox = driver.findElement(By.id("checkbox3"));
    private WebElement languagesMultiselect = driver.findElement(By.id("msdd"));
    private WebElement languagesList = driver.findElement(By.xpath("//ul[contains(@style,'list')]"));
    private WebElement skillsDropdown = driver.findElement(By.xpath("//select[@ng-model='Skill']"));
    private WebElement countryContainer = driver.findElement(By.xpath("//span[@role='combobox']")); //combobox
    private WebElement birthYearSelect = driver.findElement(By.id("yearbox"));
    private WebElement birthMonthSelect = driver.findElement(By.id("monthbox"));
    private WebElement birthDaySelect = driver.findElement(By.id("daybox"));
    private WebElement passwordField = driver.findElement(By.id("firstpassword"));
    private WebElement confirmPasswordField = driver.findElement(By.id("secondpassword"));
    private WebElement uploadFile = driver.findElement(By.id("imagesrc"));
    //cum fac sintaxa pt getter si setter?

    public RegisterPage(WebDriver driver){
        this.driver = driver;
        browser = new Browser(this.driver);
    }
}
