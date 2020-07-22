import org.example.BrowserManager;
import org.example.Util;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends Util
{
    //creat object browsermanager
    BrowserManager browserManager = new BrowserManager();

    @BeforeMethod

    // creat method for open browser
    public void openBrowser()
    {
        // call method for opner brower
        browserManager.setBeowser();
    }

    @AfterMethod
    // creat method for close browser
    public void close(ITestResult result)
    {
        if(ITestResult.FAILURE==result.getStatus()){
            screenshot(result.getName()+timestamp());
        }
        // call method for close browser
        browserManager.browserclose();
    }
}
