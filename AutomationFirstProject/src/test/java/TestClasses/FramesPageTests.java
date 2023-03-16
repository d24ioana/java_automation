package TestClasses;

import PageObjects.FramesPage;
import PageObjects.HomePage;
import PageObjects.RegisterPage;
import org.testng.annotations.Test;

public class FramesPageTests extends TestBase{
    @Test
    public void FramesTesting(){
        HomePage homePage = new HomePage(driver);
        RegisterPage registerPage = homePage.SkipSignIn();
        FramesPage framesPage = registerPage.NavigateToFramesPage();
        framesPage.TestFrames();

    }
}
