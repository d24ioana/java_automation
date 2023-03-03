package EmptyPackage;

import org.testng.annotations.Test;

public class TestFunctionality2 {
    @Test
    public void Test1(){
        System.out.println("Functionality2Test1Run");
    }

    @Test(groups = {"login"})
    public void Test2(){
        System.out.println("Functionality2Test2Run");
    }

    @Test(groups = {"regression"})
    public void Test3(){
        System.out.println("Functionality2Test3Run");
    }
}
