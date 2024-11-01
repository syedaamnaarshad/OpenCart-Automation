package org.store.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage extends BasePage{
    HomePage homePage;

    //Constructor
    public MyAccountPage(){
        super();
        this.homePage = new HomePage(); // Initialize HomePage
    }

    //defining locators
    private By pageHeadingField= By.cssSelector("#content h2:nth-child(1)");
    private By logoutButton= By.linkText("Logout");
    private By homeButton= By.xpath("//*[@id='account-account']/ul/li[1]/a/i");


    // MyAccount Page heading display status
    public boolean isMyAccountPageDisplayed(){
        WebElement pageHeading=driver.findElement(pageHeadingField);
        try {
            return (pageHeading.isDisplayed());
        } catch (Exception e) {
            return (false);
        }
    }
    //logout button is displayed
    public  boolean isLogoutButtonDisplayed() {
        homePage.clickMyAccount();
        WebElement logout = driver.findElement(logoutButton);
        try {
            return logout.isDisplayed();
        } catch (Exception e) {
            return (false);
        }
    }

    //navigate to home page
    public void clickHomeButton(){
        driver.findElement(homeButton).click();
    }
}
