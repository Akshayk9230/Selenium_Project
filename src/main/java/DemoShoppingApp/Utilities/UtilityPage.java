package DemoShoppingApp.Utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import DemoShoppingApp.PageObjects.CartPage;
import DemoShoppingApp.PageObjects.LoginPage;

public class UtilityPage {
	WebDriver driver;
	WebDriverWait wait;
	@FindBy(css=".shopping_cart_link")
	WebElement cart;
	@FindBy(id="react-burger-cross-btn")
	WebElement close;
	@FindBy(id="react-burger-menu-btn")
	WebElement menu;
	@FindBy(id="inventory_sidebar_link")
	WebElement logout;
	@FindBy(id="logout_sidebar_link")
	WebElement allItems;
	
	public UtilityPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, Duration.ofSeconds(5));
	}
	public void waitForInvisibility(WebElement element) {
		wait.until(ExpectedConditions.invisibilityOf(element));
		
	}
	public void waitForVisibility(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public CartPage click_on_Cart() {
		cart.click();
		return new CartPage(driver);
	}
	public void go_to_inventory() {
		menu.click();
		allItems.click();
	}
	public void logout() {
		menu.click();
		logout.click();
	}
}
