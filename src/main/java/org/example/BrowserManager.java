package org.example;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BrowserManager extends Util
{
   @Test
    // cret setbrowser class
    public void setBeowser()
    {
        //setting up Chromedriver path
        System.setProperty("webdriver.chrome.driver", "C:\\soft\\chromedriver.exe");//creating crom driver object to one google crom driver
        // driver open wed page
        driver = new ChromeDriver();
        // maxinizing screen
        driver.manage().window().maximize();
        //applying implist wait of 20 sec to the driver ins
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        // open nop commerce web side
        driver.get("https://demo.nopcommerce.com/");
    }
    //method for browser close
    public  void browserclose()
    {
        // close the browser
        driver.close();
    }
}


