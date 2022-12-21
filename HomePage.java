package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    public HomePage (WebDriver driver){
        super(driver);
    }

    By homePageTitleBy = By.xpath("//*[@id='header_container']/div[2]/span");
    By addToCartButton1By = By.id("add-to-cart-sauce-labs-backpack");
    By shoppingCartBadgeBy = By.className("shopping_cart_badge");
    By numberOfItemsBy = By.className("inventory_item");
    By hamburgerMenuBy = By.id("react-burger-menu-btn");
    By aboutButtonBy = By.id("about_sidebar_link");
    String expectedLink = "https://saucelabs.com/";



    By p1 = By.xpath("//*[@id='inventory_container']/div/div[1]/div[2]/div[2]/div");
    By p2 = By.xpath("//*[@id='inventory_container']/div/div[2]/div[2]/div[2]/div");
    By p3 = By.xpath("//*[@id='inventory_container']/div/div[3]/div[2]/div[2]/div");
    By p4 = By.xpath("//*[@id='inventory_container']/div/div[4]/div[2]/div[2]/div");
    By p5 = By.xpath("//*[@id='inventory_container']/div/div[5]/div[2]/div[2]/div");
    By p6 = By.xpath("//*[@id='inventory_container']/div/div[6]/div[2]/div[2]/div");
    By sortButton = By.xpath("//*[@id='header_container']/div[2]/div[2]/span/select");
    By lthButton = By.xpath("//*[@id='header_container']/div[2]/div[2]/span/select/option[3]");


    public HomePage verifySuccesfulLogin (String expectedText){
        String actualText = readText(homePageTitleBy);
        assertTextEquals(expectedText, actualText);
        return this;
    }

    public HomePage verifyProductAddedToCart() {
        click(addToCartButton1By);
        waitVisability(shoppingCartBadgeBy);
        return this;
    }

    public HomePage numberOfProducts (int expectedNumberOfProducts){
        int actualNumberOfProduct = countItems(numberOfItemsBy);
        assertIntegerEquals(expectedNumberOfProducts, actualNumberOfProduct);
        return this;
    }

    public HomePage clickOnHumburgerMenu(){
        click(hamburgerMenuBy);
        return this;
    }

    public HomePage verifyAboutLink(){
        String actualLink = readHref(aboutButtonBy);
        assertTextEquals(actualLink, expectedLink);
        return this;
    }


    
}
