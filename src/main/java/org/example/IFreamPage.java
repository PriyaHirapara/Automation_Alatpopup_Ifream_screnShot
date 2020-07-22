package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

// creat IFreamPage class and extend with util class
public class IFreamPage extends Util
{
    // store all veriable
    private String expectedtext= "Not a Friendly Topic";
    private By _fremapath = By.xpath("//span[text() =\"Not a Friendly Topic\"]");
    private By _topic = By.xpath("//input[@type =\"text\"]");
    private By _innerFrameCheckbox = By.xpath("//b[@style =\"color:green\"]");
    private By _animalDropBox = By.xpath("//select[@id =\"animals\"]");


     // creat verifyUserIsOnFramesExamplesPage method
    public void verifyUserIsOnFramesExamplesPage()
    {
    System.setProperty("webdriver.chrome.driver", "C:\\soft\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
    Assert.assertEquals(getTextformElement(_fremapath),expectedtext,"Frames Examples");
    }

    // creat verifyUsercanenterAllDetail method
    public void verifyUsercanenterAllDetail ()
    {
        driver.switchTo().frame("frame1");
        sendKeyElement(_topic, "enter topic name");
        driver.switchTo().frame("frame3");
        clickonElement(_innerFrameCheckbox);
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame2");
        selectFromDropDownByValue(_animalDropBox,"avatar");
        driver.switchTo().defaultContent();
    }
}
