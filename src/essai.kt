fun main(args: Array<String>) {

    fun printToList(char: Char): List<String> {

        var baseNum = char.toInt() - 'A'.toInt()
        var dimension = baseNum * 2 + 1

        val baseString = "".plus(" ".repeat((baseNum * 2) + 1))
        val list = mutableListOf<String>()

        var str: StringBuilder


        for (c in 'A'..char) {
            str = java.lang.StringBuilder(baseString)
            str.setCharAt(baseNum, c)
            str.setCharAt(str.length - 1 - baseNum, c)
            list.add(str.toString())
            baseNum = baseNum - 1
        }

        val result = list.plus(list.reversed().subList(1, list.size))
/*

        for(i in 0..result.size - 1) {
        println(result[i])
        }

*/
        return list
    }

    printToList('Z')

    print("START")
    print((2 downTo 4).isEmpty())
    print("END")

}