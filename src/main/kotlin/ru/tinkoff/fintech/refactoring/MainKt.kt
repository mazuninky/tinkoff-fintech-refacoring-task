package ru.tinkoff.fintech.refactoring

import ru.tinkoff.fintech.refactoring.OrderType.COFFEE
import ru.tinkoff.fintech.refactoring.OrderType.PIZZA

fun main() {

    val pizzaCafe = PizzaCafe()

    val order = setOf(
        PIZZA to "карбонара",
        PIZZA to "сардиния",
        COFFEE to "эспрессо",
        COFFEE to "эспрессо".reversed(),
    )

    pizzaCafe.executeOrders(order)

}