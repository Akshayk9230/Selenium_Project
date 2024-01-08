package DemoShoppingApp.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DemoShoppingApp.Utilities.UtilityPage;

public class InventoryPage extends UtilityPage{
	public WebDriver driver;
	public String productName;
	@FindBy(css=".inventory_item")
	List<WebElement> products;
	@FindBy(xpath="//div[@class='app_logo']")
	WebElement app_logo;
	
	
	public InventoryPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public boolean visibilityofProduct(String productName) {
		Boolean res=products.stream().anyMatch(s->s.findElement(By.cssSelector("div.inventory_item_name ")).getText().equalsIgnoreCase(productName));
		return res;	
	}
	public void addToCart(String productName) {
		for(int i=0;i<products.size();i++) {
			Boolean res=products.get(i).findElement(By.cssSelector("div.inventory_item_name ")).getText().equalsIgnoreCase(productName);
			if(res==true) {
				products.get(i).findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory ']")).click();
				break;
			}
		}
	}
	public ProductPage click_on_Product(String productName) {
		for(int i=0;i<products.size();i++) {
			Boolean res=products.get(i).findElement(By.cssSelector("div.inventory_item_name ")).getText().equalsIgnoreCase(productName);
			if(res==true) {
				products.get(i).findElement(By.tagName("a")).click();
				break;
			}
		}
		return new ProductPage(driver);
	}
	public boolean app_logo_is_present() {
		return app_logo.isDisplayed();
	}
}
