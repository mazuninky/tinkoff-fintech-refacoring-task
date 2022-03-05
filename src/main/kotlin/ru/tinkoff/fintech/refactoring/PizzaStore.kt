package ru.tinkoff.fintech.refactoring
interface Order{}
data class PizzaOrder(
    val number: Int,
    val pizza: Pizza,
) : Order

data class CoffeeOrder(
    val number: Int,
    val coffee: Coffee,
):Order

class PizzaStore {
    private var orderNumber = 0
    private val pizzaMaker = PizzaMaker()
    private val barista = Barista()

    fun orderCoffee(name: String): CoffeeOrder {
        val currentCoffee = Coffee.getCoffeeByName(name)
            ?: error("Неизвестный вид кофе!")

        return CoffeeOrder(
            number = ++orderNumber,
            coffee = currentCoffee
        )
    }

    fun orderPizza(name: String): PizzaOrder {
        val pizza = Pizza(name)
        val ingredients = getIngredient(pizza)
        if (ingredients.isEmpty()) {
            error("Неизвестный вид пиццы!")
        }
        return PizzaOrder(
            number = ++orderNumber,
            pizza = pizza,
        )
    }

    fun executeOrder(vararg orderList: Order) {
        for(currentOrder in orderList){
            when(currentOrder){
                is PizzaOrder -> pizzaMaker.makePizza(currentOrder)
                is CoffeeOrder -> barista.makeCoffee(currentOrder)
            }
        }
    }
}

//    fun executeOrder(  pizzaOrder: PizzaOrder? = null, coffeeOrder: CoffeeOrder? = null) {
//        if (pizzaOrder != null) {
//            pizzaMaker.makePizza(pizzaOrder)
//        }
//
//        if (coffeeOrder != null) {
//            barista.makeCoffee(coffeeOrder)
//        }
//    }
//
//    fun executeOrder(coffeeOrder: CoffeeOrder? = null) {
//        executeOrder(null, coffeeOrder)
//    }
//
//    fun executeOrder(pizzaOrder: PizzaOrder? = null) {
//        executeOrder(pizzaOrder, null)
//    }