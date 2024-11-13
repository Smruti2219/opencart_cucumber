package smrutisamal.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import smrutisamal.AbsractClass.AbstractComponent;

public class LandingPage extends AbstractComponent
{
    
       WebDriver driver;
       
       public LandingPage(WebDriver driver) {
    	   super(driver);
    	   this.driver=driver;
    	   PageFactory.initElements(driver, this);
       }
       /*driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("pikunew2219@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Smruti@2219");
		
		driver.findElement(By.id("login")).click();*/
       @FindBy(id="userEmail")
       WebElement userEmail;
       
       @FindBy(id="userPassword")
       WebElement userPassword;
       
       @FindBy(id="login")
       WebElement loginbtn;
       
       @FindBy(css="[class*='flyInOut']")
       WebElement errorMessage;
       
       public ProductCatalogue LandingPageAction(String userid, String pass) {
    	   userEmail.sendKeys(userid);  
    	   userPassword.sendKeys(pass);
    	   loginbtn.click();
    	   ProductCatalogue productCatalogue= new ProductCatalogue(driver);
		return productCatalogue;
       }
       public String getErrorMessage() {
    	   waitForWebElementToApprove(errorMessage);
    	   String invalidErrorText =errorMessage.getText();
    	   return invalidErrorText;
       }
       public void Goto(WebDriver driver) {
    	   driver.get("https://rahulshettyacademy.com/client/");
       }
  
}
