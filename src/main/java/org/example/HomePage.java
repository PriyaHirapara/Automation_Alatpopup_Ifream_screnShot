package org.example;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

// creat HomePage class extend with Util class
public class HomePage extends Util
{
    // store SearchButton veriable
    private By _SearchButton = By.xpath("//input[@value =\"Search\"] ");
    //store locater _welcomeTitleText veriable
    private By _welcomeTitleText =By.xpath("//div[@class =\"topic-block-title\"]/h2");
    //store locater veriable
    private String _expecetedTitleOOfThePage ="Welcome to our store";
    private String _actualalertPopupWindowText = "Please enter some search keyword";
    private String _expecetedalertPopupWindowText = "Please enter some search keyword";

    // store facebookicon veriable
    private By _faceBookIcon = By.xpath("//a[text() =\"Facebook\"]");
    // store facebookImage veriable
    private By _facebookImage = By.xpath("//i[@class =\"fb_logo img sp_aRLx32r9_ET sx_cd94c4\"]");
    // store currancyselect veriable
    private By _currancySelect = By.xpath("//select[@id=\"customerCurrency\"]");
    // store clickondetailbutton veriable
    private By _clickOnDetailButton = By.xpath("//div[@class='news-items']//div[1]//div[3]//a");

 @Test
    // creat varifyuserIsOnHomePage method
    public void varifyuserIsOnHomePage()
 {
        // to check user is no right page or not by using assert
        Assert.assertEquals(getTextformElement(_welcomeTitleText), _expecetedTitleOOfThePage, "Welcome to our store");
 }
    // creat handleAlertMessage method
    public void handleAlertMessage()
    {
        // handal alert popup
        Alert alert = driver.switchTo().alert();
        // handle popup with alertmessage object
        String alertMessage = driver.switchTo().alert().getText();
        // printout alertmsg
        System.out.println(alertMessage);
        //assert popupwindow
        String expectedpopupwindow = "Please enter some search keyword";
        Assert.assertEquals(_actualalertPopupWindowText, expectedpopupwindow,"Please enter some search keyword");
         // accept alert
         alert.accept();
    }
    // creat clickOnSerchbutton method
    public void clickOnSerchbutton()
    {
        // click on searchbutton
        clickonElement(_SearchButton);
        // handlepopup alert
        handlePopupAlert();
    }
    // creat UserCanclickonFacbookIcon method
    public void UserCanclickonFacbookIcon()
    {
        clickonElement(_faceBookIcon);
    }
    @Test
    // creat currancySelecttionFromDropDown method
    public void currancySelecttionFromDropDown()
    {
        // use dropdpwn reusble method
        selectFromDropDownByVisibleText(_currancySelect,"Euro");
        //List<WebElement> productList = driver.findElements(By.xpath("//div[@class='product-grid home-page-product-grid']//div[2]/h2/a"));
        List<WebElement> priceSelect = driver.findElements(By.xpath("//div[@class='item-grid']//div[@class='prices']"));
        //Assert.assertEquals(productList.size(),priceSelect.size());
        for (WebElement currency : priceSelect)
        {
            System.out.println(currency.getText());
        }
    }
    @Test
    // creat clickOnDetailButton method
    public void clickOnDetailButton()
    {
        clickonElement(_clickOnDetailButton);
    }
}
