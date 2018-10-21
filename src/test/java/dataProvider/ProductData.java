package dataProvider;

import org.testng.annotations.DataProvider;

import constants.Constant;

public class ProductData {
	@DataProvider(name = Constant.TEST_PRODUCTS_DATA_PROVIDER)
	public static Object[][] loginCredentials() {
		 return new Object[][] { {"pallavihonagekar@gmail.com", "pallu@123", "Electronics", "Mi", "TVs & Appliances", "IFB", "TVs & Appliances", "Samsung"} };
	}
}
