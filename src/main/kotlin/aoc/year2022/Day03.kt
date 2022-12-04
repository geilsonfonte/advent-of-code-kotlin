package aoc.year2022

class Day03 {

    fun part1(input: List<String>): Int {
        return input.map(this::commonItem)
            .map(this::priority)
            .sum()
    }

    fun part2(input: List<String>): Int {
        return input.windowed(3, 3)
            .map(this::commonItem)
            .map(this::priority)
            .sum()
    }

    private fun commonItem(rucksacks: List<String>) : Char {
        return rucksacks
            .map { it.toSet() }
            .reduce{ a, b -> a.intersect(b)}
            .first()
    }

    private fun commonItem(s: String) : Char {
        val half = s.length / 2
        return commonItem(listOf(s.substring(0, half), s.substring(half)))
    }

    fun priority(c: Char): Int {
        return if (c.isLowerCase()) {
            c.code - 'a'.code + 1
        } else {
            c.code - 'A'.code + 27
        }
    }
}


