package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.store.pageObject.HomePage;
import org.store.pageObject.LoginPage;
import org.store.pageObject.MyAccountPage;
import org.store.pageObject.SearchProductPage;

import java.sql.SQLOutput;

import static org.store.base.BaseClass.driver;

public class SearchProductSteps {
    private HomePage homePage;
    private SearchProductPage searchProductPage;

    @Given("user navigates to Home Page")
    public void user_navigates_to_home_page() {
        System.out.println("On Homepage");
    }

    @When("^user enters Product as (.*) in Search Bar$")
    public void user_enters_Product_name_in_Search_Bar(String product){
        homePage=new HomePage();
        homePage.searchProduct(product);
    }

    @And("^user clicks on the Search button$")
    public void user_clicks_on_the_Search_button(){
        homePage.clickSearchButton();
    }

    @Then("^user should be redirected to My Search Product Page$")
    public void user_should_be_redirected_to_My_Search_Product_Page() throws InterruptedException {
        searchProductPage=new SearchProductPage();
        System.out.println(searchProductPage.searchPageHeaderText());
        Thread.sleep(1000);
        Assert.assertTrue(searchProductPage.isSearchPageOpen());
        Assert.assertEquals("Page Header","Products meeting the search criteria",searchProductPage.searchPageHeaderText());
    }
}
