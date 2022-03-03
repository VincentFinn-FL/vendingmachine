Feature: Vending machine

  Scenario: Display Zero dollars
    Given a display on the vending machine
    Then it displays $0.00 dollars

  Scenario: Empty vending machine
    Given a vending machine
    Then the vending machine is empty