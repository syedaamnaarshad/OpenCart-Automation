package org.store.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.store.base.BaseClass;

import java.time.Duration;

public class LoginPage extends BasePage {
    HomePage homePage;

    // Constructor
    public LoginPage() {
        super(); // Call the constructor of BasePage
        this.homePage = new HomePage(); // Initialize HomePage
    }

    // Define locators for the login page elements
    private By emailField = By.cssSelector("#input-email");
    private By passwordField = By.cssSelector("#input-password");
    private By loginButton = By.cssSelector("input[type='submit']");
    private By errorMessage= By.cssSelector(".alert");




    //Methods to enter details for login
    public void enterEmail(String email) {
        if (!email.isEmpty()) {
            driver.findElement(emailField).sendKeys(email);
        }
    }

    public void enterPassword(String password) {
        if (!password.isEmpty()) {
            driver.findElement(passwordField).sendKeys(password);
        }
    }

    public void clickLoginButton() {
        WebElement login= driver.findElement(loginButton);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(login));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", login);
    }

    //login method
    public void login(String email, String password) {
        homePage.clickMyAccount();
        homePage.openLoginPage();
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }

    //failed login message
    public Boolean isFailedLoginMessageDisplayed() {
        WebElement errorMessageText=driver.findElement(errorMessage);
        return errorMessageText.isDisplayed();
    }
}

