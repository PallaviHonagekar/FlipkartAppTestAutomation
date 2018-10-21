package pageObjects;

import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.PageBase;

public class ProductsPage extends PageBase{
//	@FindBy(xpath = "//div[contains(@class,'_1OCn9C')]")
//	private List<WebElement> productImages;
	
//	@FindBy(xpath = "//div[contains(@class,'DsQ2eg')]")
//	private List<WebElement> wishListIcons;
	
	By detailsOfAllProducts = By.xpath("//div[@class='_1UoZlX']");
	
	@FindBy(xpath = "//div[@class='_3gDSOa _32A6AP']")
	private List<WebElement> wishListIconList;
	

	@FindBy(xpath="//div[@class='_3gDSOa _32A6AP']//parent::div/following-sibling::div//div[contains(@class,'_3wU53n')]")
	private List<WebElement> productNameList;
	
	public ProductsPage(WebDriver driver) {
		super(driver);
	}
	
	public String addToWishList() {
		String wishListProductName = null;
		try {
			waitForAllElementsToPresent(detailsOfAllProducts);
			AllProductDetails:
			for(WebElement wishListIcon : wishListIconList) {
				for(WebElement productName : productNameList) {
					wishListProductName = waitAndGetText(productName);
					waitAndClick(wishListIcon);
					break AllProductDetails;

				}
			}
		}catch(TimeoutException ex) {
			PageFactory.initElements(driver, ProductsPage.class);
		}
		return wishListProductName;
	}
}

//div[contains(@class,'_3liAhj _1R0K0g')]//a[@class='_2cLu-l']
