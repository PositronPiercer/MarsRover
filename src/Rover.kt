import interfaces.CoordinatesReporter
import interfaces.RoverPositionReporter
import java.lang.IllegalArgumentException
import java.lang.IllegalStateException

class Rover(
    private var location : Coordinates,
    private var orientation: Orientation,
    private var surface: Surface
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
        val newLocation = location.atDelta(
            distance = 1,
            direction = orientation
        )
        location = if (surface.inBounds(newLocation)){
            //TODO remove conditional
            newLocation
        }
        else{
            //TODO this check should be done by the plateau
            throw IllegalStateException("Rover location out of surface")
        }
    }
    fun reportPosition(roverPositionReporter: RoverPositionReporter){
        val coordinatesReporter = object : CoordinatesReporter {
            override fun reportCartesian2d(x: Int, y: Int) {
                roverPositionReporter.report(x, y, orientation)
            }
        }
        location.report(coordinatesReporter)
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