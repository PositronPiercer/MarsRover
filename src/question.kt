import interfaces.CoordinatesReporter
import interfaces.RoverPositionReporter
import java.io.File

fun main(){
    val inputFile = File("C:\\Users\\shaik\\Documents\\MarsRover\\src\\input.txt")
    val outputFile = File("C:\\Users\\shaik\\Documents\\MarsRover\\src\\output.txt")
    outputFile.writeText("")
    val lines = inputFile.readLines()
    val fileOutRoverPositionReporter = object : RoverPositionReporter{
        override fun report(x: Int, y: Int, orientation: Orientation) {
            outputFile.appendText("$x $y $orientation \n")
        }
    }

    //get plateau size
    val trX = lines[0].split(" ")[0].toInt()
    val trY = lines[0].split(" ")[1].toInt()

    val plateau = Plateau(
        length = trX,
        width = trY
    )
    for (lineNo in 1 until lines.size step 2){
        val splitLine = lines[lineNo].split(" ")
        val x = splitLine[0].toInt()
        val y = splitLine[1].toInt()
        val facing = splitLine[2][0]

        val rover = Rover(
            location = Coordinates.fromCartesian2d(x, y),
            orientation = Orientation.fromChar(facing),
            surface = plateau
        )
        val commands = lines[lineNo + 1]
        rover.move(commands)
        rover.reportPosition(fileOutRoverPositionReporter)
    }


}