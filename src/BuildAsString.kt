object BuildAString {
    var value = ""

    val truc = buildString {
        "bold23"
    }

}

fun main() {

    val style: String
/*

while (n > 0) {
        value = value.plus(highestInMap(n)!!.value)
        n = n - highestInMap(n)!!.key
    }
*/
println(BuildAString.truc)
    var n = 5
    style = buildString {
        while (n > 0) {
            append("Bold")
            n--

        }
    }
//        style = buildString { append("Bold"); append("Bold") }
    println(style)
//    println(buildAString.truc)
}
