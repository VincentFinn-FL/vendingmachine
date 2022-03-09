Feature: Select Product

  Background:
    Given an empty vending machine with 3 rows and 3 columns

  Scenario: Select a product when no money inserted
    Given a product in the machine
    When I select the product
    Then display the cost of the product
    And the product is not dropped into the bin

  Scenario: Select a product when exact cost inserted
    Given a product in the machine
    And I insert enough money
    When I select the product
    Then display "Thank You!"
    And the product is dropped into the bin

  Scenario: Select a product when not enough money inserted
    Given a product in the machine
    And I insert not enough money
    When I select the product
    Then display "Not enough $"
    And the product is not dropped into the bin

  #TODO: Sold out