class Plateau(
    topRightCoordinates : Coordinates
) : Surface() {
    private val length = topRightCoordinates.x
    private val width = topRightCoordinates.y
    override fun inBounds(coordinates: Coordinates): Boolean {
        return (coordinates.x <= length) && (coordinates.y <= width)
    }
}