package aoc.year2022

class Day08 {

    fun part1(input: List<String>): Int {
        val trees = input.map { line -> line.toList().map(Char::digitToInt) }
        val visible = trees.map { row -> MutableList<Boolean>(row.size) { _ -> false } }

        val rows = trees.indices
        val cols = trees.first().indices

        // left to right
        for (i in rows) {
            var maxSoFar = -1
            for (j in cols) {
                if (trees[i][j] > maxSoFar) {
                    visible[i][j] = true
                    maxSoFar = trees[i][j]
                }
            }
        }

        // right to left
        for (i in rows) {
            var maxSoFar = -1
            for (j in cols.reversed()) {
                if (trees[i][j] > maxSoFar) {
                    visible[i][j] = true
                    maxSoFar = trees[i][j]
                }
            }
        }

        // down
        for (j in cols) {
            var maxSoFar = -1
            for (i in rows) {
                if (trees[i][j] > maxSoFar) {
                    visible[i][j] = true
                    maxSoFar = trees[i][j]
                }
            }
        }

        // up
        for (j in cols) {
            var maxSoFar = -1
            for (i in rows.reversed()) {
                if (trees[i][j] > maxSoFar) {
                    visible[i][j] = true
                    maxSoFar = trees[i][j]
                }
            }
        }

        return visible.flatten().count { it == true }
    }

    fun part2(input: List<String>): Int {
        val trees = input.map { line -> line.toList().map(Char::digitToInt) }
        val scenicScore = trees.map { row -> MutableList<Int>(row.size) { _ -> 0 } }

        for (i in trees.indices.drop(1).dropLast(1)) {
            for (j in trees.first().indices.drop(1).dropLast(1)) {
                scenicScore[i][j] = scenicScore(trees, i, j)
            }
        }

        //scenicScore.forEach { println(it) }
        return scenicScore.flatten().maxOrNull()!!
        //return -1
    }

    private fun scenicScore(trees: List<List<Int>>, row: Int, col: Int): Int {
        val house = trees[row][col]
        val rows = trees.indices
        val cols = trees.first().indices

        var right = 0
        var j = col
        do {
            j++
            right++
        } while (j + 1 in cols && trees[row][j] < house)

        var left = 0
        j = col
        do {
            j--
            left++
        } while (j - 1 in cols && trees[row][j] < house)

        var up = 0
        var i = row
        do {
            i--
            up++
        } while (i - 1 in rows && trees[i][col] < house)

        var down = 0
        i = row
        do {
           i++
           down++
        } while (i + 1 in rows && trees[i][col] < house)


        //return listOf(up, left, right, down).joinToString("-")
        return right * left * up * down
    }
}


