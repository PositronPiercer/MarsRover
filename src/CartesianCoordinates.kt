import interfaces.CoordinatesReporter
import java.lang.IllegalStateException

class CartesianCoordinates(
    private val coordinates: List<Int>
) : Coordinates() {
    fun reportCartesian2d(coordinatesReporter: CoordinatesReporter){
        coordinatesReporter.reportCartesian2d(coordinates[0], coordinates[1])
    }

    override fun atDelta(distance: Int, direction: Orientation) : CartesianCoordinates {
        return when(direction){
            Orientation.N -> CartesianCoordinates(
                coordinates = listOf(
                    coordinates[0],
                    coordinates[1] + distance
                ) + coordinates.drop(2)
            )
            Orientation.S -> CartesianCoordinates(
                coordinates = listOf(
                    coordinates[0],
                    coordinates[1] - distance
                ) + coordinates.drop(2)
            )
            Orientation.E -> CartesianCoordinates(
                coordinates = listOf(
                    coordinates[0] + distance,
                    coordinates[1]
                ) + coordinates.drop(2)
            )
            Orientation.W -> CartesianCoordinates(
                coordinates = listOf(
                    coordinates[0] - distance,
                    coordinates[1]
                ) + coordinates.drop(2)
            )
        }
    }

    override fun report(coordinatesReporter: CoordinatesReporter) {
        coordinatesReporter.reportCartesian(coordinates)
    }
}