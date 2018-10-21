package basePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import constants.Constant;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountMenu;
import pageObjects.ProductsPage;
import pageObjects.WishListPage;

public class TestBase {
	protected WebDriver driver;
	protected LoginPage loginPage;
	protected HomePage homePage;
	protected ProductsPage products;
	protected MyAccountMenu myAccount;
	protected WishListPage myWishList;
	
	@BeforeMethod
	public void setUp(ITestContext context) {
		System.setProperty("webdriver.gecko.driver", Constant.GECKO_DRIVER);
		driver = new FirefoxDriver();
		driver.get(Constant.URL_SIGN_IN);
		driver.manage().window().maximize();	
		context.setAttribute(Constant.DRIVER, driver);
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		homePage = PageFactory.initElements(driver, HomePage.class);
		products = PageFactory.initElements(driver, ProductsPage.class);
		myAccount = PageFactory.initElements(driver, MyAccountMenu.class);
		myWishList = PageFactory.initElements(driver, WishListPage.class);
		
	}
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
}
