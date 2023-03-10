package PageObjects;

import TestClasses.TestBase;
import Utils.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class RegisterPage {
    Browser browser;
    private WebDriver driver = TestBase.driver;

    //region WebElements
    @FindBy(xpath = "//input[@placeholder='First Name']")
    private WebElement firstNameField;
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    private WebElement lastNameField;
    @FindBy(xpath = "//textarea[@ng-model='Adress']")
    private WebElement addressTextArea;
    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailField;
    @FindBy(xpath = "//input[@type='tel']")
    private WebElement phoneField;

    @FindBy(xpath = "//input[@value='Male']")
    private WebElement maleRadio;
    @FindBy(xpath = "//input[@value='FeMale']")
    private WebElement femaleRadio;
    @FindBy(id = "checkbox1")
    private WebElement cricketCheckbox;
    @FindBy(id = "checkbox2")
    private WebElement moviesCheckbox;

    @FindBy(id = "checkbox3")
    private WebElement hockeyCheckbox;
    @FindBy(id = "msdd")
    private WebElement languagesAutocompleteMultiselect;
    @FindBy(xpath = "//select[@ng-model='Skill']")
    private WebElement skillsDropdown;
    @FindBy(xpath = "//span[@role='combobox']")
    private WebElement countryContainer;
    @FindBy(id = "yearbox")
    private WebElement birthYearDropdown;
    @FindBy(xpath = "//select[@ng-model='monthbox']")
    private WebElement birthMonthDropdown;
    @FindBy(id = "daybox")
    private WebElement birthDayDropdown;
    @FindBy(id = "firstpassword")
    private WebElement passwordField;
    @FindBy(id = "secondpassword")
    private WebElement confirmPasswordField;
    @FindBy(id = "imagesrc")
    private WebElement uploadFile;
    @FindBy(xpath = "//li[@class='dropdown'][1]") //"//a[contains(text(),'SwitchTo')]"
    private WebElement switchToDropdown;
    @FindBy(xpath = "//ul[contains(@style,'list')]")
    WebElement languagesUl;
    @FindBy(xpath = "//ul[contains(@style,'list')]/li")
    List<WebElement> languagesList;
    @FindBy(xpath = "//input[@type='search']")
    WebElement searchCountry;
    @FindBy(xpath = "//li[@class='dropdown'][1]/ul/li")
    List<WebElement> switchToMenuList;
    //endregion

    public RegisterPage(WebDriver driver){
        this.driver = driver;
        browser = new Browser(this.driver);
        PageFactory.initElements(this.driver,this); //pentru FindBy
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
        Select selectSkills = new Select(skillsDropdown);
        selectSkills.selectByValue("PHP");

        //Interact with auto suggestion dropdown:
        browser.WaitForElementToBeDisplayed(5,countryContainer);
        countryContainer.click();
        SelectCountryMethod("South Africa");

        //Mixed from above:
        Select selectYear = new Select(birthYearDropdown);
        selectYear.selectByValue("1999");
        Select selectMonth = new Select(birthMonthDropdown);
        selectMonth.selectByIndex(1);
        Select selectDay = new Select(birthDayDropdown);
        selectDay.selectByIndex(24);
        passwordField.sendKeys("abcd");
        confirmPasswordField.sendKeys("abcd");

        //interact with upload file/choose file:
        uploadFile.sendKeys("C:/Git/java_automation/AutomationFirstProject/src/test/java/Utils/FileUsedToTestChooseFileFunctionality");
        return this;
    }

    private void ChooseALanguage(String myLanguage) {
        browser.WaitForElementToBeDisplayed(5,languagesUl);

        for (WebElement language : languagesList) {
            if (language.getText().equals(myLanguage)){
                language.click();
            }
        }
    }

    private void SelectCountryMethod(String countryName) {
        //new WebDriverWait(driver, Duration.ofSeconds(5));

        searchCountry.sendKeys(countryName);
        searchCountry.sendKeys(Keys.ARROW_DOWN);
        searchCountry.sendKeys(Keys.ENTER);
    }

    public AlertsPage NavigateToAlertsPage(){
        browser.HoverOnElement(switchToDropdown);
        ChooseSwitchToMenuOption("Alerts");
        return new AlertsPage(driver);
    }

    public WindowsPage NavigateToWindowsPage(){
        browser.HoverOnElement(switchToDropdown);
        ChooseSwitchToMenuOption("Windows");
        return new WindowsPage(driver);
    }

    private void ChooseSwitchToMenuOption(String mySwitchToOption) {
        try{
            for (WebElement switchToOption : switchToMenuList) {
                if (switchToOption.getText().equals(mySwitchToOption)){
                    switchToOption.click();
                }
            }
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex){}
        //try catch pentru org.openqa.selenium.StaleElementReferenceException: stale element reference:
        // element is not attached to the page document
    }

    //region Comments
    //ElementClickInterceptedException: Element ... is not clickable at point ... because another
    // element ... obscures it
    //Erorile de not clickable sunt de la pop-up urile/add urile care apar in fereastra de selenium
    // peste elementele de care avem noi nevoie
    //am adaugat extensia de addbock la driverul de chrome in TestBase
    //endregion
}