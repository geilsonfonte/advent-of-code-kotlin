package aoc.year2022

class Day04 {

    fun part1(input: List<String>): Int {
        return rangePairs(input)
            .filter { (r1, r2) -> contains(r1, r2) || contains(r2, r1) }
            .count()
    }

    fun part2(input: List<String>): Int {
        return rangePairs(input)
            .filter { (r1, r2) -> overlaps(r1, r2) }
            .count()
    }

    private fun rangePairs(input: List<String>): List<Pair<IntRange, IntRange>> =
        input.map { line -> toPair(line.split(",").map { side -> toRange(side) }) }

    private fun <E> toPair(list: List<E>): Pair<E, E> = Pair(list[0], list[1])

    private fun toRange(s: String): IntRange {
        val ints = s.split("-").map(String::toInt)
        return ints[0]..ints[1]
    }

    private fun contains(r1: IntRange, r2: IntRange): Boolean {
        return r1.contains(r2.first) && r1.contains(r2.last)
    }

    private fun overlaps(r1: IntRange, r2: IntRange): Boolean {
        return r1.any { r2.contains(it) }
    }
}


