package com.heb.design_pattern_practice

class CartManager {

    private val cartMap = mutableMapOf<String, Int>()

    fun addToCart(item: String) {
        if (cartMap.containsKey(item)) {
            cartMap[item] = cartMap[item]?.plus(1) ?: 1
        } else cartMap[item] = 1
    }

    fun getQuantity(item: String): Int? = cartMap[item]

    fun bulkAdd(items: ArrayList<String>) {
        items.forEach {
            addToCart(
                it
            )
        }
    }
}

class ClassRepository(private val cartManager: CartManager) {

    fun addToCart(item: String) {
        cartManager.addToCart(item)
    }

    fun getQuantity(item: String) = cartManager.getQuantity(item)


    fun bulkAdd(items: ArrayList<String>) {
        cartManager.bulkAdd(items)
    }
}