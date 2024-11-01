package org.store.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.store.base.BaseClass;

import java.time.Duration;

public class HomePage extends BasePage {

    //Constructor
    public HomePage(){
        super();
    }

    // Locators
    private By myAccountField = By.xpath("//span[contains(text(),'My Account')]");
    private By loginPageLink= By.linkText("Login");
    private By logoutButton= By.linkText("Logout");
    private By searchBar = By.cssSelector("input[name='search']");
    private By searchButton = By.cssSelector("#search  button");
    private By addToCartButton= By.cssSelector("#content > div.row > div:nth-child(1)  button:nth-child(1)");
    private By shoppingCartButton= By.linkText("Shopping Cart");
    private By addToWishlistButton= By.cssSelector("#content > div.row > div:nth-child(1)  button:nth-child(1) >i");


    //Methods for My Account tab
    public void clickMyAccount() {
        WebElement myAccount= driver.findElement(myAccountField);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(myAccount));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", myAccount);

    }

    public void openLoginPage() {
        WebElement login = driver.findElement(loginPageLink);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(login));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", login);
    }

    public void logout(){
        WebElement logout= driver.findElement(logoutButton);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(logout));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", logout);

    }
    // Method for searching product
    public void searchProduct(String productName) {
        WebElement search= driver.findElement(searchBar);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(search));
        // Scroll into view if needed
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", search);
        // Attempt to send keys
        search.sendKeys(productName);
    }

    public void clickSearchButton() {
        WebElement searchBtn= driver.findElement(searchButton);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 seconds wait
        wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
        searchBtn.click();
    }

    //navigate to cart page
    public void  openShoppingCart(){
        driver.findElement(shoppingCartButton).click();
    }
}
