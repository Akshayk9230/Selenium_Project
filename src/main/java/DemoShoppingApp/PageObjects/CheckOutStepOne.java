package DemoShoppingApp.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DemoShoppingApp.Utilities.UtilityPage;

public class CheckOutStepOne extends UtilityPage{
	public WebDriver driver;
	@FindBy(css="#first-name")
	public WebElement firstName;
	@FindBy(css="#last-name")
	public WebElement lastName;
	@FindBy(css="#postal-code")
	public WebElement zipCode;
	@FindBy(css="#continue")
	public WebElement continueButton;
	@FindBy(css="#cancel")
	public WebElement cancelButton;
	public CheckOutStepOne(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public CheckOutStepTwo click_on_Continue() {
		continueButton.click();
		return new CheckOutStepTwo(driver);
	}
	
	
}
