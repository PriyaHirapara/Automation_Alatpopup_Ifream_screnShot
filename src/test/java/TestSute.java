import org.example.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestSute extends BaseTest
{
    // creat all object from all class
    HomePage homePage = new HomePage();
    FaceBookPage faceBookPage = new FaceBookPage();
    NewOnLineStorePage newOnLineStorePage = new NewOnLineStorePage();
    IFreamPage iFreamPage = new IFreamPage();


@Test
// creat method for alart
  public void verifyUserCanAlart() {
     homePage.varifyuserIsOnHomePage();
     homePage.clickOnSerchbutton();
     homePage.handleAlertMessage();
     homePage.UserCanclickonFacbookIcon();// click on facebookicon
}

  @Test(priority = 1)
  // user can able to handul popupwindow
   public  void verifyAlartPopupWindow()
  {
      System.setProperty("webdriver.chrome.driver", "C:\\soft\\chromedriver.exe");//creating crom driver object to one google crom driver
      // driver open wed page
      driver = new ChromeDriver();
      driver.get("https://www.facebook.com/nopCommerce");
      faceBookPage.verifyAlertPopupWindow();
  }
  @Test(priority = 3)
   // user can get his comment all time last
   public void verifyUserCanCommentandGetlastComment()
  {
    homePage.clickOnDetailButton();
}
@Test(priority = 2)
 // user need to verify user can click on facebookbuttonand get green colour button
    public void verifyUsercanClickOnFacebookPageAndVrifyGreenButton()
   {
    homePage.clickOnDetailButton();
    newOnLineStorePage.verifynopCommercenewrelease();
    newOnLineStorePage.verifynopCommercenewrelease();
    newOnLineStorePage.verifyTextIsSuccesFullySend();
    newOnLineStorePage.verifyTextnewsline();
}
@Test(priority = 4)
    // user can handla switch to other window and comeback to parent window
    public void verifyFreamEmanpleWebside()
{
    iFreamPage.verifyUserIsOnFramesExamplesPage();
    iFreamPage.verifyUsercanenterAllDetail();
}
@Test(priority = 5)
    // user can able to see all product with currancy whatever he select
    public void  verifycurrancySelecttionFromDropDown()
    {
        homePage.currancySelecttionFromDropDown();
    }
}