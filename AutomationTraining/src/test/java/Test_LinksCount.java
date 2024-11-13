import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_LinksCount {

	public static void main(String[] args) {
		// Give me the count of links on the page.
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		System.out.println(driver.findElements(By.tagName("a")).size());
		WebElement footerLinks=driver.findElement(By.id("gf-BIG"));
		
		WebElement colSize= driver.findElement(By.xpath("//div[@id='gf-BIG']/table/tbody/tr/td[1]"));
		System.out.print("Links available in Col1: ");
		System.out.println(colSize.findElements(By.tagName("a")).size());
		
		//Count of footer section
		System.out.println(footerLinks.findElements(By.tagName("a")).size());
		
		
		//Open all links in separate tabs.
		for(int i=1; i<colSize.findElements(By.tagName("a")).size();i++) 
			{
			
			//Open all links in new tab
			String clicklinkTab= Keys.chord(Keys.CONTROL,Keys.ENTER);
			colSize.findElements(By.tagName("a")).get(i).sendKeys(clicklinkTab);
			
			}
			//getting titles of each child tabs
			
			Set<String> abc= driver.getWindowHandles();
			Iterator<String> it= abc.iterator();
			
			//It will check if there is any other windos are not
			while(it.hasNext()) 
			{
				
				//If finds then will switch to that window
				driver.switchTo().window(it.next());
				System.out.println(driver.getTitle());
			}
			

	}

}
