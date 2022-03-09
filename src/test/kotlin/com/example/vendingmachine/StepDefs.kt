package com.example.vendingmachine

import assertk.assert
import assertk.assertions.isEqualTo
import io.cucumber.java8.En

typealias SlotId = String

class ManageProductsSteps : En {
    val selectedSlotId = "A1"
    val selectedProductCost = 1.25f

    private lateinit var vendingMachine: VendingMachine

    init {
        Given("an empty vending machine with 3 rows and 3 columns") {
            vendingMachine = VendingMachine(3, 3)
        }

        //region ManageProducts.feature

        When("I setup slot {string} to hold a product named {string} that costs {float}")
        { slotId: String, productName: String, productCost: Float ->
            vendingMachine.initializeSlot(slotId, productName, productCost)
        }

        When("I add {int} products to slot {string}") { productAmount: Int, slotId: String ->
            vendingMachine.addProducts(slotId, productAmount)
        }

        Then("there is an empty slot {string}") { slotId: String ->
            val slot = vendingMachine.getSlot(slotId)
            assert(slot.productAmount).isEqualTo(0)
        }

        Then("{int} products named {string} that cost {float} dollars are in slot {string}")
        { productAmount: Int, productName: String, productCost: Float, slotId: String ->
            val slot = vendingMachine.getSlot(slotId)
            assert(slot.productName).isEqualTo(productName)
            assert(slot.productCost).isEqualTo(productCost)
            assert(slot.productAmount).isEqualTo(productAmount)
        }

        //endregion

        //region InsertCurrency.feature

        When("I insert money") {
            vendingMachine.insertCurrency(1.25f)
        }

        Then("the display shows money inserted") {
            assert(vendingMachine.getDisplay()).isEqualTo("$1.25")
        }

        //endregion

        //region SelectProduct.feature

        Given("a product in the machine") {
            vendingMachine.initializeSlot(selectedSlotId, "product", selectedProductCost)
            vendingMachine.addProducts(selectedSlotId, 1)
        }

        When("I select the product") {
            vendingMachine.selectProduct(selectedSlotId)
        }

        When("I insert enough money") {
            vendingMachine.insertCurrency(selectedProductCost)
        }

        When("I insert not enough money") {
            vendingMachine.insertCurrency(selectedProductCost - 0.01f)
        }

        Then("the product is not dropped into the bin") {
            assert(vendingMachine.getBin()).isEqualTo("")
        }

        Then("the product is dropped into the bin") {
            val selectedProduct = vendingMachine.getSlot(selectedSlotId)
            assert(selectedProduct.productAmount).isEqualTo(0)
            assert(vendingMachine.getBin()).isEqualTo("product")
        }

        Then("display the cost of the product") {
            assert(vendingMachine.getDisplay()).isEqualTo("$1.25")
        }

        Then("display {string}") { expectedMessage: String ->
            assert(vendingMachine.getDisplay()).isEqualTo(expectedMessage)
        }

        //endregion
    }
}
