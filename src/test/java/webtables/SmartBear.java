package webtables;

import org.testng.annotations.Test;
import utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SmartBear extends TestBase {
    @Test
    public void test() throws InterruptedException {
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        Thread.sleep(3000);
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();

        WebElement orderTable = driver.findElement(By.id("ctl00_MainContent_orderGrid"));

        int rowSize = orderTable.findElements(By.tagName("tr")).size();
        List<WebElement> rows = orderTable.findElements(By.tagName("tr"));
     /*   for(int i = 0; i < rowSize; i++ ) {

            List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));

           for(int b = 0; b <columns.size() ; b++ ){
               System.out.print(columns.get(b).getText()+" | ");
           }
            System.out.println();

        }*/
        corPrnt(4,5,orderTable);

    }


    public void corPrnt(int row, int col, WebElement orderTable){
        List<WebElement> rows = orderTable.findElements(By.tagName("tr"));
        for(int i = 0; i < rows.size(); i++ ) {
            if(i == (row)) {
                List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));

            for(int b = 0; b <columns.size() ; b++ ) {
                if (b == col) {

                    System.out.print("| " + columns.get(b).getText() + " |");
                }
            }
            System.out.println();
        }
    }
}
}