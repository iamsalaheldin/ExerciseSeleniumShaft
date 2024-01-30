package pages;

import org.openqa.selenium.By;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;

public class HomePage {

	private final SHAFT.GUI.WebDriver driver;
	public String homeURL = ("https://www.automationexercise.com/");
	
	public HomePage (SHAFT.GUI.WebDriver driver) {
		this.driver = driver;
	}
	
	public static By logo() {return By.xpath("//*[@id=\"header\"]/div/div/div/div[1]/div/a/img");}
	public By signUpBtn = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
	public By productsBtn = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a");
	public By contactUsBtn = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[8]/a");
	public static By logOut() {return By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");}
	
    @Step("Navigate to AutomationExercise homepage")
	public HomePage navigate() {
		driver.browser().navigateToURL(homeURL);
		return this;
	}
    
    public SignUpAndloginPage NavigateToSignUpOrLoginPage() {
    	driver.element().click(signUpBtn);
    	return new SignUpAndloginPage(driver);
    }
    
    public ProductPage NavigateToProductPage() {
        driver.element().click(productsBtn);
        return new ProductPage(driver);
    }
    
    public ContactUsPage NavigateToContactUsPage() {
        driver.element().click(contactUsBtn);
        return new ContactUsPage(driver);
    }
    
	
	
}
