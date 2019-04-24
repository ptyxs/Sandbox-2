import java.io.File

// lire fichier ligne par ligne, modifier la ligne et adjoindre la ligne modifiée à un autre fichier
fun main() {
    val reg2 = "ill".toRegex()
    val filIn = File("src/villages.txt")
    val filOut = File("src/villagesOut2.txt")
    filOut.delete()

    println("texte original")
    filIn.forEachLine { line ->
        println(line)
        filOut.appendText("${reg2.replace(line, "TIENS")}\n")
    }

    println("texte modifié")
    println(filOut.readText())

    // groupBy pour une chaîne
    val gr =  "dododr".groupBy { it }

    println("dododr".groupBy { it })
    println(gr)
}