import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Task_3_Automation_Training {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		
		//select Departure date
		driver.findElement(By.xpath("//div[@id='flightSearchContainer']/div[4]/button")).click();
		driver.findElement(By.xpath("//div[@id='ui-datepicker-div']//a[contains(text(),'31')]")).click();
		
		//select Return date
		
		
		
		driver.findElement(By.xpath("//div[@id='Div1']/button")).click();
		driver.findElement(By.xpath("//a[@class='ui-datepicker-next ui-corner-all']")).click();
		driver.findElement(By.xpath("//*[@id='ui-datepicker-div']//a[contains(text(), '15')]")).click();
		
		//select 4 adults
		 driver.findElement(By.id("divpaxinfo")).click();
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		 
		for(int i=0; i<3; i++) {
			
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("hrefIncAdt"))));
			driver.findElement(By.id("hrefIncAdt")).click();
			 }
		//Select 2 child
		Thread.sleep(1000);
		for(int i=0; i<2; i++) {
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("hrefIncChd"))));
			driver.findElement(By.id("hrefIncChd")).click();
			
		}
		//Select 1 infant.
		Thread.sleep(1000);
		driver.findElement(By.id("hrefIncInf")).click();
		
		//select family and friends checkbox 
		driver.findElement(By.xpath("//input[contains(@id,'chk_friendsandfamily')]")).click();
		
		//5)Select Arrival and Departure city 
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@id='ctl00_mainContent_ddl_originStation1_CTXTaction']")).click();
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).sendKeys("BLR");
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[contains(@id,'destinationStation1_CTXT')]")).sendKeys("MAA");
		
		//select currency USD
		Select currency =new Select(driver.findElement(By.xpath("//select[contains(@id,'DropDownListCurrency')]")));
		currency.selectByVisibleText("USD");
		
		
		//6)click on search 
		/*Actions action = new Actions(driver);
		WebElement search = driver.findElement(By.xpath("//input[contains(@name,'FindFlights')]"));
		action.moveToElement(search).click().build().perform();*/
		
		 	
			WebElement element = driver.findElement(By.xpath("//input[contains(@name,'FindFlights')]"));
	        // Use JavaScript to click the element
		    JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].click();", element);

	        // Close tab
	        driver.quit();
	}

}
