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
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    // val testInput = readInput("Day01")
    // check(part1(testInput) == 1)

    val input = readInput("Day01")
    part1(input).println()
    // part2(input).println()
}
