package TestClasses;

import PageObjects.AlertsPage;
import PageObjects.HomePage;
import PageObjects.RegisterPage;
import org.testng.annotations.Test;

public class AlertsPageTests extends TestBase{
    @Test
    public void AlertsTesting(){
        HomePage homePage = new HomePage(driver);
        RegisterPage registerPage = homePage.SkipSignIn();
        AlertsPage alertsPage = registerPage.NavigateToAlertsPage();
        alertsPage.TestAlerts();
    }
}
