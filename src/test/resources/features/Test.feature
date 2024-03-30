Feature: Login Sauce Demo

  Scenario: Login scenario sauce demo
    When User is on login page
    And User fill username with "standard_user"
    And User fill password with "secret_sauce"
    And User click login
    Then User is on shopping page

  Scenario: Login with incorrect credentials
    Given User is on login page
    And User fill username with "fikri"
    And User fill password with "secret_sauce"
    And User click login
    Then User get error
