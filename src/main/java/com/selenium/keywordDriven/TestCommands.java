package com.selenium.keywordDriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;

/**
 * Created by Anjulaw on 11/1/2015.
 */
public class TestCommands {

    public TestCommands(){
        setDriver(new FirefoxDriver());
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public static WebDriver driver;

    //final static Logger logger =

    public static int timeout;

    private static WebElement findElement(By byLocator) {

        WebElement element = (new WebDriverWait(driver,timeout)).until(ExpectedConditions.presenceOfElementLocated(byLocator));

        return element;

    }

    public static void waitForElement(By byLocator){
        findElement(byLocator);
        System.out.println("Waited for the Object"+ byLocator +"to Appear");
    }

    public static void click(By byLocator){
        try {
            WebElement element = findElement(byLocator);
            element.click();
            System.out.println("Clicked on the Object" + byLocator);
        }catch (Exception e){
            System.out.println("Cannot click on the Object");
        }
    }

    public static void type(By byLocator,String text){
        try {
            WebElement element = findElement(byLocator);
            element.sendKeys(text);
            System.out.println("Type the text" + text + "on the" + byLocator);
        } catch (Exception e){
            System.out.println("Unable to type the text" + text + "on" + byLocator);
        }
    }

    public final static void launch(String url){
        try {
            driver.navigate().to(url);
            System.out.println("Open the" + url + "successfully");
        }catch (Exception e){
            System.out.println("Unable to Load " + url );
        }
    }



}
