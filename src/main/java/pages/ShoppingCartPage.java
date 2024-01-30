package pages;

import org.openqa.selenium.By;
import com.shaft.driver.SHAFT;

public class ShoppingCartPage {

	// Variables
	private final SHAFT.GUI.WebDriver driver;
	
	// Constructor
	public ShoppingCartPage(SHAFT.GUI.WebDriver driver) {
		this.driver = driver; 
	}

	// Locators 
    private final By checkOutBtn = By.linkText("Proceed To Checkout");

	//Keywords
    public CheckOutPage ClickOnCheckOutBtn(){
        driver.element().click(checkOutBtn);
        return new CheckOutPage(driver);
    }
}
