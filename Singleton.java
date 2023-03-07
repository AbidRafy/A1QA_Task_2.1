import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;



public class Singleton {
	
	private static WebDriver driver;


	public static WebDriver Driver() {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
		
		if (driver == null) {

	    	driver = new ChromeDriver(options);
	
		}
		
		return driver;

}
}