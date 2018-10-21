package pageObjects;

import java.util.List;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.PageBase;

public class HomePage extends PageBase{
	@FindBy(xpath = "//ul[contains(@class,'_114Zhd')]/li")
	private List<WebElement> categoriesList;
	
	
	@FindBy(xpath = "//li[contains(@class,'_2GG4xt')]/ul/li/a")
	private List<WebElement> subCategoryList;
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public void selectCategory(String categoryName, String subCategoryName) {
		try {
			allCategories:
			for(WebElement category : categoriesList) {
				String thisCategory = waitAndGetText(category).toLowerCase();
				if(thisCategory.equals(categoryName)) {
					hoverOnElement(category);
					for(WebElement subCategory : subCategoryList) {
						String thisSubCategory = waitAndGetText(subCategory).toLowerCase();
						if(thisSubCategory.equals(subCategoryName)) {
							waitAndClick(subCategory);
							break allCategories;
						}
					}
				}
			}
		}catch(TimeoutException ex) {
			PageFactory.initElements(driver, HomePage.class);
		}
	}
}

