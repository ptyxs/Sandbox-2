// note no return in functions last line
fun main() {
    println({
        val currentYear = 2019
        "Welcome to SimVillage, Mayor! (copyright $currentYear)"
    }())

    val greetingFunction1: () -> String = {
        val currentYear = 2019
        "Welcome to SimVillage, Mayor! (copyright $currentYear)"
    }
    println(greetingFunction1())

    val greetingFunction2: (String) -> String = { playerName ->
        val currentYear = 2019
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }
    println(greetingFunction2("Dugommier"))

    println(
        """

        ==========================
        new part:

        """.trimIndent()
    )

    runSimulation("Dugommier", greetingFunction)
    runSimulation("Delamare") { playerName, numBuildings -> "shorthand syntax $playerName, $numBuildings"}

    println(
        """

        ==========================
        another part:

        """.trimIndent()
    )
runSimulation2("Braconnier", ::printConstructionCost,greetingFunction)
}

val greetingFunction = { playerName: String, numBuildings: Int ->
    val currentYear = 2019
    println("Adding $numBuildings houses")
    "Welcome to SimVillage, $playerName! (copyright $currentYear)"

}

// a mother function taking a child function as argument
// one of the arguments of the child function is passed to the mother
// the other argument of the child function is created in the mother function
inline fun runSimulation(playerName: String, greetingFunction: (String, Int) -> String) {
    val numBuildings = (1..3).shuffled().last()
    println(greetingFunction(playerName, numBuildings))
}

fun printConstructionCost(numBuildings: Int) {
    val cost = 500
    println("construction cost: ${cost * numBuildings}")
}
inline fun runSimulation2(playerName: String,
                          costPrinter: (Int) -> Unit,
                          greetingFunction: (String, Int) -> String) {
    val numBuildings = (1..3).shuffled().last()
    costPrinter(numBuildings)
    println(greetingFunction(playerName, numBuildings))
}
