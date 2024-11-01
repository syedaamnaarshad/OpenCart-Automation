package org.store.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.store.base.BaseClass;

import java.util.List;

public class ShoppingCartPage extends BasePage {
    HomePage homePage;

    //Constructor
    public ShoppingCartPage(){
        super();
        this.homePage = new HomePage(); // Initialize HomePage
    }
    //Locators
    By itemInCartField= By.xpath("#shopping-cart tbody");
    By listOfItemsInCartField= By.cssSelector("#shopping-cart tbody>tr");
    By checkoutButton= By.linkText("Checkout");
    By removeItemField= By.cssSelector("button[aria-label='Remove']");
    By updateItemField= By.cssSelector("button[aria-label='Update']");
    By confirmationMessageField= By.cssSelector("#alert");
    By totalAmountField= By.xpath("//*[@id='checkout-total']/tr[4]/td[2]");


    //Methods

    public void itemsInCart(){
        WebElement parent= driver.findElement(itemInCartField);
        List <WebElement> items=parent.findElements(listOfItemsInCartField);
        for(WebElement list : items){
            System.out.println(list.getText());
        }
    }
    public void removeItemFromCart(){
        driver.findElement(removeItemField).click();
    }

    public void updateItemInCart(){
        driver.findElement(updateItemField).click();
    }

    public void clickCheckout(){
        driver.findElement(checkoutButton).click();
    }

    //method for confirmation message of update or removal of item
    public String cartConfirmationMessage(){
        WebElement confirmMsg= driver.findElement(confirmationMessageField);
        return confirmMsg.getText();
    }

    //get total amount
    public String getTotalAmount(){
        WebElement totalAmount= driver.findElement(totalAmountField);
        return totalAmount.getText();
    }
}
