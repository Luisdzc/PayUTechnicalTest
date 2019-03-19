Feature: Register user in automationpractice.com

  Background: User is in the main page
    Given the user is in the page "http://automationpractice.com"
      And the user clicks in the sing in option
  
  Scenario: Register a new user in the platform
    Given the user wants to register in the platform with the next data
      | name     | lastName | password | address        | city   | state   | postalCode | mobilPhone | 
      | testUser | testing  | QWERTY   | testingAddress | bogota | Alabama | 12345      | 33141341   | 
     When the user selects the register option
     Then the user is redirected to the account user page
      And the user name "testUser testing" is displayed in the head tool bar
  
  Scenario: Register user already registered
    Given a user that wants to sign in with the email "test@test.com"
     When the user selects create an account button
     Then the "An account using this email address has already been registered" message should be displayed
      And the page keeps in the sign in page
  
  Scenario: Register user with a wrong email
    Given a user that wants to sign in with the email "wrongemail.test.com"
     When the user selects create an account button
     Then the "Invalid email address" message should be displayed
      And the page keeps in the sign in page
  
  Scenario: Register a user without a mandatory field
    Given the user wants to register in the platform with the next data
      | name     | lastName | password | address | city   | state   | postalCode | mobilPhone | 
      | testUser | testing  | QWERTY   |         | bogota | Alabama | 12345      | 33141341   | 
     When the user selects the register option
     Then the register should fail showing an alert indicating the missing field "address"
  
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
  
