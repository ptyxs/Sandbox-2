fun <T> List<T>.tail(): List<T> =
    if (isEmpty()) throw IllegalArgumentException("tail called on empty list")
    else subList(1, count())

// sublist is a view, safe with non mutable list

fun main() {
    val list = listOf<Int>(1,2,78)
    println(list.tail())
}