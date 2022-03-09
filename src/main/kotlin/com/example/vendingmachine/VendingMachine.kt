package com.example.vendingmachine

class VendingMachine(val rows: Int, val columns: Int) {

    private var bin: String = ""
    private var insertedCurrency: Float = 0f
    private var display: String = ""
    private var selectedSlotId: String = ""
    private val slots: MutableMap<String, Slot> = HashMap()

    init {
        setupSlots()
    }

    fun initializeSlot(slotId: String, productName: String, productCost: Float) {
        slots[slotId] = Slot(productName, productCost, 0)
    }

    fun addProducts(slotId: String, productAmount: Int) {
        val existingProduct = slots[slotId]
        if (existingProduct != null) {
            slots[slotId] = existingProduct.copy(productAmount = productAmount)
        }
    }

    fun getSlot(slotId: String): Slot {
        return slots[slotId] ?: throw IllegalArgumentException("No slot for id $slotId")
    }

    fun insertCurrency(dollars: Float) {
        insertedCurrency = dollars
    }

    fun selectProduct(slotId: String) {
        selectedSlotId = slotId
        var selectedSlot = getSlot(slotId)
        if (insertedCurrency == 0f) {
            display = "\$${selectedSlot.productCost}"
        } else if (insertedCurrency < selectedSlot.productCost) {
            display = "Not enough $"
        } else {
            bin = selectedSlot.productName
            slots[selectedSlotId] = selectedSlot.copy(productAmount = selectedSlot.productAmount - 1)
            display = "Thank You!"
        }
    }

    fun getDisplay(): String {
        return display
    }

    fun getBin(): String {
        return bin
    }

    private fun setupSlots() {
        for (row: Int in 0..rows) {
            for (col: Int in 1..columns + 1) {
                slots["A${col}"] = Slot.empty()
            }
        }
    }
}
