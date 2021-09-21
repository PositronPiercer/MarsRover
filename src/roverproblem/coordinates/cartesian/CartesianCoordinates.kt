package roverproblem.coordinates.cartesian

import roverproblem.Orientation
import roverproblem.coordinates.Coordinates
import roverproblem.coordinates.interfaces.CoordinatesReporter
import roverproblem.interfaces.CartesianVectorReporter

class CartesianCoordinates(
    private val coordinates: List<Int>
) : Coordinates() {
    private val dimension = coordinates.size
    fun reportCartesian2d(coordinatesReporter: CoordinatesReporter){
        coordinatesReporter.reportCartesian2d(coordinates[0], coordinates[1])
    }
    private fun getDelta(distance: Int, direction: Orientation) : CartesianCoordinates {
        val unitVector = direction.cartesianUnitVector
        lateinit var unitVectorPoints : List<Int>
        unitVector.report(object : CartesianVectorReporter{
            override fun report(vectorPoints: List<Int>) {
                unitVectorPoints = vectorPoints
            }
        })
        val unitVectorDimension = unitVectorPoints.size
        val delta = unitVectorPoints.map { unitVectorPoint ->
            distance * unitVectorPoint
        }
        return CartesianCoordinates(
            coordinates = delta + List(dimension - unitVectorDimension){0}
        )
    }

    override fun atDelta(distance: Int, direction: Orientation) : CartesianCoordinates {
        val delta = getDelta(distance, direction)
        return this.add(delta)
    }

    fun add(delta: CartesianCoordinates): CartesianCoordinates {
        val newCoordinatesList = mutableListOf<Int>()
        lateinit var deltaCoordinates : List<Int>
        val coordinatesReporter = object : CoordinatesReporter {
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