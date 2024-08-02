package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PulsesPageFactory {
WebDriver driver;

	

	@FindBy(xpath = "//a[normalize-space()='Pulses']")

	WebElement Pulses;

	

	public void PulsesPage() {

		Pulses.isDisplayed();

	}
	public void ClickPulsesButton() {
		// TODO Auto-generated method stub
		Pulses.click();
	}


	

	public PulsesPageFactory(WebDriver driver) {

		

		this.driver = driver;

		PageFactory.initElements(driver,this);

	}



	

}
