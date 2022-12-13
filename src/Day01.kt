fun main() {
    fun part1(input: List<String>): Int {
        // Keep track of maximum calories carried by any elf
        var maxCalories = 0

        // Keep track of calories carried by current elf
        var calories = 0

        for (line in input) {
            if (line.isBlank()) {
                // Empty line means another elf
                if (calories > maxCalories)
                    // Current elf is carrying more calories than anyone else
                    // Update maximum
                    maxCalories = calories
                // Reset calories counter
                calories = 0
            } else {
                // Still the same elf, keep counting calories carried
                calories += line.toInt()
            }
        }

        return maxCalories
    }

    fun part2(input: List<String>): Int {
        // Keep track of calories for each elf
        val calories = arrayListOf<Int>(0)

        for (line in input) {
            if (line.isBlank()) {
                // Blank line -> add a new calories counter to the list (new elf)
                calories.add(0)
            } else {
                // Not a blank line -> accumulate calories for current elf (last one added)
                calories[calories.lastIndex] += line.toInt()
            }
        }
        // Sort list of elves (ascending), take the last three and return their sum of calories
        return calories.sorted().takeLast(3).sum()
    }

    // test if implementation meets criteria from the description, like:
    // val testInput = readInput("Day01")
    // check(part1(testInput) == 1)

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
