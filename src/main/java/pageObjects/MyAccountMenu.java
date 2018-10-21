package pageObjects;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.PageBase;

public class MyAccountMenu extends PageBase{
	
	@FindBy(xpath = "//div[text()='My Account']")
	private WebElement myAccount;
	
	@FindBy(xpath = "//div[text()='Wishlist']")
	private WebElement wishListOption;
	
	public MyAccountMenu(WebDriver driver) {
		super(driver);
	}

	public void goToWishListMenu() {
		hoverOnElement(myAccount);
		try {
			waitAndClick(wishListOption);
		}catch(StaleElementReferenceException e) {
			PageFactory.initElements(driver, MyAccountMenu.class);
		}
	}
}
