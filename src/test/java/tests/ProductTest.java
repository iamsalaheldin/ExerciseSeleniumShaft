package tests;

import org.testng.annotations.Test;

import com.shaft.tools.io.JSONFileManager;

import io.qameta.allure.*;
import pages.CheckOutPage;
import pages.HomePage;
import pages.PaymentPage;
import pages.ProductDetails;
import pages.ProductPage;
import pages.ShoppingCartPage;

import com.shaft.validation.Validations;


@Epic("Automation Exercise")
@Feature("Products Test")
public class ProductTest extends BaseTest{

    public JSONFileManager LoginData = new JSONFileManager(System.getProperty("LoginTestData"));
    public JSONFileManager ProductData = new JSONFileManager(System.getProperty("ProductNameTestData"));
    public JSONFileManager commentData = new JSONFileManager(System.getProperty("CommentTestData"));
    public JSONFileManager paymentData = new JSONFileManager(System.getProperty("PaymentTestData"));
	
	
	@Description("Given the browser is open, When i navigate to Automation Exercise URl,And Click On login in Button, Then Navigate to login page")
    @Severity(SeverityLevel.CRITICAL)
    @Story("valid email and password")
    @Test(description = "Verify New User login is visible")
	public void VerifyTheUserCanLoginByEmailAndPassword() {
		
		new HomePage(driver)
					.navigate()
					.NavigateToSignUpOrLoginPage()
					.LoginUsingValidNameAndPassword(LoginData.getTestData("EmailAddress"),
							LoginData.getTestData("Password"))
					.ClickOnLoginButton();
		
        Validations.assertThat().element(HomePage.logOut()).text().contains("Logout");
	}
	
	 @Description("Click On products, Then Navigate to products page")
	 @Severity(SeverityLevel.CRITICAL)
	 @Story("click on products link")
	 @Test(priority = 1 ,description = "Verify product page is visible" )
	 public void navigateToProducts() {
		 
		 new HomePage(driver)
		 			.NavigateToProductPage();
	 }
	 
	 @Description("Click on search icon to show products.")
	 @Severity(SeverityLevel.CRITICAL)
	 @Story("search for valid product")
	 @Test(priority = 2 ,description = "Verify products appear when user Click on search icon." )
	 public void VerifyTheUserCanSearchProduct() {
	    	
		 new ProductPage(driver);
		 driver.assertThat().element(ProductPage.ALlProductsLabel()).text().contains("All Products");
		 new ProductPage(driver).SearchforProduct(ProductData.getTestData("ProductName"));
	    }
	 
	 @Description("Hover on products and choose product.")
	 @Severity(SeverityLevel.CRITICAL)
	 @Story("click on product")
	 @Test(priority = 3 ,description = "Verify user choose product you want and navigate to product details")
	 public void VerifyTheUserCanMakeHoverAndChooseProduct() {
		 new ProductPage(driver)
		 			.HoverOverProductsAndChooseProduct()
		 			.ClickOnViewProduct();
	 }
	 
	 @Description("navigate to Product Details and add product to cart")
	 @Severity(SeverityLevel.CRITICAL)
	 @Story("Product Details")
	 @Test(priority = 4 ,description = "navigate to Product Details and add product to cart")
	 public void VerifyTheUserCanAddProductToCart() {
		 
		 new ProductDetails(driver)
		 			.ClickOnAddToCart();
		 
		 driver.assertThat().element(ProductDetails.successMsg()).text().contains("Added!").perform();
		 
		 new ProductDetails(driver)
		 			.ClickOnviewCartBtn();
	 }
	 
	 @Description("navigate to shopping cart")
	 @Severity(SeverityLevel.CRITICAL)
	 @Story("Add products to cart")
	 @Test(priority = 5 ,description = "Verify product added to cart")
	 public void navigateToShoppingCart() {
	 
		 new ShoppingCartPage(driver).ClickOnCheckOutBtn();
	    }
	 
	 @Description("navigate to Check out page and add comment about order")
	 @Severity(SeverityLevel.CRITICAL)
	 @Story("Check out")
	 @Test(priority = 6 ,description = "Verify total amount of order and add comment about order")
	 public void VerifyTheUserCanCheckOutProduct() {
		 
		 new CheckOutPage(driver).AddComment(commentData.getTestData("comment"))
		 			.clickOnPlaceholder();
	 }
	 
	 @Description("navigate to Payment Page")
	 @Severity(SeverityLevel.CRITICAL)
	 @Story("Payment with valid data")
	 @Test(priority = 7 ,description = "Verify the order has been confirmed")
	 public void VerifyTheOrderHasBeenconfirmed() {
		 
		 new PaymentPage(driver)
		 		.completeProceedCheckOut(paymentData.getTestData("name"),
		 				paymentData.getTestData("cardNumber"),
		 				paymentData.getTestData("cvcNumber"),
		 				paymentData.getTestData("month"),
		 				paymentData.getTestData("year"));
		 
		 driver.assertThat()
		 			.element(PaymentPage.assertionMessage())
		 			.text()
		 			.contains("Congratulations! Your order has been confirmed!")
		 			.withCustomReportMessage("Error confirmation order")
		 			.perform();
	 }
}
