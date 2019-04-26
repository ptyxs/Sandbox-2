object LateInit {
    lateinit var x: String

    init {
        x = x + "!"
    }
}

fun main() {
    LateInit.x = "hello"
    println(LateInit.x)
}