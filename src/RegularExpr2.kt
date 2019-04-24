fun main() {
    // on garde un troisièrme chiffre après la virgule s'il est différent de zéro
    // sinon deux seulement

    val input: String = readLine()!!

    val reg = """(?<start>\.\d\d[1-9]?)\d*""".toRegex()

    println(reg.replace(input, "\${start}"))


// si la regex ne reconnaît rien, replace() renvoie la chaîne inchangée
    // il semble que les groupes nommés ne puissent être repris dans la regex, seulement
    // dans le remplacement
    val reg2 = """((?<start>[ab]).*)""".toRegex()
    val input2 = "aba"
    println(reg2.replace(input2, "oX"))
}