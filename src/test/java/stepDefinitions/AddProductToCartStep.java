package stepDefinitions;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.store.pageObject.HomePage;
import org.store.pageObject.SearchProductPage;

public class AddProductToCartStep {
    SearchProductPage searchProductPage;
    HomePage homePage;

    @Given("^user is on Search Product (.*) Page$")
    public void user_is_on_Search_Product_page(String product) {
        homePage=new HomePage();
        searchProductPage =new SearchProductPage();
        System.out.println("On search Page");
    }

    @When("^user selects Product (.*) from List$")
    public void user_selects_Product_from_List(String product){
        searchProductPage=new SearchProductPage();
        searchProductPage.selectProduct(product);
    }

    @And("^user enters item quantity(.*)$")
    public void user_enters_item_quantity(String quantity){
        searchProductPage.setProductQuantity(quantity);
    }

    @And ("^user add the Product to Cart$")
    public void user_add_the_Product_to_Cart(){
        searchProductPage.addToCart();
    }

    @Then("^user should see confirmation message$")
    public void user_should_see_confirmation_message(){
//        String message= searchProductPage.confirmationMessage();
//        Assert.assertEquals("Success Message","Success: You have added MacBook Pro to your shopping cart!x",message);

        Assert.assertTrue(searchProductPage.isConfirmationMessageDisplayed());
    }
}
