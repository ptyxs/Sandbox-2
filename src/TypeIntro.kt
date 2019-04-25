const val MAX_EXPERIENCE: Int = 5000

fun tdo(): String {
        TODO()
//    return foo()
    // TODO() renvoie le type Nothing qui est un sous-type de tout, le return est implicite
    // et peut être rajouté sans provoquer une erreur de compilation seulement un avertissment unreachable code
}
fun foo() = "ooo"

fun main() {
    val playerName = "Estragon"
    var experiencePoints = 5
    experiencePoints += 5
    println(experiencePoints)
    println(playerName)
    println(MAX_EXPERIENCE)

//    tdo()
    val value: Any
    value = Any()
print(value)
}