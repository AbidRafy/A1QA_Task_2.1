import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.annotations.*;

public class Demo {
    WebDriver driver;
    WebDriver temp;
    //WebElement link;
    //String buttonHolder;
    @BeforeTest
    public void setUp(){
        ChromeOptions option = new ChromeOptions();
        option.addArguments("incognito");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        //driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        //driver.manage().timeouts().explicit
        //*[@id="footer_text"]/div[2]/a[1]
        //*[@id="store_nav_area"]/div[2]/div/a[2]/span


        driver.get("https://store.steampowered.com/");
    }
    @Test(priority = 1)
    public void testCase(){
        String newWindow = driver.getWindowHandle();
        String title= driver.getTitle();
        System.out.println(title + " is running.");
    }
    @Test(priority = 2)
    public void tabTester(){
        //buttonHolder= Keys.chord(Keys.CONTROL,Keys.ENTER);

        JavascriptExecutor js= (JavascriptExecutor)driver;
        //WebElement policy=driver.findElement(By.xpath("//*[@id=\"footer_text\"]/div[2]/a[1]"));

        WebElement policy=driver.findElement(By.linkText("Privacy Policy"));
        //WebElement top=driver.findElement(By.className("top_new_releases_banner_click"));
        js.executeScript("arguments[0].scrollIntoView();", policy);
        policy.sendKeys(Keys.chord(Keys.CONTROL,Keys.ENTER));
        //ArrayList<String> tabs = new ArrayList<String> (Collections.singleton(newWindow));
        //driver.switchTo().window(tabs[1]);
        //driver.getTitle();
        String childTab = driver.getWindowHandle();
        temp=driver.switchTo().window(childTab);
        //System.out.println(driver.getTitle());
        System.out.println(driver.getTitle());
    }
    @AfterTest
    public void tearDown(){
        //driver.quit();
    }

}
