package DemoShoppingApp.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DemoShoppingApp.Utilities.UtilityPage;

public class CartPage extends UtilityPage{
	public WebDriver driver;
	
	@FindBy(css=".inventory_item_name")
	public WebElement productName;
	@FindBy(css="#checkout")
	public WebElement checkout;
	
	public CartPage(WebDriver driver) {
		super(driver);	
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getProductName() {
		return productName.getText();
	}
	public CheckOutStepOne click_on_checkout() {
		checkout.click();
		return new CheckOutStepOne(driver);
	}


}
