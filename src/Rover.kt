import interfaces.CoordinatesReporter
import interfaces.RoverPositionReporter
import java.lang.IllegalStateException

class Rover(
    private var location : Coordinates,
    private var orientation: Orientation,
    private var surface: Surface
    ) {
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
        //TODO add new commands in future
        when(command){
            'L' -> rotateLeft()
            'R' -> rotateRight()
            'M' -> moveForward()
            else -> throw IllegalArgumentException("Unknown Command")
        }
    }
    fun move(commands : String){
        //TODO indentation
        for (command : Char in commands){
            execute(command)
        }
    }
}