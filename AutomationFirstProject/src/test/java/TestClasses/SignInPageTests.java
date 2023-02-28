package TestClasses;

import PageObjects.SignInPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInPageTests extends TestBase{
    @Test
    public void InvalidCredentialsErrorIsShown(){
        var signInPage = new SignInPage(driver);
        signInPage.LoginWithInvalidCredentials();
        Assert.assertTrue(signInPage.LoginErrorDisplayed());
        Assert.assertEquals(signInPage.GetLoginErrorMessage(), "Invalid User Name or PassWord");
    }
}
