class Rover(
    initialPosition: Position
    ) {
    private val _position : Position = initialPosition
    val position : Position
        get() = _position

    private fun rotateLeft(){
        _position.orientation = _position.orientation.left()
    }
    private fun rotateRight(){
        _position.orientation = _position.orientation.right()
    }
    private fun moveForward(){
        _position.location = when(_position.orientation){
            Orientation.N -> Location(_position.location.x, _position.location.y + 1)
            Orientation.S -> Location(_position.location.x, _position.location.y - 1)
            Orientation.E -> Location(_position.location.x + 1, _position.location.y)
            Orientation.W -> Location(_position.location.x - 1, _position.location.y)
        }
    }
    fun move(commands : String){
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
            var location: Location,
            var orientation: Orientation
        )
    }
}