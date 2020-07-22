package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
    // creat NewOnLineStorePage class with extends with Util class
    public class NewOnLineStorePage extends Util
{
          private String expectedTextVerifyOnNewLinePage = "New online store is open!";
          private By _actualTextVerifyOnNewLinePage = By.xpath("//h1[text()='New online store is open!']");
          private By _title = By.cssSelector("input#AddNewComment_CommentTitle");
          private By _comment = By.xpath(" //textarea[@class='enter-comment-text']");
          private By _clickonAddComentButon = By.xpath("//input[@name=\"add-comment\"] ");
          private String actualTextMessageSuccess = "News comment is successfully added.";
         // private By _actualTextMessageSuccess = By.xpath("//div[text() =\"News comment is successfully added.\"]");
          private String expectedTextMessageSuccess = "News comment is successfully added.";

    // creat verifyTextnewsline method
    public void verifyTextnewsline()
    {
      Assert.assertEquals(getTextformElement(_actualTextVerifyOnNewLinePage),expectedTextVerifyOnNewLinePage," erroe masseg is coming up");
    }
    // creat verifynopCommercenewrelease method
    public void verifynopCommercenewrelease()
    {
      sendKeyElement(_title, "nice");
      sendKeyElement(_comment,"good night");
      clickonElement(_clickonAddComentButon);
    }
    // creat verifyTextIsSuccesFullySend method
     public void verifyTextIsSuccesFullySend()
     {
      Assert.assertEquals(actualTextMessageSuccess,expectedTextMessageSuccess,"pleas enter all detail");
      List<WebElement> commentlist = driver.findElements(By.xpath("//div[@class = \"comment-body\"]"));
      String lastcommnet = commentlist.get(commentlist.size()-1).getText();
      Assert.assertEquals(lastcommnet,"good night");
     }
}

