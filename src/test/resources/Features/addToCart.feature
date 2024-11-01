Feature: Add Products to Cart

  Background:
    Given  user navigates to login page
    When  user enters email as ameliasmith@example.com and password as Amelia123
    And  user clicks on the Login button
    Then  user should be redirected to My Account Page
    And  user enters Product as Macbook in Search Bar
    And  user clicks on the Search button

    Scenario: Add the Product to Cart successfully
      Given user is on Search Product Macbook Page
      When user selects Product MacBook Pro from List
      And user enters item quantity 1
      And user add the Product to Cart
      Then user should see confirmation message

