import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PrivacyPolicyPage {
	
	WebDriver driver;
	
	
	//WebElement privacyPolicyLink;

	private By languageIdLocator = By.id("languages");
	private By privacyPolicyLinkLocator = By.linkText("Privacy Policy");
	
	public PrivacyPolicyPage() {
		driver = Singleton.Driver();
		
		
	}


	
	public boolean IsPrivacyPolicyPresent() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	
        WebElement privacyPolicyLink = wait.until(ExpectedConditions.elementToBeClickable(privacyPolicyLinkLocator));
		return privacyPolicyLink.isDisplayed();
		
		
	}
	
	public void openPrivacyPolicy() {
		WebElement privacyPolicyLink = driver.findElement(privacyPolicyLinkLocator);
        privacyPolicyLink.click();
        
	}
	
	
	public boolean IsPrivacyPolicyPageOpened() {
		


	        WebElement switchLanguage = driver.findElement(languageIdLocator);
	        return switchLanguage.isDisplayed();
	        
	        
		
	}


	
}

 

        

        

        
       
        
    


