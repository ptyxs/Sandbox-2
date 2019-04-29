//package com.fpinkotlin.recursion.exercise01


tailrec fun add(a: Int, b: Int): Int = if (b == 0) a else add(inc(a), dec(b))

fun inc(n: Int) = n + 1
fun dec(n: Int) = n - 1

// somme des number premiers entiers positifs
// en allant diminuendo
fun sumFirstInts(number: Int): Long {
    tailrec fun sumHelper(sum: Long, current: Long): Long {
        return if (current == 0L) sum
        else sumHelper(sum + current, current - 1L)
    }
    return sumHelper(0L, number.toLong())
}

// somme des number premiers entiers positifs
// en allant crescendo
fun sumFirstInts2(number: Int): Long {
    tailrec fun sumHelper(sum: Long, current: Long): Long {
        return if (current > number.toLong()) sum
        else sumHelper(sum + current, current + 1L)
    }
    return sumHelper(0L, 0L)
}

// regrouper en une String tous les éléments d'une List
fun <T> string(list: List<T>): String {

    tailrec fun stringHelper(str: String, list: List<T>): String {
        return if (list.isEmpty()) str
        else stringHelper(str.plus(list.head()), list.tail())
    }

    return stringHelper("", list)
}

// comme string mais avec délimiteur
fun <T> makeString(list: List<T>, delim: String): String {
    tailrec fun makeStringHelper(str: String, list: List<T>): String {

        return when {
            list.isEmpty() -> str // plus rien dans la liste à ajouter : on renvoie la string telle quelle
            // on est au premier élément de la liste, la string est encore vide : on ne met pas de délimiteur
            str.isEmpty() -> makeStringHelper(str.plus(list.head()), list.tail())
            else -> makeStringHelper(str.plus("$delim${list.head()}"), list.tail())
        }
    }
    return makeStringHelper("", list)
}

// dans Kotlin, fold() est un foldLeft dont la liste est le receveur
fun <T, U> foldLeft(list: List<T>, acc: U, f: (U, T) -> U): U {
    tailrec fun foldLeftHelper(list: List<T>, acc: U): U {
        return if (list.isEmpty()) acc
        else foldLeftHelper(list.tail(), f(acc, list.head()))
    }
    return foldLeftHelper(list, acc)
}

fun sum(list: List<Int>) = foldLeft(list, 0, Int::plus)

fun newString(list: List<Char>) = foldLeft(list, "", String::plus)

fun <T> newMakeString(list: List<T>, delim: String) =
    foldLeft(list, "") { s, t -> if (s.isEmpty()) "$t" else "$s$delim$t" }

fun main() {
    println(add(5, 3)) // 8
    println(sumFirstInts(100_000)) // 5_000_050_000
    println(sumFirstInts2(100_000)) // 5_000_050_000
    println(string(listOf(1, 2)))
    println(makeString(listOf(1, 3, 3), "**")) // 1**3**3

    println(sum(listOf<Int>(6, 4))) // 10
    println(newString(listOf('a', 'z', '2'))) // az2
    println(newMakeString(listOf(1, 2, 3), "**"))
    println((String::plus)("ok",3))
}