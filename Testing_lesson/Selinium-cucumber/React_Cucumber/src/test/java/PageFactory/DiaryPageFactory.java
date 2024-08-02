package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DiaryPageFactory {
WebDriver driver;

	

	@FindBy(xpath = "//a[normalize-space()='Dairy']")

	WebElement Dairy;

	

	public void DairyPage() {

		Dairy.isDisplayed();

	}
	public void ClickDiaryButton() {
		// TODO Auto-generated method stub
		Dairy.click();
	}
	

	public DiaryPageFactory(WebDriver driver) {

		

		this.driver = driver;

		PageFactory.initElements(driver,this);

	}



	



}
