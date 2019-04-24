import java.time.LocalDate

private fun printMyDate(date: LocalDate): Unit {
    println(date.month)
    println(date.month.value)
}

fun main() {
    printMyDate(LocalDate.now())
    val seq1 = generateSequence(0) { if (it + 1 <= 8) it + 1 else null }
    val seq2 = generateSequence(0) { (it + 1).let { successor -> if (successor <= 8) successor else null } }

    seq1.forEach { print("$it ") }
    println()
    seq2.forEach { print("$it ") }
    println()
    println(seq1.count())
    println(seq2.count())
}