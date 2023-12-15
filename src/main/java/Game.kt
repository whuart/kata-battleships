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
}

enum class Row {
    `1`, `2`, `3`, `4`, `5`, `6`, `7`, `8`, `9`, `10`;
}

data class Coordinate(private val column: Column, private val row: Row)

data class Ship(
    val type: ShipType,
    val direction: Direction,
    val coordinate: Coordinate,
)

data class Board(private val ships: MutableList<Ship> = mutableListOf()) {
    fun add(ship: Ship) {
        this.ships.add(ship)
    }
}
