package pages;

import org.openqa.selenium.By;
import com.shaft.driver.SHAFT;

public class ProductPage {
	
	// Variables
	private final SHAFT.GUI.WebDriver driver;
	
	// Constructor
	public ProductPage(SHAFT.GUI.WebDriver driver) {
		this.driver = driver; 
	}

	// Locators 
	   public static By ALlProductsLabel() {return By.xpath("//h2[contains(.,'All Products')]");}
	   private final By SearchField = By.name("search");
	   private final By SearchBtn = By.id("submit_search");
	   private final By product1 = By.xpath("//div[@class='productinfo text-center']//img[@src='/get_product_picture/12']");
	   private final By product2 = By.xpath("//div[@class='productinfo text-center']//img[@src='/get_product_picture/16']");
	   private final By product3 = By.xpath("//div[@class='productinfo text-center']//img[@src='/get_product_picture/22']");
	   public final By viewProduct = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[4]/div/div[2]/ul/li/a");
	
	
	//Keywords
	   
	   public ProductPage SearchforProduct(String product){
	        driver.element().type(SearchField, product).click(SearchBtn);
	        return this;
	    }
	   
	    public ProductPage HoverOverProductsAndChooseProduct( ){
	        driver.element().scrollToElement(product1).hover(product1)
	                        .scrollToElement(product2).hover(product2)
	                        .scrollToElement(product3).hover(product3);
	        return this;
	    }
	    
	    public ProductDetails ClickOnViewProduct( ){
	        driver.element().click(viewProduct);
	        return new ProductDetails(driver);
	    }
}
