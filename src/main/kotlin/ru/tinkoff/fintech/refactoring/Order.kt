package ru.tinkoff.fintech.refactoring

data class Order(
    val orderId: Int,
    val type: OrderType,
    val name: String,
)

enum class OrderType {
    PIZZA,
    COFFEE,
}