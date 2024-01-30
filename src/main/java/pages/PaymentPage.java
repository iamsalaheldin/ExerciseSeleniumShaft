package pages;

import org.openqa.selenium.By;
import com.shaft.driver.SHAFT;

public class PaymentPage {

	// Variables
	private final SHAFT.GUI.WebDriver driver;
	
	// Constructor
	public PaymentPage(SHAFT.GUI.WebDriver driver) {
		this.driver = driver; 
	}

	// Locators 
	private final By nameOfCard = By.xpath("//input[@name='name_on_card']");
    private final By cardNumber = By.xpath("//input[@name='card_number']");
    private final By cvcNumber = By.xpath("//input[@name='cvc']");
    private final By expiryMonth = By.xpath("//input[@name='expiry_month']");
    private final By expiryYear = By.xpath("//input[@name='expiry_year']");
    private final By submitOrder = By.id("submit");
    public static By assertionMessage(){ return By.xpath("//p[text()='Congratulations! Your order has been confirmed!']");}
    
    
	//Keywords
    public PaymentPage completeProceedCheckOut(String name, String CNumber, String cvc, String month, String year) {
        driver.element().type(nameOfCard, name);
        driver.element().type(cardNumber, String.valueOf(CNumber));
        driver.element().type(cvcNumber, String.valueOf(cvc));
        driver.element().type(expiryMonth, month);
        driver.element().type(expiryYear, String.valueOf(year));
        driver.element().click(submitOrder);
        return this;
    }
}
