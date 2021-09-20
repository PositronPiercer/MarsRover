import interfaces.CoordinatesReporter

class Plateau(
    private var length : Int,
    private var width : Int
) : Surface() {
    override fun inBounds(coordinates: Coordinates): Boolean {
        var x_ = 0
        var y_ = 0
        val coordinatesReporter = object : CoordinatesReporter{
            override fun reportCartesian2d(x: Int, y: Int) {
                //TODO Is this the right way?
                x_ = x
                y_ = y
            }
        }
        coordinates.report(coordinatesReporter)
        return (x_ <= length) && (y_ <= width) && (x_ >= 0) && (y_ >= 0)
    }
}