package DemoShoppingApp.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DemoShoppingApp.Utilities.UtilityPage;

public class CheckOutStepTwo extends UtilityPage{
public WebDriver driver;
@FindBy(css=".inventory_item_name")
public WebElement productName;
@FindBy(css="#finish")
public WebElement finish_button;
@FindBy(css="#cancel")
public WebElement cancel_button;
	public CheckOutStepTwo(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public String getProductName() {
		return productName.getText();
	}
	public CheckOutComplete click_on_Finish() {
		finish_button.click();
		return new CheckOutComplete(driver);
	}

}
