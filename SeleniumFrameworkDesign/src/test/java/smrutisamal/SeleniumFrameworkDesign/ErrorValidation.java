package smrutisamal.SeleniumFrameworkDesign;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import smrutisamal.pageObjects.LandingPage;
import smrutisamal.testComponent.BaseTest;

public class ErrorValidation extends BaseTest{
	@Test(groups= {"Regression"})
	
	public void validation() throws IOException {
		
		
		LandingPage landingPage = setup();
		
		landingpage.LandingPageAction("pikunew221@gmail.com", "Smruti@2219");
		Assert.assertEquals("Incorrect email or password.",landingpage.getErrorMessage());
	}
	

}
