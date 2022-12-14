fun main() {
    // A: Rock, B: Paper, C: Scissors
    // A < B < C < A
    val scoreMap = mapOf("A" to 1, "B" to 2, "C" to 3)
    val XYZ2ABC = mapOf("X" to "A", "Y" to "B", "Z" to "C")

    fun part1(input: List<String>): Int {
        var score = 0
        for (line in input) {
            var (opponent, myPlayer) = line.replace("\n", "").split(" ")
            // Add score of played shape
            score += scoreMap[XYZ2ABC[myPlayer]]!!

            myPlayer = XYZ2ABC[myPlayer]!!

            // Add score of match result
            if (opponent == myPlayer) {
                // DRAW (3 points)
                score += 3
            } else if ((opponent == "A" && myPlayer == "B") ||
                (opponent == "B" && myPlayer == "C") ||
                (opponent == "C" && myPlayer == "A")
                    ) {
                // WIN (6 points): Rock > Scissors > Paper > Rock
                score += 6
            } else {
                // LOST (0 points)
                // Do nothing
            }

        }
        return score
    }

    fun part2(input: List<String>): Int {
        var score = 0
        val result2abc = mapOf(
            "A" to mapOf("X" to "C", "Y" to "A", "Z" to "B"),
            "B" to mapOf("X" to "A", "Y" to "B", "Z" to "C"),
            "C" to mapOf("X" to "B", "Y" to "C", "Z" to "A")
        )
        val xyz2score = mapOf("X" to 0, "Y" to 3, "Z" to 6)

        for (line in input) {
            val (opponent, result) = line.replace("\n", "").split(" ")
            // Now X,Y,Z are the results:
            // X = lose, Y = draw, Z = win
            val myPlayer = result2abc[opponent]?.get(result)
            score += scoreMap[myPlayer]!! + xyz2score[result]!!
        }

        return score
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 15)

    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}
