Feature: Login with Valid Credentials

@001
  Scenario: Successful Login with Valid Credentials
    Given  user navigates to login page
    When  user enters email as "ameliasmith@example.com" and password as "Amelia123"
    And  user clicks on the Login button
    Then  user should be redirected to My Account Page

@002
  Scenario Outline:Unsuccessful Login with Incorrect/Empty Credentials
    Given user navigates to login page
    When user enters email as "<email>" and password as "<password>"
    And  user clicks on the Login button
    Then user should see warning alert
    And user should not be redirected to My Account Page

    Examples:
      | email         | password |
      | abc@gmail.com | Test@123 |
      | def@gmail.com | test@123 |
      | abc@gmail.com |          |
      |               | test@123 |
