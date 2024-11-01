Feature: Search Product
  Background
    Given  user navigates to login page
    When  user enters email as "ameliasmith@example.com" and password as "Amelia123"
    And  user clicks on the Login button
    Then  user should be redirected to My Account Page


  Scenario: Search Product in Search Bar
    Given  user navigates to Home Page
    When  user enters Product as Macbook in Search Bar
    And  user clicks on the Search button
    Then  user should be redirected to My Search Product Page