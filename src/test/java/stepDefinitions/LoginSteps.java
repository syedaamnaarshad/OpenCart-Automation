package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.store.pageObject.HomePage;
import org.store.pageObject.LoginPage;
import org.store.pageObject.MyAccountPage;

import java.sql.DriverManager;

public class LoginSteps {

    private HomePage homePage;
    private LoginPage loginPage;
    private MyAccountPage myAccountPage;


    @Given("^user navigates to login page$")
    public void user_navigates_to_login_page() {
        homePage=new HomePage();
        homePage.clickMyAccount();
        homePage.openLoginPage();
    }

    @When("^user enters email as (.*) and password as (.*)$")
    public void user_enters_email_and_password(String email, String pwd) {
        loginPage=new LoginPage();
        loginPage.enterEmail(email);
        loginPage.enterPassword(pwd);
    }

    @When("^user clicks on the Login button$")
    public void user_click_on_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("^user should be redirected to My Account Page$")
    public void user_should_navigate_to_my_account_page() {
        myAccountPage=new MyAccountPage();
        boolean currentPage= myAccountPage.isMyAccountPageDisplayed();
        Assert.assertTrue(currentPage);
    }

//    @Then("^user should see logout option$")
//    public void user_should_see_logout_option() {
//        boolean logoutButton= myAccountPage.isLogoutButtonDisplayed();
//        Assert.assertTrue(logoutButton);
//    }

    @Then("^user should see warning alert$")
    public void user_should_see_warning_alert() {
        loginPage=new LoginPage();
        Assert.assertTrue(loginPage.isFailedLoginMessageDisplayed());
    }

    @Then("^user should not be redirected to My Account Page$")
    public void user_should_not_navigate_to_my_account_page() {
        myAccountPage=new MyAccountPage();
        boolean currentPage= myAccountPage.isMyAccountPageDisplayed();
        Assert.assertTrue(currentPage);
    }


}
