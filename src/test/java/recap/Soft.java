package recap;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Soft {

    @Test
    public void test(){
        System.out.println("test 1 starting");
        Assert.assertEquals(5,5);
        System.out.println("test 1 middle");
        new SoftAssert();
        System.out.println("end test 1");
    }
@Test
    public void test2(){
        System.out.println("Test 2 starting");
    }
}
