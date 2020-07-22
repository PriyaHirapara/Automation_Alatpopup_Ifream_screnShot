package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;
    // creat FacebookPage class and extend with util class
    public class FaceBookPage extends Util
    {
        // store expectedfacebookURL
        private String expectedOfFaceBookURL = "https://www.facebook.com/nopCommerce";
        // store creatPageButton veriable
        private By _creatPageButton = By.xpath("//div//button[@class=\"_4jy0 _4jy3 _4jy2 _51sy selected _42ft\"]");
        // store emailOrPhoneMumber veriable
        private By _emailOrPhoneMumber = By.xpath("//tr//input[@name =\"email\"]");
        // store passwordForFaceBook veriable
        private By _passwordForFaceBook = By.xpath("//tr//input[@name =\"pass\"]");
        // store clickOnLoginbutton veriable
        private By _clickOnLoginbutton = By.xpath("//label[@id =\"loginbutton\"]");

@Test
    // creat verifyAlertPopupWindow method
    public void verifyAlertPopupWindow()
{
        // user is on fb URL page
        String actualOfFaceBookURLPage = driver.getCurrentUrl();
        Assert.assertEquals(actualOfFaceBookURLPage, expectedOfFaceBookURL, "error message: page not found");
        // creat veriable
        String MainWindow = driver.getWindowHandle();
        // To handle all new opened window.
        Set<String> s1 = driver.getWindowHandles();
        // creat iterator with while
        Iterator<String> i1 = s1.iterator();
        while (i1.hasNext())
        {
                String ChildWindow = i1.next();
            if (!MainWindow.equalsIgnoreCase(ChildWindow))
            {
                // Switching to Child window
                driver.switchTo().window(ChildWindow);
                // assert URL
                String expectedOfFaceBookURL = driver.getCurrentUrl();
                Assert.assertEquals(actualOfFaceBookURLPage,expectedOfFaceBookURL,"error massage");

                driver.close();
            }
        }
        // Switching to Parent window i.e Main Window.
        driver.switchTo().window(MainWindow);
    }
    // creat VerifyUserEnterFacebookLogInDetail method
    public void VerifyUserEnterFacebookLogInDetail()
    {
        // get text by using diffrent reuseble method
        sendKeyElement(_emailOrPhoneMumber, "priyanka211@gmail.com");
        sendKeyElement(_passwordForFaceBook, "swamibapa");
        clickonElement(_clickOnLoginbutton);
    }
}



