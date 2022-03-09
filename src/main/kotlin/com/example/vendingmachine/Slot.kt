package com.example.vendingmachine

data class Slot(
    val productName: String,
    val productCost: Float,
    val productAmount: Int
) {

    companion object {
        fun empty(): Slot {
            return Slot("", 0f, 0)
        }
    }
}
