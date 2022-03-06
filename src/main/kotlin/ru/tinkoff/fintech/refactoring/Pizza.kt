package ru.tinkoff.fintech.refactoring


enum class Pizza(
    val productName: String,
    var ingredients: List<Pair<String, Int>>,
) {
    Carbonara("карбонара", listOf("яйца" to 1, "бекон" to 2, "тесто" to 1, "сыр" to 2)),
    Marinara("маринара", listOf("томат" to 2, "оливки" to 3, "тесто" to 1)),
    Sardinia("сардиния", listOf("томат" to 2, "оливки" to 3, "тесто" to 1)),
    Valtellina("вальтеллина", listOf("вяленая говядина" to 1, "зелень" to 1, "тесто" to 1, "пармезан" to 2)),
    Cristian("крестьянская", listOf("грибы" to 3, "томат" to 1, "тесто" to 1, "спаржа" to 1, "мясное ассорти" to 1));

    companion object {
        fun getPizzaName(name: String): Pizza? {
            return Pizza.values().find { it.productName == name }
        }
    }
}
