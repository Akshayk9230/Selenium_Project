package DemoShoppingApp.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DemoShoppingApp.Utilities.UtilityPage;

public class ProductPage extends UtilityPage{
public String productName;
public WebDriver driver;
@FindBy(xpath="//div[@class='inventory_details_name large_size']")
WebElement productActual;
@FindBy(css="#add-to-cart-sauce-labs-backpack")
WebElement addToCart;
@FindBy(css="#remove-sauce-labs-backpack")
WebElement remove;

	public ProductPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String get_Product_Name() {
		return productActual.getText();
	}
	public void add_to_cart() {
		addToCart.click();
	}
	public void remove_from_cart() {
		remove.click();
	}

}
