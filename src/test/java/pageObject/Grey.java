package pageObject;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class Grey {

    @BeforeClass
    public static void setUp(){
        System.out.println("Junit Before Class");
    }

    @Before
    public void b1(){
        System.out.println("Junit before annotation");
    }

    @Test
    public void test1(){
        System.out.println("Junit test 1");
        Assert.assertEquals("here",4,5);

    }

    @Test
    public void test2(){
        System.out.println("Junit test 2");
    }
}
