fun main(args: Array<String>) {
    println(
        """Hello!
          | bye bye!
          |  man""".trimMargin()
    )

    println()

    println(
        """
        Hello!
        bye bye!
        man
        """.trimIndent()
    )
    // truc(4)

    var result = true
    val phrase = "eats"
    phrase.forEachIndexed { i, char ->
        if (phrase.lastIndexOf(char) != i) {
            result = false
        }
    }
    println(result)

    val phrase2 = "ohohoh"
    val cleanPhrase = phrase2.replace("-", "")
    println("cleanPhrase: $cleanPhrase")


    val phrase3 = "to ino"
    println(phrase3.toLowerCase()
        .filter(Char::isLetter)
        .run { toSet().size == length }
    )
    val str = phrase3.filter(Char::isLetter)
        .toSet()
    println(str)

    val bidule = arrayOf(2, "az")
}


fun truc(num: Int): Int {
    TODO()
}