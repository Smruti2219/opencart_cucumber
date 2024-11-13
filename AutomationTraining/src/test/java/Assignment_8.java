import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment_8 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		
		/*Practicing relative(customized and unique) locators for CSS, Xpath with contains 
		method, link text, names, id, partial link text, class name, tag name */
		
		//Used CSS locators with id
		driver.findElement(By.cssSelector("#nav-logo"));
		
		//Used CSS locators with classname
		driver.findElement(By.cssSelector(".a-declarative.nav-progressive-attribute")).click();
		
		//xpath using contains IDs
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@id, 'UpdateInput')]")));
		driver.findElement(By.xpath("//input[contains(@id, 'UpdateInput')]")).sendKeys("560017");
		
		//CSS selector with aria-labelledby attribute.
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[aria-labelledby='GLUXZipUpdate-announce']")).click();
		
		//xpath using contains name
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[contains(@name, 'field-key')]")).sendKeys("iphone 15");
		
		//xpath using contains classname
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[contains(@class, 'nav-search-submit')]")).click();
		
        ((JavascriptExecutor) driver).executeScript("window.open('');");

        // Get updated handles of all open tabs
        ArrayList<String> windowHandles = new ArrayList<>(driver.getWindowHandles());

        // Switch to the newly opened tab (last in the list)
        driver.switchTo().window(windowHandles.get(windowHandles.size() - 1));
        driver.get("https://rahulshettyacademy.com/client/");
		
		 //relative locators uaing "Above" 
        By emailLocator =RelativeLocator.with(By.tagName("input")).above(By.id("userPassword"));
		 driver.findElement(emailLocator).sendKeys("pikunew2219@gmail.com");
		  
		 //relative locators using "Below" 
		 By passwordLocator = RelativeLocator.with(By.tagName("input")).below(By.id("userEmail"));
		 driver.findElement(passwordLocator).sendKeys("Smruti@2219");
		  
		 driver.findElement(By.id("login")).click();
		  
		 //relative locators using "toLeftOf" 
		 Thread.sleep(1000); 
		 By Orders= RelativeLocator.with(By.tagName("button")).toLeftOf(By.xpath("//button[@routerlink='/dashboard/cart']"));
		 driver.findElement(Orders).click();
		 
		 //relative locators using "torightOf" 
		 Thread.sleep(1000); 
		 By cart= RelativeLocator.with(By.tagName("button")).toRightOf(By.xpath("//button[@routerlink='/dashboard/myorders']"));
		 driver.findElement(cart).click();
		 driver.findElement(By.xpath("//button[normalize-space()='Sign Out']")).click();
		 
		 //relative locators using Chaining relative locators using both "below" and "above". 
		 Thread.sleep(1000); 
		 By passwordEnter = RelativeLocator.with(By.tagName("input")).below(By.id("userEmail")).above(By.id("login")); 
		 driver.findElement(passwordEnter).sendKeys("Smruti");
		 
		 By emailID= RelativeLocator.with(By.tagName("input")).above(By.cssSelector("#userPassword"));
		 driver.findElement(emailID).sendKeys("smruti.samal@ipsos.com");
        
        //RelativeLocators for Partial link text 
        By ForgotPass= RelativeLocator.with(By.tagName("a")).partialLinkText("Forgot pass");
        driver.findElement(ForgotPass).click();
        
        
        Thread.sleep(2000);
        driver.quit();

	}

}
