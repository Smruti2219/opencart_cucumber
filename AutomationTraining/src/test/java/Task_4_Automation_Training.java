import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Task_4_Automation_Training {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//1)select on Multicity 
		driver.findElement(By.xpath("//input[@value='TripPlanner']")).click();
		driver.findElement(By.xpath("//a[@id='MultiCityModelAlert']")).click();
		
		Thread.sleep(2000);
		
		//2)select multiple cities in From and To 
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).sendKeys("Goa (GOI)");
		Thread.sleep(1000);
		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).sendKeys("Jaipur (JAI)");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[contains(@id,'ddl_originStation2_CTXT')]")).sendKeys("Tirupati (TIR)");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[contains(@id,'ddl_destinationStation2_CTXT')]")).sendKeys("Pune (PNQ)");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[contains(@id,'ddl_originStation3_CTXT')]")).sendKeys("Hyderabad (HYD)");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[contains(@id,'ddl_destinationStation3_CTXT')]")).sendKeys("Pune (PNQ)");
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		
		WebElement element = driver.findElement(By.xpath("//input[@id='btnAddMore1']"));
        // Use JavaScript to click the element
        jse.executeScript("arguments[0].click();", element);
        
        
        //4)again click on next Add more and add From & To cities 
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[contains(@id,'ddl_originStation4_CTXT')]")).sendKeys("Tirupati (TIR)");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[contains(@id,'ddl_destinationStation4_CTXT')]")).sendKeys("Bhopal (BHO)");
		
		Thread.sleep(2000);
		WebElement addmore2=driver.findElement(By.xpath("//input[@id='btnAddMore2']"));
		jse.executeScript("arguments[0].click();", addmore2);
		
        Thread.sleep(2000);
		//5)click on Special Assistance 
		WebElement specialElement= driver.findElement(By.xpath("//div[@id='discount-checkbox']/span/a"));
		jse.executeScript("arguments[0].click();", specialElement);
		
		//drop-down- click on Fitness Certificate 
		driver.findElement(By.xpath("//div[@id='SpecialAssistancePopup']/div[2]/table/tbody/tr[2]/td[3]/a")).click();
		
		//6)Navigate back to main site and close Special Assistance pop-up 
		Thread.sleep(1000);
      String currentHandle= driver.getWindowHandle();
      driver.switchTo().window(currentHandle);
      
      driver.findElement(By.id("SpecialAssistanceWindow")).click();
      
      //7)Now remove last From-To cities 
      driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation4_CTXT")).clear();
      driver.findElement(By.xpath("//input[contains(@id,'ddl_originStation4_CTXT')]")).clear();
      
      //8)click on search 
      driver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();
      
      
		
	}

}
