package com.example.vendingmachine

import assertk.assert
import assertk.assertions.isEqualTo
import assertk.assertions.isTrue
import io.cucumber.java8.En

class VendingMachineSteps : En {
    private lateinit var vendingMachine: VendingMachine

    init {
        Given("a display on the vending machine") {
            vendingMachine = VendingMachine()
        }
        Then("it displays $0.00 dollars") {
            assert(vendingMachine.displayValue).isEqualTo("$0.00")
        }
        Given("a vending machine") {
            vendingMachine = VendingMachine()
        }
        Then("the vending machine is empty") {
            assert(vendingMachine.isEmpty).isTrue()
        }
    }
}
