package interfaces

import Orientation

interface RoverPositionReporter {
    fun report(x : Int, y : Int, orientation: Orientation)
}