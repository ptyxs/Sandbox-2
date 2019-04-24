import java.io.File

fun main() {
    val f = File("src/sources.txt")

    var taille: Int? = 0
    var village: String = ""
    var duree: Double = 0.0

    val regTaille = """taille\s*:\s*(?<taille>.*)""".toRegex()
    val regVillage = """village\s*:\s*(.*)""".toRegex()
    val regDuree = """durée\s*:\s*(.*)""".toRegex()


    f.forEachLine { line ->
        (regTaille.find(line)?.groupValues?.get(1)?.toInt())?.let {
            taille = it
        }

        (regVillage.find(line)?.groupValues?.get(1))?.let {
            village = it
        }

        (regDuree.find(line)?.groupValues?.get(1)?.toDouble())?.let {
            duree = it
        }
    }

    println("$taille $village $duree")


    println("   ".replaceAfterLast(' ', "B"))

    println("".plus('B'))

    fun String.blanks(num: Int): String {
        return this + " ".repeat(num)
    }

    println("".blanks(3))

    val str = StringBuilder("     ")
    str.setCharAt(2, 'B')
    println(str)

    println("test avant test arrière")
    println("(?=Cassian)Cas.*".toRegex().matches("CassianBraconnier"))
    println(".*nier(?<=Braconnier).*".toRegex().matches("CassianBraconnier"))



}