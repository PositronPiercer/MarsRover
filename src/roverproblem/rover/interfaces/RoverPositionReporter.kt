package roverproblem.rover.interfaces

import roverproblem.Orientation

interface RoverPositionReporter {
    fun report(x : Int, y : Int, orientation: Orientation)
}