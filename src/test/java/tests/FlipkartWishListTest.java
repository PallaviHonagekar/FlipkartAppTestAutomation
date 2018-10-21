package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import basePackage.TestBase;
import constants.Constant;
import dataProvider.LoginData;

public class FlipkartWishListTest extends TestBase{
	@Test(dataProvider = Constant.LOGIN_DATA_PROVIDER, dataProviderClass = LoginData.class)
	 public void testWishListItems(String email, String password) {
		 loginPage.login(email, password);
		 homePage.selectCategory();
		 String myWishListItem = products.addToWishList();
		 myAccount.goToWishListMenu();
		 Assert.assertTrue(myWishList.checkMyWishList(myWishListItem));
	 }
}
