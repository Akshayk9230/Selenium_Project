package DemoShoppingApp.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DemoShoppingApp.Utilities.UtilityPage;

public class LoginPage extends UtilityPage{
WebDriver driver;
@FindBy(id="user-name")
WebElement userName;
@FindBy(id="password")
WebElement password;
@FindBy(id="login-button")
WebElement LoginBtn;
@FindBy(xpath="//h3[@data-test='error']")
WebElement error;
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public InventoryPage userLogin(String username,String pwd) {
		userName.sendKeys(username);
		password.sendKeys(pwd);
		LoginBtn.click();
		return new InventoryPage(driver);
	}
	public String getErrormessage() {
		return error.getText();
	}

}
