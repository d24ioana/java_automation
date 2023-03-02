package PageObjects;

import TestClasses.TestBase;
import Utils.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class RegisterPage {
    Browser browser;
    private WebDriver driver = TestBase.driver;

    //region WebElements
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
    private WebElement languagesAutocompleteMultiselect = driver.findElement(By.id("msdd"));
    private WebElement skillsDropdown = driver.findElement(By.xpath("//select[@ng-model='Skill']"));
    Select selectSkills = new Select(skillsDropdown);
    private WebElement countryContainer = driver.findElement(By.xpath("//span[@role='combobox']")); //combobox
    private WebElement birthYearDropdown = driver.findElement(By.id("yearbox"));
    Select selectYear = new Select(birthYearDropdown);
    private WebElement birthMonthDropdown = driver.findElement(By.xpath("//select[@ng-model='monthbox']"));
    Select selectMonth = new Select(birthMonthDropdown);
    private WebElement birthDayDropdown = driver.findElement(By.id("daybox"));
    Select selectDay = new Select(birthDayDropdown);
    private WebElement passwordField = driver.findElement(By.id("firstpassword"));
    private WebElement confirmPasswordField = driver.findElement(By.id("secondpassword"));

    private WebElement uploadFile = driver.findElement(By.id("imagesrc"));
    //cum fac sintaxa pt getter si setter?
    //endregion

    public RegisterPage(WebDriver driver){
        this.driver = driver;
        browser = new Browser(this.driver);
    }

    public RegisterPage InterractWithAllElements() {
        //Interact with text fields, text areas, radio buttons and checkboxes:
        firstNameField.sendKeys("Ioana");
        lastNameField.sendKeys("Dumi");
        addressTextArea.sendKeys("Street Ohio, number 7, city Ohio, country Oklahoma");
        emailField.sendKeys("email@gmail.com");
        phoneField.sendKeys("0740000000");
        femaleRadio.click();
        moviesCheckbox.click();
        cricketCheckbox.click();

        //Interact with a list of web elements:
        languagesAutocompleteMultiselect.click();
        ChooseALanguage("Danish");
        ChooseALanguage("Bulgarian");
        ChooseALanguage("Malay");
        ChooseALanguage("Urdu");
        phoneField.click(); //to exit language select list

        //Interact with a dropdown menu (with a Select element):
        selectSkills.selectByValue("PHP");

        //Interact with auto suggestion dropdown:
        browser.WaitForElementToBeDisplayed(5,countryContainer);
        countryContainer.click();
        SelectCountryMethod("South Africa");

        //Mixed from above:
        selectYear.selectByValue("1999");
        selectMonth.selectByIndex(1);
        selectDay.selectByIndex(24);
        passwordField.sendKeys("abcd");
        confirmPasswordField.sendKeys("abcd");

        //interact with upload file/choose file:
        uploadFile.sendKeys("C:/Git/java_automation/AutomationFirstProject/src/test/java/Utils/FileUsedToTestChooseFileFunctionality");
        return this;
    }

    private void ChooseALanguage(String myLanguage) {
        WebElement languagesUl = driver.findElement(By.xpath("//ul[contains(@style,'list')]"));
        //List<WebElement> languagesList = languagesUl.findElements(By.tagName("li"));
        browser.WaitForElementToBeDisplayed(5,languagesUl);

        List<WebElement> languagesList = driver.findElements(By.xpath("//ul[contains(@style,'list')]/li"));
        for (WebElement language : languagesList) {
            if (language.getText().equals(myLanguage)){
                language.click();
            }
        }
    }

    private void SelectCountryMethod(String countryName) {
        WebElement searchCountry = driver.findElement(By.xpath("//input[@type='search']"));
        //new WebDriverWait(driver, Duration.ofSeconds(5));

        searchCountry.sendKeys(countryName);
        searchCountry.sendKeys(Keys.ARROW_DOWN);
        searchCountry.sendKeys(Keys.ENTER);
    }

    //region Comments
    //ElementClickInterceptedException: Element ... is not clickable at point ... because another
    // element ... obscures it
    //Erorile de not clickable sunt de la pop-up urile/add urile care apar in fereastra de selenium
    // peste elementele de care avem noi nevoie
    //am adaugat extensia de addbock la driverul de chrome in TestBase
    //endregion
}