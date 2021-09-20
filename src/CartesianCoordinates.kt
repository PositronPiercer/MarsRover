import interfaces.CoordinatesReporter
import java.lang.IllegalStateException

class CartesianCoordinates(
    private val coordinates: List<Int>
) : Coordinates() {
    private val dimension = coordinates.size
    fun reportCartesian2d(coordinatesReporter: CoordinatesReporter){
        coordinatesReporter.reportCartesian2d(coordinates[0], coordinates[1])
    }
    private fun getDelta(distance: Int, direction: Orientation) : CartesianCoordinates{
        return when(direction){
            Orientation.N -> CartesianCoordinates(
                coordinates = listOf(
                    0,
                    distance
                ) + List(dimension - 2){0}
            )
            Orientation.S -> CartesianCoordinates(
                coordinates = listOf(
                    0,
                    -distance
                ) + List(dimension - 2){0}
            )
            Orientation.E -> CartesianCoordinates(
                coordinates = listOf(
                    distance,
                    0
                ) + List(dimension - 2){0}
            )
            Orientation.W -> CartesianCoordinates(
                coordinates = listOf(
                    -distance,
                    0
                ) + List(dimension - 2){0}
            )
        }
    }

    override fun atDelta(distance: Int, direction: Orientation) : CartesianCoordinates {
        val delta = getDelta(distance, direction)
        return this.add(delta)
    }

    fun add(delta: CartesianCoordinates): CartesianCoordinates {
        val newCoordinatesList = mutableListOf<Int>()
        lateinit var deltaCoordinates : List<Int>
        val coordinatesReporter = object : CoordinatesReporter{
            override fun reportCartesian(coordinates: List<Int>) {
                deltaCoordinates = coordinates
            }
        }
        delta.report(coordinatesReporter)
        for (index : Int in 0 until dimension){
            newCoordinatesList.add(deltaCoordinates[index] + coordinates[index])
        }
        return CartesianCoordinates(newCoordinatesList)
    }

    override fun report(coordinatesReporter: CoordinatesReporter) {
        coordinatesReporter.reportCartesian(coordinates)
    }
}