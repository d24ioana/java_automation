package TestClasses;

import PageObjects.HomePage;
import PageObjects.SignInPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInPageTests extends TestBase{
    @Test
    public void InvalidCredentialsErrorIsShown(){
        HomePage homePage = new HomePage(driver);
        SignInPage signInPage = homePage.SignIn();
        signInPage.LoginWithInvalidCredentials();
        Assert.assertTrue(signInPage.LoginErrorDisplayed());
        Assert.assertEquals(signInPage.GetLoginErrorMessage(), "Invalid User Name or PassWord");
        System.out.println("RegisterPageRunTest-InvalidCredentialsErrorIsShown");
    }
}
