Feature: Buy a product

  Background: User is in the main page
    Given the user is in the page "http://automationpractice.com"

  Scenario: Buy a product without logging into the platform
    Given the user selects the first product for add it to the shopping cart
    And the user clicks on add to cart
    And the user goes to the shopping cart page
    When the user clicks in the checkout option
    Then the sign in page should be displayed


  Scenario: Buy a product with user logged into the platform
    Given the user is logged into the platform with the data
      | email                 | password |
      | testExample@gmail.com | QWERTY   |
    And the user selects the first product for add it to the shopping cart
    And the user clicks on add to cart
    And the user goes to the shopping cart page
    When the user clicks in the checkout option
    Then the address details should be displayed


  Scenario: Buy a product complete flow
    Given the user is logged into the platform with the data
      | email                 | password |
      | testExample@gmail.com | QWERTY   |
    And the user selects the first product for add it to the shopping cart
    And the user clicks on add to cart
    And the user goes to the shopping cart page
    And the user execute all the checkout states
    When the user execute the payment
    Then the successfully buy message "Your order on My Store is complete." should be displayed
