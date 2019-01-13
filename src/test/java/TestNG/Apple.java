package TestNG;

import org.testng.annotations.*;



public class Apple {
    @BeforeClass
    public void setUp(){
        System.out.println("Setting up the environment in Before Class");
    }

    @AfterClass
    public void tearDown(){
        System.out.println("Closing everything in After Class");
    }

    @Test(priority = 1)
    public void bm(){
        System.out.println("Test1 is happening");
    }

    @BeforeTest
    public void setUp2(){
        System.out.println("Before Test running");
    }

    @Ignore
    @Test(priority = 2)
    public void wappleInfo(){
        System.out.println("Test2 is happening");
    }

    @Test(dependsOnMethods = "wappleInfo")
    public void login() {
        System.out.println("Posting something in my timeline");
    }



}
