package pageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import basePackage.PageBase;

public class WishListPage extends PageBase {

	@FindBy(xpath = "//div[contains(@class,'_2W9EDl')]")
	private List<WebElement> allProducts;
	
	By allProductsLocator = By.xpath("//div[contains(@class,'_2W9EDl')]");
	By productName = By.xpath("//div[contains(@class,'TLVGit')]");
			
	@FindBy(xpath = "//div[contains(@class,'TLVGit')]")
	private List<WebElement> productNameElements;
	
	public WishListPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean checkMyWishList(String myWishListItem) {
		waitForAllElementsToPresent(allProductsLocator);
		for(WebElement productNameElement : productNameElements) {
			String productName = waitAndGetText(productNameElement);
			//System.out.println(productName + myWishListItem);
			if(productName.equals(myWishListItem)) {
				return true;
			}
		}
		return false;
	}
}
