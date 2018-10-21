package pageObjects;

import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import basePackage.PageBase;

public class ProductsPage extends PageBase{
//	@FindBy(xpath = "//div[contains(@class,'_1OCn9C')]")
//	private List<WebElement> productImages;
	
//	@FindBy(xpath = "//div[contains(@class,'DsQ2eg')]")
//	private List<WebElement> wishListIcons;
	
	By detailsOfAllProducts = By.xpath("//div[@class='_1UoZlX']");
	By wishListIcon = By.xpath("//div[contains(@class,'DsQ2eg')]");
	
	@FindBy(xpath = "//div[contains(@class,'_3wU53n')]")
	private WebElement productName;
	

	
	public ProductsPage(WebDriver driver) {
		super(driver);
	}
	
	public String addToWishList() {
		waitForAllElementsToPresent(detailsOfAllProducts);
		for(WebElement productDetails : driver.findElements(detailsOfAllProducts)) {
			waitForElementToBeVisible(productDetails);
			waitAndClick(productDetails.findElement(wishListIcon));
			return waitAndGetText(productName);
		}
		return null;
	}
}


//itemimages visible   //div[contains(@class,'_1OCn9C')]
//wishlist symbols clickable //div[contains(@class,'DsQ2eg')]