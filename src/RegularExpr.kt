fun main() {

    // tous les remplacements possibles sont effectués (pour remplacer le premier
    // match : replaceFirst
    val data = "boa base bell"
    val output = Regex("""(?: (?<start>b))(?<body>\w+)""", RegexOption.COMMENTS)
        .replace(data, "\${body}")

    val output2 = Regex("""b""", RegexOption.COMMENTS)
        .replace(data, "A")

    println(output)
    println(output2)


// ***********************************
// équivalent en Kotlin du programme Perl dans Maîtrise des expressions régulières
// de Friedl page 43
    // notes : en Perl apparemment pas de conversion d'un string représentant un double
    // vers un type numérique
    // et d'autre part une variable "déclarée" dans le if est accessible en dehors du if
    // d'autre par en kotlin apparamment pas accès à des groupes emboîtés


    println("Entrez une température en degrés Celsius ou Fahrenheit, par exemple 22C, 31F")
    val input = readLine()!!

    val reg = """^([-+]?[0-9]+(?:\.[0-9]*)?)\s*([CF])$""".toRegex(RegexOption.IGNORE_CASE)

    reg.matchEntire(input)?.destructured?.let { (value, type) ->
        val inputNum = value.toDouble()

        val celsius: Double
        val fahrenheit: Double

        if (type.equals("C", true)) {
            celsius = inputNum
            fahrenheit = (celsius * 9 / 5) + 32
        } else {
            fahrenheit = inputNum
            celsius = (fahrenheit - 32) * 5 / 9
        }

        print("$celsius C = $fahrenheit F")
    } ?: println("J\'attends un nombre suivi de 'C' ou de 'F', je ne comprends donc pas \"$input\"")
}