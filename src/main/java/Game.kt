data class Grid(private val matrix: List<List<Any>>)

enum class Direction { HORIZONTAL, VERTICAL }
enum class ShipType(val length: Int) {
    AIRCRAFT_CARRIER(5),
    BATTLESHIP(4),
    SUBMARINE(3),
    CRUISER(3),
    DESTROYER(2),
}

enum class Column {
    A, B, C, D, E, F, G, H, I, J;

    fun next(): Column {
        return entries[this.ordinal + 1]
    }
}

enum class Row {
    `1`, `2`, `3`, `4`, `5`, `6`, `7`, `8`, `9`, `10`;

    fun next(): Row {
        return entries[this.ordinal + 1]
    }
}

data class Coordinate(private val column: Column, private val row: Row) {
    fun shiftNext(direction: Direction): Coordinate {
        return if (direction == Direction.HORIZONTAL)
            Coordinate(this.column.next(), this.row) // right
        else
            Coordinate(this.column, this.row.next()) // bottom
    }
}

data class Ship(
    val type: ShipType,
    val direction: Direction,
    val coordinate: Coordinate,
) {
    private val coordinates: List<Coordinate>
        get() = generateSequence(coordinate) { coordinate.shiftNext(direction) }.take(type.length).toList()

    fun overlaps(otherShip: Ship): Boolean {
        return coordinates.any { otherShip.coordinates.contains(it) }
    }
}

data class Board(private val ships: MutableList<Ship> = mutableListOf()) {
    fun add(ship: Ship) {
        require(ships.none { it.type == ship.type })
        require(ships.none { ship.overlaps(it) })
        this.ships.add(ship)
    }
}
