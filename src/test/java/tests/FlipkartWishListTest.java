package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import basePackage.TestBase;
import constants.Constant;
import dataProvider.ProductData;

public class FlipkartWishListTest extends TestBase{
	@Test(dataProvider = Constant.TEST_PRODUCTS_DATA_PROVIDER, dataProviderClass = ProductData.class)
	 public void testWishListItems(String email, String password, String category1, String subCategory1, String category2,
			 String subCategory2, String category3, String subCategory3) {
		 loginPage.login(email, password);
		 homePage.selectCategory(category1.toLowerCase(), subCategory1.toLowerCase());
		 String myWishListItem1 = products.addToWishList();
		 myAccount.goToWishListMenu();
		 Assert.assertTrue(myWishList.checkMyWishList(myWishListItem1.toLowerCase()), "Product1 not added to wishlist");
		 
		 homePage.selectCategory(category2.toLowerCase(), subCategory2.toLowerCase());
		 String myWishListItem2 = products.addToWishList();
		 myAccount.goToWishListMenu();
		 Assert.assertTrue(myWishList.checkMyWishList(myWishListItem2.toLowerCase()), "Product2 not added to wishlist");
		 
		 homePage.selectCategory(category3.toLowerCase(), subCategory3.toLowerCase());
		 String myWishListItem3 = products.addToWishList();
		 myAccount.goToWishListMenu();
		 Assert.assertTrue(myWishList.checkMyWishList(myWishListItem3.toLowerCase()), "Product3 not added to wishlist");
	 }
}
