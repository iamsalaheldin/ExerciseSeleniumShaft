package pages;

import org.openqa.selenium.By;
import com.shaft.driver.SHAFT;

public class CheckOutPage {

	// Variables
	private final SHAFT.GUI.WebDriver driver;
	
	// Constructor
	public CheckOutPage(SHAFT.GUI.WebDriver driver) {
		this.driver = driver; 
	}

	// Locators 
	private final By addComment = By.xpath("//div[@class='form-group']//textarea");
    private final By placeHolder = By.linkText("Place Order");
    
	//Keywords
    public CheckOutPage AddComment(String text) {
        driver.element().type(addComment, text);
        return this;
    }
    
    public PaymentPage clickOnPlaceholder(){
        driver.element().click(placeHolder);
        return new PaymentPage(driver);
    }
}
