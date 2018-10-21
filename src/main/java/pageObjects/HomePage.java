package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import basePackage.PageBase;

public class HomePage extends PageBase{
	@FindBy(xpath = "//ul[contains(@class,'_114Zhd')]/li")
	private List<WebElement> categoriesList;
	
	
	@FindBy(xpath = "//li[contains(@class,'_2GG4xt')]/ul/li[2]/a")
	private WebElement subCategory;
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public void selectCategory() {
		for(WebElement category : categoriesList) {
			waitForElementToBeVisible(category);
			hoverOnElement(category);
			waitAndClick(subCategory);
			break;
		}
	}
}

