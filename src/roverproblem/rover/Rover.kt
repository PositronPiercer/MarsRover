package roverproblem.rover

import roverproblem.coordinates.Coordinates
import roverproblem.Orientation
import roverproblem.surface.SurfaceLocation
import roverproblem.coordinates.interfaces.CoordinatesReporter
import roverproblem.rover.interfaces.RoverPositionReporter
import roverproblem.surface.interfaces.SurfaceLocationReporter
import java.lang.IllegalArgumentException

class Rover(
    private var location: SurfaceLocation,
    private var orientation: Orientation
) {
    private val roverCommands = mapOf(
        'L' to { rotateLeft() },
        'R' to { rotateRight() },
        'M' to { moveForward() }
    )
    private fun rotateLeft(){
        orientation = orientation.left()
    }
    private fun rotateRight(){
        orientation = orientation.right()
    }
    private fun moveForward(){
        location = location.atDelta(
            distance = 1,
            direction = orientation
        )
    }
    fun reportPosition(roverPositionReporter: RoverPositionReporter){
        val coordinatesReporter = object : CoordinatesReporter {
            override fun reportCartesian2d(x: Int, y: Int) {
                roverPositionReporter.report(x, y, orientation)
            }
        }
        val surfaceLocationReporter = object : SurfaceLocationReporter {
            override fun report(coordinates: Coordinates) {
                coordinates.report(coordinatesReporter)
            }
        }
        location.report(surfaceLocationReporter)
    }
    private fun execute(command : Char){
        roverCommands[command]?.let {
            it()
        }?: run{
            throw IllegalArgumentException("Unknown Command")
        }
    }
    fun move(commands : String){
        for (command : Char in commands){
            execute(command)
        }
    }
}