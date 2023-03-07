package TestClasses;

import PageObjects.HomePage;
import PageObjects.RegisterPage;
import PageObjects.WindowsPage;
import org.testng.annotations.Test;

public class WindowsPageTests extends TestBase{
    @Test
    public void WindowsTesting(){
        HomePage homePage = new HomePage(driver);
        RegisterPage registerPage = homePage.SkipSignIn();
        WindowsPage windowsPage = registerPage.NavigateToWindowsPage();

    }
}
