package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;

// creat class util class extend with basepage class
public class Util extends BasePage
{
    public static void waituntilElementislickble(By by, int a)
    {
        WebDriverWait wait = new WebDriverWait(driver, a);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    public static void sleep1(int n)
    {
        try {
            Thread.sleep(n * 1000);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    // method for click element
    public static void clickonElement(By by)
    {
        driver.findElement(by).click();
    }
    //method for sendkey
    public static void sendKeyElement(By by, String text)
    {
        driver.findElement(by).sendKeys(text);
    }
    // method for get text
    public  String getTextformElement(By by)
    {
        return driver.findElement(by).getText();
    }
    //method for drop down text
    public static void selectFromDropDownByVisibleText(By by, String vtext)
    {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(vtext);
    }
    //methodfor drop down value
    public static void selectFromDropDownByValue(By by, String value)
    {
        Select select = new Select(driver.findElement(by));
        select.selectByValue(value);
    }
    // method for drop down index
    public static void selectFromDropDownByIndex(By by, int Indexvalue)
    {
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(Indexvalue);
    }
    public static void handlePopupAlert(){
        // accepting javascript alert
        Alert alert = driver.switchTo().alert();
    }
    public static void handleAlertMessageverify()
    {
        Alert alert = driver.switchTo().alert();
        String alertMessage = driver.switchTo().alert().getText();
    }
    // creat method for taking screenshot when test case is fail
    public void screenshot(String photo){
    File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try
        {
            FileUtils.copyFile(srcFile, new File("src\\Screenshot\\" + photo+ ".jpg"));
        }
            catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    //method for timestamp
    public  long timestamp()
    {
        return (System.currentTimeMillis());
    }
}


