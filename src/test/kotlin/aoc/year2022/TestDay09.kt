package aoc.year2022

import readInput
import kotlin.test.Test
import kotlin.test.assertEquals

class TestDay09 {

    private val puzzle = Day09()
    private val puzzleName = puzzle.javaClass.simpleName

    @Test fun testInput() {
        val testInput = readInput(2022, puzzleName + "_test")
        assertEquals(13, puzzle.part1(testInput))
        assertEquals(1, puzzle.part2(testInput))
    }

    @Test fun realInput() {
        val input = readInput(2022, puzzleName)
        println(puzzle.part1(input))
        println(puzzle.part2(input))
    }

}
