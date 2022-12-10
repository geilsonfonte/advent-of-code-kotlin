package aoc.year2022

class Day07 {

    fun part1(input: List<String>): Int {
        val root = readFileSystem(input)

        return root.subFolders()
            .map(Folder::size)
            .filter { it <= 100000 }
            .sum()
    }

    private fun readFileSystem(terminalOutput: List<String>): Folder {
        val root = Folder(null, "/")
        var currentFolder = root
        val filePattern = Regex("(\\d+) (\\S+)")

        terminalOutput.forEach { command ->
            when {
                command == "$ cd /" -> currentFolder = root
                command == "$ cd .." -> currentFolder = currentFolder.parent!!
                command.startsWith("$ cd ") -> {
                    val dirName = command.substringAfter("$ cd ")
                    currentFolder = currentFolder.get(dirName) as Folder
                }
                command.startsWith("dir ") -> {
                    val dirName = command.substringAfter("dir ")
                    currentFolder.content.add(Folder(currentFolder, dirName))
                }
                filePattern.matches(command) -> {
                    val (size, name) = filePattern.matchEntire(command)!!.destructured
                    currentFolder.content.add(File(name, size.toInt()))
                }
                else -> Unit // do nothing
            }
        }

        return root
    }

    fun part2(input: List<String>): Int {
        val root = readFileSystem(input)

        val diskSize = 70000000
        val minimumFreeSpace = 30000000
        val currentFreeSpace = diskSize - root.size()
        val neededToFree = minimumFreeSpace - currentFreeSpace

        return root.subFolders()
            .map(Folder::size)
            .filter { it >= neededToFree }
            .minOrNull()!!
    }

    sealed interface Node {
        fun name(): String
        fun size(): Int
    }


    data class Folder(val parent: Folder?, val name: String) :Node {
        val content = mutableListOf<Node>()

        override fun name() = name
        override fun size() = content.sumOf(Node::size)

        fun get(name: String) : Node? = content.find { it.name() == name }

        fun subFolders() : List<Folder> {
            val children = content.filterIsInstance<Folder>()
            return children + children.flatMap(Folder::subFolders)
        }
    }

    data class File(val name: String, val size: Int): Node {
        override fun name() = name
        override fun size() = size
    }
}


