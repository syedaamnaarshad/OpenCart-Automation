package org.store.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.store.base.BaseClass;

import java.time.Duration;
import java.util.List;

public class SearchProductPage extends BasePage {

    //Constructor
    public SearchProductPage(){
        super();
    }

    //Locators for searched product
    By pageHeaderField=By.cssSelector("#content>h2");
    By allProductListField=By.cssSelector("#content img");
    By productQuantityField= By.cssSelector("#input-quantity");
    By addToCartButton= By.cssSelector("#button-cart.btn");
    By addToWishlistButton= By.cssSelector("button[data-original-title='Add to Wish List']");
    By confirmationMessageField= By.xpath("//div[contains(text(),'Success: You have added')]");


    //Methods:

    //function to select single product from searched list
    public void selectProduct(String productName) {
        List <WebElement> productList= driver.findElements(allProductListField);
        for(WebElement product:productList)
        {
            if(product.getAttribute("title").equals(productName))
            {
                product.click();
            }
        }

    }

    // add product to cart
    public void addToCart(){
        driver.findElement(addToCartButton).click();
    }

    //add product to wishlist
    public void addToWishlist(){
        driver.findElement(addToWishlistButton).click();
    }

    //set product quantity to add to cart
    public void setProductQuantity(String quantity){
        WebElement productQty= driver.findElement(productQuantityField);
        productQty.clear();
        productQty.sendKeys(quantity);
    }

    //confirmation message for adding to cart or wishlist
    public String confirmationMessage(){
        WebElement confirmationMessage=driver.findElement(confirmationMessageField);
        return confirmationMessage.getText();
    }

    public boolean isConfirmationMessageDisplayed(){
        WebElement confirmationMessage=driver.findElement(confirmationMessageField);
        return confirmationMessage.isDisplayed();
    }

    //confirmation of opening of searched product page by checking header text
    public String searchPageHeaderText() {
        WebElement pageHeader = driver.findElement(pageHeaderField);
            return pageHeader.getText();
    }
    //confirmation of searched product page is opened
    public boolean isSearchPageOpen() {
        WebElement pageHeader = driver.findElement(pageHeaderField);
        return pageHeader.isDisplayed();
    }
}
