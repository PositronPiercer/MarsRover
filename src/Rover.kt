import java.lang.IllegalStateException

class Rover(
    initialPosition: Position,
    val surface: Surface
    ) {
    private val _position : Position = initialPosition
    val position : Position
        get() = _position

    private fun rotateLeft(){
        _position.orientation = _position.orientation.left()
        //TODO position.left
    }
    private fun rotateRight(){
        _position.orientation = _position.orientation.right()
    }
    private fun moveForward(){
        val newLocation = when(_position.orientation){
            //TODO coordiates = coordinate.left
            Orientation.N -> Coordinates(_position.location.x, _position.location.y + 1)
            Orientation.S -> Coordinates(_position.location.x, _position.location.y - 1)
            Orientation.E -> Coordinates(_position.location.x + 1, _position.location.y)
            Orientation.W -> Coordinates(_position.location.x - 1, _position.location.y)
        }
        _position.location = if (surface.inBounds(newLocation)){
            newLocation
        }
        else{
            throw IllegalStateException("Rover location out of bounds")
        }
    }
    fun move(commands : String){
        //TODO indentation
        for (command : Char in commands){
            when(command){
                'L' -> rotateLeft()
                'R' -> rotateRight()
                'M' -> moveForward()
                else -> throw IllegalArgumentException("Unknown Command")
            }
        }
    }

    companion object{
        data class Position(
            var location: Coordinates,
            var orientation: Orientation
        )
    }
}