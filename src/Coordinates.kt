import interfaces.CoordinatesReporter

abstract class Coordinates() {
    companion object{
        fun fromCartesian2d(x : Int, y : Int) : Coordinates = CartesianCoordinates(
            dimension = 2,
            coordinates = listOf(x, y)
        )
    }
    abstract fun atDelta(distance : Int, direction : Orientation) : Coordinates
    abstract fun report(coordinatesReporter: CoordinatesReporter)
}