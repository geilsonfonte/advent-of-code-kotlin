package aoc.year2022

import java.util.*

class Day05 {

    fun part1(input: List<String>): String {
        val stacks: Map<Int, Stack<String>> = initialState(input)

        val moves = rearrangementProcedure(input)
        moves.forEach { move -> move.applyCrateMover9000(stacks) }

        return topCrates(stacks)
    }

    fun part2(input: List<String>): String {
        val stacks: Map<Int, Stack<String>> = initialState(input)

        val moves = rearrangementProcedure(input)
        moves.forEach { move -> move.applyCrateMover9001(stacks) }

        return topCrates(stacks)
    }

    private fun rearrangementProcedure(input: List<String>): List<Move> {
        return input.dropWhile(String::isNotBlank).dropWhile(String::isBlank)
            .map { it.split("\\D+".toRegex()).filter(String::isNotBlank).map(String::toInt) }
            .map { (qty, from, to) -> Move(qty, from, to) }
    }

    private fun initialState(input: List<String>): Map<Int, Stack<String>> {
        val initialStateDefinition = input
            .takeWhile(String::isNotBlank)
        val stackCount = initialStateDefinition.last()
            .windowed(size = 3, step = 4)
            .last()
            .trim().toInt()

        val stacks: Map<Int, Stack<String>> = (1..stackCount).associateWith { Stack<String>() }.toSortedMap()

        initialStateDefinition.dropLast(1).reversed().forEach { line ->
            val crates = line.windowed(size = 3, step = 4)
                .mapIndexed { index, crate -> index.inc() to crate.removeSurrounding("[", "]") }
                .toMap()
                .filterValues(String::isNotBlank)
            crates.forEach { (stack, crate) -> stacks[stack]?.push(crate) }
        }
        return stacks
    }

    private fun topCrates(stacks: Map<Int, Stack<String>>) =
        stacks.values.map { it.peek() }.joinToString("")



    data class Move(val qty: Int, val from: Int, val to: Int) {

        fun <E> applyCrateMover9000(stacks: Map<Int, Stack<E>>) =
            (1..qty).forEach { _ -> stacks[to]?.push(stacks[from]?.pop()) }

        fun <E> applyCrateMover9001(stacks: Map<Int, Stack<E>>) {
            val aux = Stack<E>()
            (1..qty).forEach { _ ->
                aux.push(stacks[from]?.pop())
            }
            while (!aux.empty()) {
                stacks[to]?.push(aux.pop())
            }
        }
    }

}

