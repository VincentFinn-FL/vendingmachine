Feature: Manage Products

  Background:
    Given an empty vending machine with 3 rows and 3 columns

  # TODO: consider scenarios to capture all slot ids because we use that id later, so the id has business value to be correct
  Scenario Outline: All slots are empty
    Then there is an empty slot "<slotId>"
    Examples:
      | slotId |
      | A1     |
      | A2     |
      | A3     |
      | B1     |
      | B2     |
      | B3     |
      | C1     |
      | C2     |
      | C3     |

  # TODO: reduce to 1 when
  Scenario Outline: Add Products To Vending Machine
    When I setup slot "<slotId>" to hold a product named "<productName>" that costs <productCost>
    And I add <productAmount> products to slot "<slotId>"
    Then <productAmount> products named "<productName>" that cost <productCost> dollars are in slot "<slotId>"

    Examples:
      | productName | productCost | productAmount | slotId
      | Chips       | 1.00        | 5             | A1
      | Pretzels    | 2.00        | 3             | C3