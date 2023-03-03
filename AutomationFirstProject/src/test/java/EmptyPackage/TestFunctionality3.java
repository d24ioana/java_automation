package EmptyPackage;

import org.testng.annotations.Test;

public class TestFunctionality3 {
    @Test(groups = {"login", "regression"})
    public void Test1(){
        System.out.println("Functionality2Test1Run");
    }

    @Test
    public void Test2(){
        System.out.println("Functionality2Test2Run");
    }

    @Test
    public void Test3(){
        System.out.println("Functionality2Test3Run");
    }

    @Test(groups = {"login"})
    public void Test4(){
        System.out.println("Functionality2Test1Run");
    }

    @Test(groups = {"regression"})
    public void Test5(){
        System.out.println("Functionality2Test1Run");
    }
}
