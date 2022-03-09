Feature: Insert Currency

  Background:
    Given an empty vending machine with 3 rows and 3 columns

  Scenario: Insert money into the machine
    When I insert money
    Then the display shows money inserted

  #TODO: insert multiple currency, in unit test
  #TODO: change reflect the value needed of adding individual coins and bills