package aoc.year2022

import readInput
import kotlin.test.Test
import kotlin.test.assertEquals

class TestDay03 {

    private val puzzle = Day03()
    private val puzzleName = puzzle.javaClass.simpleName

    @Test fun testPriority() {
        assertEquals(1, puzzle.priority('a'))
        assertEquals(26, puzzle.priority('z'))
        assertEquals(52, puzzle.priority('Z'))
    }

    @Test fun testInput() {
        val testInput = readInput(2022, puzzleName + "_test")
        assertEquals(157, puzzle.part1(testInput))
        assertEquals(70, puzzle.part2(testInput))
    }

    @Test fun realInput() {
        val input = readInput(2022, puzzleName)
        println(puzzle.part1(input))
        println(puzzle.part2(input))
    }

}