fun rep(input: String): String {
    return """\s*((\+)?1)?\s*(.*)""".toRegex().replace(input, "$3")
}

// back reference with nested group
fun main() {
    println(rep("+1 (613)-995-0253"))
}