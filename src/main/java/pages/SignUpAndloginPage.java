package pages;

import org.openqa.selenium.By;
import com.shaft.driver.SHAFT;

public class SignUpAndloginPage {
	
	// Variables
    private final SHAFT.GUI.WebDriver driver;

	// Constructor
	public SignUpAndloginPage(SHAFT.GUI.WebDriver driver) {
		this.driver =driver;	}

	// Locators 
	public static By NewUserSignupLabel() {
        return By.xpath("//h2[contains(.,'New User Signup!')]");
    }	
	private final By nameField =  By.name("name");
    private final By emailAdressField = By.xpath("//*[@data-qa='signup-email']");
    private final By signUpBtn = By.xpath("//button[contains(.,'Signup')]");
    private final By signInEmail = By.xpath("(//input[@type='email'])[1]");
    private final By password = By.name("password");
    private final By loginBtn = By.xpath("//button[contains(.,'Login')]");
    public static By account_infoLocator(){return By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/h2/b");};

    
	// Keywords
    public SignUpAndloginPage AddNewUserSignup (String name, String signupEmail) {
        driver.element().type(nameField, name);
        driver.element().type(emailAdressField , signupEmail);
        return this;
    }
    
    public SignUpPage ClickOnSignUpButton() {
       driver.element().click(signUpBtn);
       return new SignUpPage(driver);
    }
    
    public SignUpAndloginPage LoginUsingValidNameAndPassword( String email, String Password) {
        driver.element().type(signInEmail, email);
        driver.element().type(password, Password);
        return this;
    }
    
    public HomePage ClickOnLoginButton() {
        driver.element().click(loginBtn);
        return new HomePage(driver);
    }
}
