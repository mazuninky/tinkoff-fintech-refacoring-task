package ru.tinkoff.fintech.refactoring

class PizzaCafe {
    private val cooker = PizzaMaker()
    private val barista = Barista()
    private var curOrderId = 0

    fun executeOrders(orders: Set<Pair<OrderType, String>>) {
        orders.map { (type, name) -> Order(++curOrderId, type, name) }.forEach { order -> executeOrder(order) }
    }

    private fun executeOrder(order: Order) {
        try {
            when (order.type) {
                OrderType.PIZZA -> cooker.makePizza(order)
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


private fun printLine() = print("\n\n---------------------------------------------------------\n\n")