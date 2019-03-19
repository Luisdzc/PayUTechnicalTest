Feature: Add products to the shopping cart

  Background: User is in the main page
    Given the user is in the page "http://automationpractice.com"



  Scenario: Add one product to the shopping cart
    Given the user selects the first product for add it to the shopping cart
    When the user clicks on add to cart
    Then the successfully added message "Product successfully added to your shopping cart" should be displayed
    And the information of the product should be the same of the selected product


  Scenario: Add an already added product to the shopping cart
    Given the user selects the first product for add it to the shopping cart
    And the user clicks on add to cart
    When the user adds the already added product to the cart
    Then the successfully added message "Product successfully added to your shopping cart" should be displayed
    And the shopping cart has "2" entries


  Scenario: Delete product from shopping cart
    Given the user selects the first product for add it to the shopping cart
    And the user clicks on add to cart
    And the user goes to the shopping cart page
    When the user selects delete item
    Then the shopping car should have a "empty" message
