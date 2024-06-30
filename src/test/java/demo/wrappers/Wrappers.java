package demo.wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Wrappers {
    /*
     * Write your selenium wrappers here
     */

     public static void wrapperSendKeys(WebElement element, String inputText) {
        try{
            element.sendKeys(inputText);
        }
        catch(Exception e){}
    }
    public static void wrapperClick(WebDriver driver, WebElement element) throws InterruptedException{

        element.click();
        Thread.sleep(3000);

    }
}

