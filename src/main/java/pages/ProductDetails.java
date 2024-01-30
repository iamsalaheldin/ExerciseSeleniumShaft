package pages;

import org.openqa.selenium.By;
import com.shaft.driver.SHAFT;

public class ProductDetails {

	// Variables
	private final SHAFT.GUI.WebDriver driver;
	
	// Constructor
	public ProductDetails(SHAFT.GUI.WebDriver driver) {
		this.driver = driver; 
	}

	// Locators 
    public final By addToCART = By.xpath("//button[contains(.,'Add to cart')]");
    public final By viewCART = By.xpath("//*[@id='cartModal']/div/div/div[2]/p[2]/a/u");
    public static By successMsg(){return By.xpath("//*[@id='cartModal']/div/div/div[1]/h4");}

	
	//Keywords
    public ProductDetails ClickOnAddToCart(){
        driver.element().click(addToCART);
        return this;
    }
    
    public ShoppingCartPage ClickOnviewCartBtn(){
        driver.element().click(viewCART);
        return new ShoppingCartPage(driver);
    }
    
}
