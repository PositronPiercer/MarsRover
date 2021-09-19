import interfaces.CoordinatesReporter
import java.lang.IllegalStateException

class CartesianCoordinates(
    private val dimension : Int,
    private var coordinates: MutableList<Int>
) : Coordinates() {
    init {
        if (coordinates.size > dimension){
            throw IllegalStateException("Number of coordinates cannot be more than dimension")
        }
    }
    fun reportCartesian2d(coordinatesReporter: CoordinatesReporter){
        coordinatesReporter.reportCartesian2d(coordinates[0], coordinates[1])
    }

    override fun atDelta(distance: Int, direction: Orientation) : CartesianCoordinates {
        return when(direction){
            Orientation.N -> CartesianCoordinates(
                dimension = dimension,
                coordinates = (mutableListOf(
                    coordinates[0],
                    coordinates[1] + distance
                ) + coordinates.drop(2)).toMutableList()
            )
            Orientation.S -> CartesianCoordinates(
                dimension = dimension,
                coordinates = (mutableListOf(
                    coordinates[0],
                    coordinates[1] - distance
                ) + coordinates.drop(2)).toMutableList()
            )
            Orientation.E -> CartesianCoordinates(
                dimension = dimension,
                coordinates = (mutableListOf(
                    coordinates[0] + distance,
                    coordinates[1]
                ) + coordinates.drop(2)).toMutableList()
            )
            Orientation.W -> CartesianCoordinates(
                dimension = dimension,
                coordinates = (mutableListOf(
                    coordinates[0] - distance,
                    coordinates[1]
                ) + coordinates.drop(2)).toMutableList()
            )
        }
    }

    override fun report(coordinatesReporter: CoordinatesReporter) {
        coordinatesReporter.reportCartesian(coordinates)
    }
}