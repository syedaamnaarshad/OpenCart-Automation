Feature: Checkout to place an order

  Background:
    Given  user navigates to login page
    When  user enters email as ameliasmith@example.com and password as Amelia123
    And  user clicks on the Login button
    Then  user should be redirected to My Account Page
    And  user enters Product as Macbook in Search Bar
    And  user clicks on the Search button
    And user selects Product MacBook Pro from List
    And user enters item quantity 1
    And user add the Product to Cart

    Scenario: Successful checkout with valid credentials
      Given user is on checkout page
      When user enters first name Amelia
      And user enters last name smith
      And user enters company name Automation House
      And user enters address1 abc street
      And user enters address2 abc road
      And user enters city London
      And user enters postcode 75678
      And user selects country United Kingdom
      And user selects state Greater London
      And user clicks continue for next step
      And user enter delivery details
      And user selects shipping method
      And user selects payment method
      And user clicks confirm order
      Then user should see order confirmation message