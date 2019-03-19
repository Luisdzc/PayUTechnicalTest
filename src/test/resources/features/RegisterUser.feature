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