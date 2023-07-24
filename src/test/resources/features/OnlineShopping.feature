Feature: Online Shopping
  User Story: User should be able to add items on the shop page and remove them on the cart page

  Scenario: Add and remove items and check them
    Given I add four random items to my cart
    When I view my cart
    Then I find total four items listed in my cart
    When I search for lowest price item
    And I am able to remove the lowest price item from my cart
    Then I am able to verify three items in my cart
