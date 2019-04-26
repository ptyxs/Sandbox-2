fun <T> List<T>.tail(): List<T> = if (this.isEmpty()) throw IllegalArgumentException("tail called on empty list")
    else this.subList(1, this.count())

fun main() {
    val list = listOf(1,2,3,4)
    println(list.tail())
}