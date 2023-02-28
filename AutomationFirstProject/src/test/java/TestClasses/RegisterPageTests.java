package TestClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterPageTests extends TestBase{
    @Test
    public void Test1() {
        Assert.assertTrue(driver.getTitle().contains("Indexx"));
    }
}
