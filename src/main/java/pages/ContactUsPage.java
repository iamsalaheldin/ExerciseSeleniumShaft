package pages;

import org.openqa.selenium.By;
import com.shaft.driver.SHAFT;

public class ContactUsPage {

	// Variables
	private final SHAFT.GUI.WebDriver driver;
	

	// Constructor
	public ContactUsPage(SHAFT.GUI.WebDriver driver) {
		this.driver =driver;	
		}
	
	// Locators 
	private final By nameField = By.name("name");
	private final By emailField = By.name("email");
	private final By subjectField = By.name("subject");
	private final By messageField = By.name("message");
	private final By uploadFileBtn = By.name("upload_file");
	private final By submitBtn = By.name("submit");

	//Keywords
	public ContactUsPage EnterMessageDetails(String name, String email, String subject, String message, String filePath)  {
		driver.element().type(nameField, name);
		driver.element().type(emailField, email);
		driver.element().type(subjectField, subject);
		driver.element().type(messageField, message);
		driver.element().type(uploadFileBtn, filePath);	
		

		return this;
	}
	
	public ContactUsPage2 ClickOnSubmit() {
		driver.browser().setWindowSize(1000, 1000);
		driver.element().scrollToElement(submitBtn).click(submitBtn);
		
		driver.alert().acceptAlert();

		driver.browser().maximizeWindow();
		return new ContactUsPage2(driver);
	}
	
}
