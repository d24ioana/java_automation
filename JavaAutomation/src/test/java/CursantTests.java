import incapsulare.Cursant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CursantTests {
    @Test
    public void CursantRespinsDacaNotaEsteSubCinci(){
        //Arrange
        var cursant = new Cursant("Ioana", 24);
        //In c# exista var si dynamic, var isi da seama ce este la declarare, dynamic doar la compilare
        //In Java este doar var; Putem folosi Cursant cursant = new... sau var cursant = ...
        //In Java 8 de ex. nu exista var, doar in Java11
        String expectedResult = "Nu";

        //Act
        String actualResult = cursant.StadiuAdmisRespins(4.980);

        //Assert
        Assert.assertEquals(expectedResult, actualResult);
    }
}
