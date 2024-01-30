package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.shaft.driver.SHAFT;

public class BaseTest {

	public SHAFT.GUI.WebDriver driver;
	@BeforeClass
	public void setup() {
		driver = new SHAFT.GUI.WebDriver();
	}
	
	@AfterClass
	public void tearDown() {
		driver.browser().closeCurrentWindow();
	}
}
