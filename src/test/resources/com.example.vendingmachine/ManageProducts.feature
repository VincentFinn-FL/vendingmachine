Feature: Manage Products

  Background:
    Given an empty vending machine with 3 rows and 3 columns

  # TODO: consider scenarios to capture all slot ids because we use that id later, so the id has business value to be correct
  Scenario: All slots are empty
    Then there are 3 rows and 3 columns of empty slots

  # TODO: reduce to 1 when
  Scenario Outline: Add Products To Vending Machine
    When I setup slot "<slotId>" to hold a product named "<productName>" that costs <productCost>
    And I add <productAmount> products to slot "<slotId>"
    Then <productAmount> products named "<productName>" that cost <productCost> dollars are in slot "<slotId>"

    Examples:
      | productName | productCost | productAmount | slotId
      | Chips       | 1.00        | 5             | A1
      | Pretzels    | 2.00        | 3             | C3