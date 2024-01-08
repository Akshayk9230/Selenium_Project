package DemoShoppingApp.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DemoShoppingApp.Utilities.UtilityPage;

public class CheckOutComplete extends UtilityPage{
public WebDriver driver;
@FindBy(css=".complete-header")
public WebElement successMessage;
@FindBy(css="#back-to-products")
public WebElement backToProducts;
	public CheckOutComplete(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public String getSuccessMessage() {
		return successMessage.getText();
	}
	public void click_on_backToProducts() {
		backToProducts.click();
	}

}
