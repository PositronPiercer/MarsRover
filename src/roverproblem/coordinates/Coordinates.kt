package roverproblem.coordinates

import roverproblem.coordinates.cartesian.CartesianCoordinates
import roverproblem.Orientation
import roverproblem.coordinates.interfaces.CoordinatesReporter

abstract class Coordinates() {
    companion object{
        fun fromCartesian2d(x : Int, y : Int) : Coordinates = CartesianCoordinates(
            coordinates = listOf(x, y)
        )
    }
    abstract fun atDelta(distance : Int, direction : Orientation) : Coordinates
    abstract fun report(coordinatesReporter: CoordinatesReporter)
}