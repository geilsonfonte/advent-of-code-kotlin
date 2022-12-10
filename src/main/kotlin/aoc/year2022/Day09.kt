package aoc.year2022

import java.lang.Integer.*
import kotlin.math.abs

class Day09 {

    enum class Direction(val x: Int, val y: Int) {
        U(0, -1),
        D(0, 1),
        L(-1, 0),
        R(1, 0)
    }

    data class Point(val x: Int, val y: Int) {
        fun move(dir: Direction) = Point(x + dir.x, y + dir.y)
    }

    fun follow(head: Point, tail: Point): Point {
        val xDist = abs(head.x - tail.x)
        val yDist = abs(head.y - tail.y)
        val max = max(xDist, yDist)
        //val min = min(xDist, yDist)

        return Point(follow(head.x, tail.x, max), follow(head.y, tail.y, max))
    }

    private fun follow(head: Int, tail: Int, currentDistance: Int) : Int {
        return if (abs(head - tail) > 1 || currentDistance > 1) {
            tail + signum(head - tail)
        } else tail
    }

    fun part1(input: List<String>): Int {
        var head = Point(0,0)
        var tail = head

        val visited = mutableSetOf(tail)

        directions(input).forEach { direction ->
            head = head.move(direction)
            tail = follow(head, tail)
            visited.add(tail)
        }

        return visited.size
    }

    private fun directions(input: List<String>) =
        input.flatMap { line -> List(line.drop(2).toInt()) { Direction.valueOf(line.first().toString()) } }

    fun part2(input: List<String>): Int {
        val knots = MutableList(10) { Point(0,0) }

        val visited = mutableSetOf(knots.last())

        directions(input).forEach { direction ->
            knots[0] = knots[0].move(direction)
            knots.indices.windowed(2).forEach { (a, b) ->
                knots[b] = follow(knots[a], knots[b])
            }
            visited.add(knots.last())
        }

        return visited.size
    }
}


