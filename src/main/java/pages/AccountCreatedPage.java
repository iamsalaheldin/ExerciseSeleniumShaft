package pages;

import org.openqa.selenium.By;
import com.shaft.driver.SHAFT;

public class AccountCreatedPage {

	// Variables
	private final SHAFT.GUI.WebDriver driver;

	// Constructor
    public AccountCreatedPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

	// Locators
    public static By AccountCreatedLabel() {return By.xpath("//b[contains(.,'Account Created')]");}
    public static By continueBtn(){ return By.xpath("//a[contains(.,'Continue')]");}

    // Keywords
    public HomePage ClickOnContinueBtn() {
        driver.element().click(continueBtn());
        return new HomePage(driver);
    }

}
