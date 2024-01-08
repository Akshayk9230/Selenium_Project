package DemoShoppingApp.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import DemoShoppingApp.PageObjects.CartPage;
import DemoShoppingApp.PageObjects.CheckOutComplete;
import DemoShoppingApp.PageObjects.CheckOutStepOne;
import DemoShoppingApp.PageObjects.CheckOutStepTwo;
import DemoShoppingApp.PageObjects.InventoryPage;
import DemoShoppingApp.PageObjects.LoginPage;
import DemoShoppingApp.Utilities.BaseTest;

public class Test2 extends BaseTest{
	LoginPage loginPage;
	InventoryPage inventoryPage;
	CartPage cartPage;
	CheckOutStepOne checkOutStepOne;
	CheckOutStepTwo checkOutStepTwo;
	CheckOutComplete checkOutComplete;
	String productName="Sauce Labs Backpack";
	@Test
	public void endToEndTesting() {
		loginPage = new LoginPage(driver);
		inventoryPage = loginPage.userLogin("standard_user", "secret_sauce");
		inventoryPage.addToCart("Sauce Labs Backpack");
		cartPage = inventoryPage.click_on_Cart();
		Assert.assertEquals(cartPage.getProductName(), productName); 
			checkOutStepOne = cartPage.click_on_checkout();
		
		checkOutStepOne.firstName.sendKeys("Test");
		checkOutStepOne.lastName.sendKeys("User");
		checkOutStepOne.zipCode.sendKeys("123575");
		checkOutStepTwo = checkOutStepOne.click_on_Continue();
		Assert.assertEquals(checkOutStepTwo.getProductName(), productName); 
		checkOutComplete = checkOutStepTwo.click_on_Finish();
		Assert.assertEquals(checkOutComplete.getSuccessMessage(), "Thank you for your order!");
		checkOutComplete.click_on_backToProducts();
		Assert.assertEquals(inventoryPage.app_logo_is_present(), true);
	}
}
