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

    //region Overrides

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Slot

        if (productName != other.productName) return false
        if (productCost != other.productCost) return false
        if (productAmount != other.productAmount) return false

        return true
    }

    override fun hashCode(): Int {
        var result = productName.hashCode()
        result = 31 * result + productCost.hashCode()
        result = 31 * result + productAmount
        return result
    }

    //endregion
}
