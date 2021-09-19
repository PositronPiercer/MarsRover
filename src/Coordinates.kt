import interfaces.CoordinatesReporter

abstract class Coordinates() {
    companion object{
        fun fromCartesian2d(x : Int, y : Int) : Coordinates = CartesianCoordinates(
            coordinates = listOf(x, y)
        )
    }
    abstract fun atDelta(distance : Int, direction : Orientation) : Coordinates
    abstract fun report(coordinatesReporter: CoordinatesReporter)
}