package TestClasses;

import PageObjects.HomePage;
import PageObjects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterPageTests extends TestBase{
    @Test
    public void InterractionWithWebElementsIsPossible() {
        HomePage homePage = new HomePage(driver);
        RegisterPage registerPage = homePage.SkipSignIn();
        registerPage.InterractWithAllElements();
    }
}
