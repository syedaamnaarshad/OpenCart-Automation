package org.store.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.store.base.BaseClass;

import java.time.Duration;

public class CheckoutPage extends BasePage {

    //Constructor
    public CheckoutPage(){
        super();
    }

    //Defining Locators
    By billingDetailField= By.cssSelector("input[value='new']");
    By firstNameField= By.cssSelector("#input-payment-firstname");
    By lastNameField= By.cssSelector("#input-payment-lastname");
    By addressField1= By.cssSelector("#input-payment-address-1");
    By addressField2= By.cssSelector("#input-payment-address-2");
    By companyField= By.cssSelector("#input-payment-company");
    By cityField= By.cssSelector("#input-payment-city");
    By postCodeField= By.cssSelector("#input-payment-postcode");
    By countryField= By.cssSelector("#input-payment-country");
    By stateField= By.cssSelector("#input-payment-zone");
    By continueButtonField= By.cssSelector("#button-payment-address.btn");
    By deliveryDetailField= By.xpath("//*[@id='collapse-shipping-address']/div/form/div[1]/label/input");
    By continueToDeliveryMethodField= By.cssSelector("#button-shipping-address.btn");
    By continueShippingMethodField= By.cssSelector("#button-shipping-method.btn");
    By termsAndConditionField= By.xpath("//*[@id='collapse-payment-method']/div/div[2]/div/input[1]");
    By continuePaymentMethodField= By.cssSelector("input#button-payment-method");
    By totalPriceField= By.xpath("//*[@id='collapse-checkout-confirm']/div/div[1]/table/tfoot/tr[5]/td[2]");
    By confirmOrderField= By.cssSelector("input#button-confirm");
    By confirmationMessageField= By.cssSelector("#content>h1");



    //Methods to fill checkout form
    public void selectNewBillingAddress(){
        driver.findElement(billingDetailField).click();
    }
    public void setFirstName(String firstName) {
        WebElement firstname= driver.findElement(firstNameField);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(firstname));
        firstname.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void setAddress1(String address1) {
        driver.findElement(addressField1).sendKeys(address1);
    }

    public void setAddress2(String address2) {
        driver.findElement(addressField2).sendKeys(address2);
    }

    public void setCompany(String company) {
        driver.findElement(companyField).sendKeys(company);
    }

    public void setPostCode(String postcode) {
        driver.findElement(postCodeField).sendKeys(postcode);
    }

    public void setCity(String city) {
        driver.findElement(cityField).sendKeys(city);
    }

    public void setCountry(String Country) {
        WebElement country= driver.findElement(countryField);
        new Select(country).selectByVisibleText(Country);
    }

    public void setState(String State) {
        WebElement state= driver.findElement(stateField);
        new Select(state).selectByVisibleText(State);
    }

    public void clickOnContinueAfterShippingAddress() {
        driver.findElement(continueButtonField).click();
    }

    public void selectDeliveryAddress(){
        driver.findElement(deliveryDetailField).click();
    }

    public void clickOnContinueAfterDeliveryAddress() {
        driver.findElement(continueToDeliveryMethodField).click();
    }


    public void clickOnContinueAfterShippingMethod() {
      driver.findElement(continueShippingMethodField).click();
    }

    public void setPaymentMethod() {
        driver.findElement(termsAndConditionField).click();
        driver.findElement(continuePaymentMethodField).click();
    }

    public String getTotalPriceBeforeConfOrder() {
        WebElement totalPrice= driver.findElement(totalPriceField);
        return totalPrice.getText();
    }

    public void clickConfirmOrder() {
        driver.findElement(confirmOrderField).click();
    }

    public Boolean isOrderConfirmationMessageDisplayed(){
        WebElement actualMessage= driver.findElement(confirmationMessageField);
        return  actualMessage.isDisplayed();
    }
}
