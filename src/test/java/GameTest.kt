import Column.*
import Row.*
import ShipType.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class GameTest {
    @Test
    fun `should not be allowed to put the same ship twice`() {
        val board = Board()

        board.add(Ship(AIRCRAFT_CARRIER, Direction.HORIZONTAL, Coordinate(A, `1`)))

        assertThrows<IllegalArgumentException> {
            board.add(Ship(AIRCRAFT_CARRIER, Direction.HORIZONTAL, Coordinate(A, `2`)))
        }
    }
}
