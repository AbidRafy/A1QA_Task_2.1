import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class BrowserUtils {
	
	private WebDriver driver;
	
	public BrowserUtils() {
		driver = Singleton.Driver();
	}
	
	

	public void scrollToEnd() {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	public void checkWindow() {
		
		String currentWindowHandle = driver.getWindowHandle();
    	
		 for (String windowHandle : driver.getWindowHandles()) {
	            
				// Check if the handle is not the same as the current window handle
	            if (!windowHandle.equals(currentWindowHandle)) {
	                // Switch to the new window
	                driver.switchTo().window(windowHandle);
	                break;
	            }
	        }
	        
	    	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
	}


}
