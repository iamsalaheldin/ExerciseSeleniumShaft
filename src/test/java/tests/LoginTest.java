package tests;

import org.testng.annotations.Test;

import com.shaft.tools.io.JSONFileManager;

import io.qameta.allure.*;
import pages.HomePage;

@Epic("Automation Exercise")
@Feature("Login Test")
public class LoginTest extends BaseTest{

	public JSONFileManager LoginData = new JSONFileManager(System.getProperty("LoginTestData"));
	
	 @Description("Given the browser is open, When i navigate to Automation Exercise URl, And Click On Signup Button, And Login Using Valid Name And Password," +
	            "And Click On Click On Login Button, Then navigate to login Page ")
	 @Severity(SeverityLevel.CRITICAL)
	 @Story("valid email and password ")
	 @Test(description = "Login User with correct email and password")
	 public void LoginUserWithCorrectEmailAndPassword() {
		 new HomePage(driver)
		 			.navigate()
		 			.NavigateToSignUpOrLoginPage()
		 			.LoginUsingValidNameAndPassword(LoginData.getTestData("EmailAddress"),
		 					LoginData.getTestData("Password"))
		 			.ClickOnLoginButton();
		 
		 driver.assertThat()
		 		.element(HomePage.logOut())
		 		.text()
		 		.doesNotContain(null)
		 		.withCustomReportMessage("Error Login!")
		 		.perform();
	 }
	 
}
