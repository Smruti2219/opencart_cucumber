package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class stepDefinition {
	
	WebDriver driver;
	@Given("the user is on the noCommerce login page")
	public void navigateToLoginPage() {
	    driver= new ChromeDriver();
	    driver.get("https://demo.nopcommerce.com/");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	    driver.findElement(By.className("ico-login")).click();
	}

	@When("the user enters valid credentials \\(username: {string}, password: {string})")
	public void userEntersValidCreds(String username, String password) {
		driver.findElement(By.className("email")).sendKeys(username);
		driver.findElement(By.className("password")).sendKeys(password);
	    
	}

	@When("the user clicks on the Login button")
	public void the_user_clicks_on_the_login_button() {
		driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
	    
	}

	@Then("the user should be redirected to the My Account page")
	public void the_user_should_be_redirected_to_the_my_account_page() {
	   boolean status= driver.findElement(By.className("ico-account")).isDisplayed();
	   Assert.assertEquals(status, true);
	}

	@Then("the user should see a welcome message")
	public void the_user_should_see_a_welcome_message() {
		String welcomeText= driver.findElement(By.xpath("//h2[normalize-space()='Welcome to our store']")).getText();
	    Assert.assertEquals(welcomeText, "Welcome to our store");
	    driver.quit();
	}




}
