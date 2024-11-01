package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.checkerframework.checker.units.qual.C;
import org.junit.Assert;
import org.store.pageObject.CheckoutPage;
import org.store.pageObject.HomePage;
import org.store.pageObject.ShoppingCartPage;

public class CheckoutStep {
    private HomePage homePage;
    private CheckoutPage checkoutPage;
    private ShoppingCartPage shoppingCartPage;

    @Given("^user is on checkout page$")
    public void user_is_on_checkout_page(){
        homePage=new HomePage();
        checkoutPage=new CheckoutPage();
        shoppingCartPage=new ShoppingCartPage();
        homePage.openShoppingCart();
        shoppingCartPage.clickCheckout();
    }
    @When("^user enters first name(.*)$")
    public void user_enters_first_name(String firstname){
        checkoutPage.selectNewBillingAddress();
        checkoutPage.setFirstName(firstname);
    }

    @When("^user enters last name(.*)$")
    public void user_enters_last_name(String lastname){
        checkoutPage.setLastName(lastname);
    }

    @And("^user enters company name(.*)$")
    public void user_enters_company_name(String company){
        checkoutPage.setCompany(company);
    }

    @And("^user enters address1(.*)$")
    public void user_enters_address1(String address){
        checkoutPage.setAddress1(address);
    }

    @And("^user enters address2(.*)$")
    public void user_enters_address2(String address){
        checkoutPage.setAddress2(address);
    }

    @And("^user enters city(.*)$")
    public void user_enters_city(String city){
        checkoutPage.setCity(city);
    }

    @And("^user enters postcode(.*)$")
    public void user_enters_postcode(String postcode){
        checkoutPage.setPostCode(postcode);
    }

    @And("^user selects country(.*)$")
    public void user_selects_country(String country){
        checkoutPage.setCountry(country);
    }

    @And("^user selects state(.*)$")
    public void user_selects_state(String state){
        checkoutPage.setState(state);
    }

    @And("^user clicks continue for next step$")
    public void user_clicks_continue_for_next_step(){
        checkoutPage.clickOnContinueAfterShippingAddress();
    }

    @And("^user enter delivery details$")
    public void user_enter_delivery_details(){
        checkoutPage.clickOnContinueAfterDeliveryAddress();
    }

    @And("^user selects shipping method$")
    public void user_selects_shipping_method() throws InterruptedException {
        Thread.sleep(2000);
        checkoutPage.clickOnContinueAfterShippingMethod();
    }

    @And("^user selects payment method$")
    public void user_selects_payment_method() throws InterruptedException {
        Thread.sleep(2000);
        checkoutPage.setPaymentMethod();
    }

    @And("^user clicks confirm order$")
    public void user_clicks_confirm_order() throws InterruptedException {
        Thread.sleep(2000);
        checkoutPage.clickConfirmOrder();
    }

    @Then("^user should see order confirmation message$")
    public void user_should_see_order_confirmation_message() throws InterruptedException {
        Assert.assertTrue(checkoutPage.isOrderConfirmationMessageDisplayed());
        Thread.sleep(3000);
    }
}
