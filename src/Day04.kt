fun main() {
    fun part1(input: List<String>): Int {
        var overlapping = 0
        for (line in input) {
            // Get sections covered by each elf
            val (elf1, elf2) = line.split(",")
            // Get first and last section covered by each elf
            val (x1, x2) = elf1.split("-").map { s -> s.toInt() }
            val (y1, y2) = elf2.split("-").map { s -> s.toInt() }
            // Check if one of the sections is fully contained by the other
            if ((y1 >= x1 && y2 <= x2) ||
                (x1 >= y1 && x2 <= y2))
                overlapping++
        }
        return overlapping
    }

    fun part2(input: List<String>): Int {
        var overlapping = 0
        for (line in input) {
            // Get sections covered by each elf
            val (elf1, elf2) = line.split(",")
            // Get first and last section covered by each elf
            val (x1, x2) = elf1.split("-").map { s -> s.toInt() }
            val (y1, y2) = elf2.split("-").map { s -> s.toInt() }
            // Check if sections overlap at any point
            if (x1 <= y2 && y1 <= x2)
                overlapping++
        }
        return overlapping
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    val input = readInput("Day04")
    part1(input).println()
    part2(input).println()
}
