package ru.tinkoff.fintech.refactoring

data class Order(
    val type: OrderType,
    val name: String,
    val orderId: Int,
)

enum class OrderType {
    PIZZA,
    COFFEE,
}

class PizzaCafe {
    private val cooker = Cooker()
    private val barista = Barista()
    private var curOrderId = 0

    fun order(orderType: OrderType, name: String): Order {
        val number = curOrderId++
        return Order(orderType, name, number)
    }

    fun executeOrder(orders: Set<Order>) {
        orders.forEach { order ->
            try {
                when (order.type) {
                    OrderType.PIZZA -> cooker.cook(order)
                    OrderType.COFFEE -> barista.makeCoffee(order)
                }
            } catch (e: IllegalStateException) {
                printLine()
                println(e.message)
                println("Невозможно продолжить выполнение заказа ${order.orderId}")
                printLine()
            }
        }
    }
}


private fun printLine() = print("\n\n---------------------------------------------------------\n\n")