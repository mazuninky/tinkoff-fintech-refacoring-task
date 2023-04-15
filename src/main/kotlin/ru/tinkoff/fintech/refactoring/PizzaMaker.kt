package ru.tinkoff.fintech.refactoring

class PizzaMaker(
    private val pizzaMenu: Map<String, Pizza> = defaultPizzaMenu,
    private val ingredientPriceList: Map<String, Double> = defaultIngredientPriceList,
) {

    fun makePizza(order: Order) {
        val recipe = pizzaMenu[order.name]?.recipe ?: error("Невозможно приготовить \"${order.name}\"")

        println("[Повар] Делаю блюдо : ${order.name}")
        println("[Повар] Из ингридиетов:")

        val totalPrice = recipe.entries.sumOf { (ingredientName, amount) ->
            val price = calculatePrice(ingredientName, amount)
            println("[Повар] - ${ingredientName}: в количестве $amount за $price$")
            price
        }

        val roundedPrice = "%.2f".format(totalPrice)

        val time = recipe.entries.sumOf { it.value }
        println("[Повар] время приготовления $time минут")
        println("[Повар] в сумме за все $roundedPrice$")
    }

    private fun calculatePrice(ingredientName: String, amount: Int): Double {
        val price = ingredientPriceList[ingredientName] ?: error("Неизвестный ингредиент")
        return price * amount
    }
}

private val defaultPizzaMenu = mapOf(
    "карбонара" to mapOf("яйца" to 1, "бекон" to 2, "тесто" to 1, "сыр" to 2),
    "маринара" to mapOf("томат" to 2, "оливки" to 3, "тесто" to 1),
    "сардиния" to mapOf("салями" to 3, "оливки" to 1, "тесто" to 1, "сыр" to 3),
    "вальтеллина" to mapOf("вяленая говядина" to 1, "зелень" to 1, "тесто" to 1, "пармезан" to 2),
    "крестьянская" to mapOf(
        "грибы" to 3,
        "томат" to 1,
        "тесто" to 1,
        "спаржа" to 1,
        "мясное ассорти" to 1
    ),
).mapValues { Pizza(it.key, it.value) }

private val defaultIngredientPriceList = mapOf(
    "яйца" to 3.48,
    "бекон" to 6.48,
    "тесто" to 1.00,
    "томат" to 1.53,
    "оливки" to 1.53,
    "сыр" to 0.98,
    "пармезан" to 3.98,
    "грибы" to 3.34,
    "спаржа" to 3.34,
    "мясное ассорти" to 9.38,
    "вяленая говядина" to 12.24,
)