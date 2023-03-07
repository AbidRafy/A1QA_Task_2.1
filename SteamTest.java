import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class SteamTest {
    WebDriver driver;



    @Test(priority = 1)
    public void PrivacyPolicyTest()
    {


        mainPage theMainPage = new mainPage();
        PrivacyPolicyPage privacyPolicy = new PrivacyPolicyPage();
        BrowserUtils browserUtils = new BrowserUtils();

        Assert.assertTrue(theMainPage.MainPageisDisplayed(),"Main page not found");

        browserUtils.scrollToEnd();

        privacyPolicy.openPrivacyPolicy();

        browserUtils.checkWindow();

        Assert.assertTrue(privacyPolicy.IsPrivacyPolicyPresent(),"Privacy Policy not found");

        Assert.assertTrue(privacyPolicy.IsPrivacyPolicyPageOpened(),"Switch Language elements List not Displayed");



    }

    @Test(priority = 2)
    public void GameSearch() throws IOException {


        mainPage theMainPage = new mainPage();
        PrivacyPolicyPage privacyPolicy = new PrivacyPolicyPage();


        theMainPage.search("Dota 2");

        String expectedTitle = "Dota 2";
        String actualTitle = theMainPage.searchBoxText();

        Assert.assertEquals(expectedTitle, actualTitle, "Search Box on result page does not contain Dota 2");


        String firstName = theMainPage.getFirstNameofList();

        Assert.assertEquals(expectedTitle, firstName, "The first name is not equal to searched name");


        String secondName = theMainPage.getSecondNameofList();



        theMainPage.search(secondName);

        String searchboxTitle = theMainPage.searchBoxText();

        Assert.assertEquals(secondName, searchboxTitle, "Search Box on result page does not contain the second name");

    }

    @BeforeMethod
    public void startUp() {

        driver = Singleton.Driver();
        driver.manage().window().maximize();
        driver.get("https://store.steampowered.com");
    }

    @AfterTest
    public void Teardown() {

        driver.quit();
    }

}
