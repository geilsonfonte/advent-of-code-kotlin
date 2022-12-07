package aoc.year2022

import readInput
import kotlin.test.Test
import kotlin.test.assertEquals

class TestDay04 {

    private val puzzle = Day04()
    private val puzzleName = puzzle.javaClass.simpleName

    @Test fun testInput() {
        val testInput = readInput(2022, puzzleName + "_test")
        assertEquals(2, puzzle.part1(testInput))
        assertEquals(4, puzzle.part2(testInput))
    }

    @Test fun realInput() {
        val input = readInput(2022, puzzleName)
        println(puzzle.part1(input))
        println(puzzle.part2(input))
    }

}