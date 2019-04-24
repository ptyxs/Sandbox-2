import java.io.File


// lecture du texte complet du fichier + modification et création d'un nouveau fichier
// avec le texte modifié

fun main() {
    val reg = "ill".toRegex()

    val f = File("src/villages.txt")
    val text = f.readText()
    println(text)

    val newText = reg.replace(text, "OU")
    println(newText)

    val fout = File("src/villagesOut.txt")
    fout.writeText(newText)
    println(fout.readText())
}