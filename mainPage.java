import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class mainPage {
	
	WebDriver driver;
	
	private By loginButtonLocator = By.xpath("//a[@class='global_action_link']");
	private By searchBarLocator = By.id("store_nav_search_term");
	private By searchButtonLocator = By.xpath("//a[@id='store_search_link']//img[@src='https://store.cloudflare.steamstatic.com/public/images/blank.gif']");
	private By searchBoxTextLocator = By.id("term");
	private By firstNameLocator = By.xpath("//div[@id='search_result_container']//a[1]//span[@class='title']");
	private By secondNameLocator = By.xpath("//div[@id='search_result_container']//a[2]//span[@class='title']");

	public mainPage() {
		driver = Singleton.Driver();
	}

	public boolean MainPageisDisplayed() {
		
		WebElement loginbutton = driver.findElement(loginButtonLocator);
		return loginbutton.isDisplayed();
	}
	
	public void search(String keys) {
		
		driver.findElement(searchBarLocator).sendKeys(keys);
        driver.findElement(searchButtonLocator).click();
	}
	
	public String searchBoxText() {
		return driver.findElement(searchBoxTextLocator).getAttribute("value");
	}
	
	public String getFirstNameofList() {
		return driver.findElement(firstNameLocator).getText();
	}
	
	public String getSecondNameofList() {
		return driver.findElement(secondNameLocator).getText();
	}
	

	
	 
	
	

}
