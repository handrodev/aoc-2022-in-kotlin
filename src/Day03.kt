fun main() {
    // Map each char to its priority (index 0-based)
    val prioMap = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"

    fun part1(input: List<String>): Int {
        var prioScore = 0
        for (line in input) {
            val halfLength: Int = line.length / 2

            // Divide input into two equally sized compartments
            val firstSet = line.substring(0, halfLength).toSet()
            val secondSet = line.substring(halfLength).toSet()

            // Get common object
            val common = firstSet.intersect(secondSet)

            if (common.isNotEmpty()) {
                // Accumulate priority of common object
                prioScore += prioMap.indexOf(common.first()) + 1  // +1 because prioMap is 0-based
            }
        }
        return prioScore
    }

    fun part2(input: List<String>): Int {
        var prioScore = 0
        val groups: Int = input.size / 3  // Number of groups of 3 elves

        for (g in 0 until groups) {
            val elf1 = input[g * 3].toSet()
            val elf2 = input[g * 3 + 1].toSet()
            val elf3 = input[g * 3 + 2].toSet()

            // Get the object common to all 3 elves
            val common = elf1.intersect(elf2.intersect(elf3))

            if (common.isNotEmpty()) {
                // Accumulate priority of common object
                prioScore += prioMap.indexOf(common.first()) + 1  // +1 because prioMap is 0-based
            }
        }

        return prioScore
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 157)

    val input = readInput("Day03")
    part1(input).println()
    part2(input).println()
}
