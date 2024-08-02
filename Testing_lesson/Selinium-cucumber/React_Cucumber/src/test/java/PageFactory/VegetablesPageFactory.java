package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VegetablesPageFactory {
WebDriver driver;

	

	@FindBy(xpath = "//a[normalize-space()='Vegetables']")

	WebElement Vegetables;

	

	public void VEgtablePage() {

		Vegetables.isDisplayed();

	}
	public void ClickVegButton() {
		// TODO Auto-generated method stub
		Vegetables.click();
	}
	

	public VegetablesPageFactory(WebDriver driver) {

		

		this.driver = driver;

		PageFactory.initElements(driver,this);

	}
	



}
