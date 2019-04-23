fun main() {
    val compose = { x: (Int) -> Int -> { y: (Int) -> Int -> { z: Int -> x(y(z)) } } }
    val triple: (Int) -> Int = { it * 3 }
    val square: (Int) -> Int = { it * it }

    println(compose(triple)(square)(5))

    val compose1 = compose(triple)

    println(compose1(square)(5))
    println(triple(5))


    fun <T, U, V> higherCompose(): ((U) -> V) -> ((T) -> U) -> (T) -> V =
        { f ->
            { g ->
                { x -> f(g(x)) }
            }
        }

    println(higherCompose<Int, Int, Int>()(triple)(square)(5))

    val tripleIntToString: (Int) -> String = { (it * 3).toString() }
    val stringToDouble: (String) ->  Double = { it.toDouble() }

    println(tripleIntToString(5))
    higherCompose<Int, String, Double>()(stringToDouble)(tripleIntToString)(5)
}