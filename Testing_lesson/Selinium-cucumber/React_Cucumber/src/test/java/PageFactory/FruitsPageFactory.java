package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FruitsPageFactory {

WebDriver driver;

	

	@FindBy(xpath = "//a[normalize-space()='Fruits']")

	WebElement Fruits;

	

	public void FruitsPage() {

		Fruits.isDisplayed();

	}

	public void ClickFruitsButton() {
		// TODO Auto-generated method stub
		Fruits.click();
	}

	public FruitsPageFactory(WebDriver driver) {

		

		this.driver = driver;

		PageFactory.initElements(driver,this);

	}



	

}
