package aoc.year2022

import readInput

class Day01 {
    fun part1(input: List<String>): Int {
        return caloriesPerElf(input).maxOrNull()!!
    }

    private fun caloriesPerElf(input: List<String>): List<Int> {
        val elves = mutableListOf<Int>()
        var currentElf = 0
        for (calories in input) {
            if (calories.isNotBlank()) {
                currentElf += calories.toInt()
            } else {
                elves.add(currentElf)
                currentElf = 0
            }
        }
        elves.add(currentElf)
        return elves
    }

    fun part2(input: List<String>): Int {
        return caloriesPerElf(input)
            .sortedDescending()
            .take(3)
            .sum()
    }
}


