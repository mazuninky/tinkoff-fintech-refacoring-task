package ru.tinkoff.fintech.refactoring

class Barista(
    private val coffeeMenu: Map<String, Coffee> = defaultCoffeeMenu
) {
    fun makeCoffee(order: Order) {
        val coffee = coffeeMenu[order.name] ?: error("Невозможно приготовить \"${order.name}\"")
        println("[Бариста] Готовлю напиток: ${order.name}")
        println("[Бариста] Время приготовления: ${coffee.brewTime} минут")
        val roundedPrice = "%.2f".format(coffee.price)
        println("[Бариста] Стоимость напитка: $roundedPrice$")
    }
}


private val defaultCoffeeMenu = listOf(
    Coffee("эспрессо", 5, 5.0),
    Coffee("капучино", 6, 3.48),
).associateBy { it.name }