package DemoShoppingApp.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import DemoShoppingApp.PageObjects.CartPage;
import DemoShoppingApp.PageObjects.InventoryPage;
import DemoShoppingApp.PageObjects.LoginPage;
import DemoShoppingApp.PageObjects.ProductPage;
import DemoShoppingApp.Utilities.BaseTest;

public class LoginTests extends BaseTest{
	
	LoginPage login_page;
	InventoryPage inventory_page;
	ProductPage product_page;
	CartPage cart_page;
	@Test
	public void loginTestPositive() {
		login_page=new LoginPage(driver);
		inventory_page=login_page.userLogin("standard_user", "secret_sauce");
		Assert.assertEquals(inventory_page.app_logo_is_present(), true);
		
	}
	@Test()
	public void loginTest_wrongCredentials() {
		login_page=new LoginPage(driver);
		inventory_page=login_page.userLogin("standard_user", "secret");
		Assert.assertEquals(login_page.getErrormessage(), "Epic sadface: Username and password do not match any user in this service");
	}
	@Test
	public void loginTest_locked_user() {
		login_page=new LoginPage(driver);
		inventory_page=login_page.userLogin("locked_out_user", "secret_sauce");
		Assert.assertEquals(login_page.getErrormessage(), "Epic sadface: Sorry, this user has been locked out.");
	}
	
}
