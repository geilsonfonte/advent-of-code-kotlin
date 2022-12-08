package aoc.year2022

class Day06 {

    fun part1(input: List<String>): Int {
        val markerSize = 4
        return indexOfMarker(input[0], markerSize) + markerSize
    }

    private fun indexOfMarker(input: String, markerSize: Int): Int {
        val marker = input.windowed(markerSize)
            .first { it.toSet().size == markerSize }
        return input.indexOf(marker)
    }

    fun part2(input: List<String>): Int {
        val markerSize = 14
        return indexOfMarker(input[0], markerSize) + markerSize
    }
}


