package roverproblem.surface.plateau

import roverproblem.coordinates.Coordinates
import roverproblem.surface.SurfaceLocation
import roverproblem.coordinates.interfaces.CoordinatesReporter
import roverproblem.surface.interfaces.SurfaceLocationReporter
import roverproblem.surface.Surface

class Plateau(
    private var length : Int,
    private var width : Int
) : Surface() {
    fun inBounds(location: PlateauLocation): Boolean {
        var x_ = 0
        var y_ = 0
        val coordinatesReporter = object : CoordinatesReporter {
            override fun reportCartesian2d(x: Int, y: Int) {
                //TODO Is this the right way?
                x_ = x
                y_ = y
            }
        }
        val plateauLocationReporter = object : SurfaceLocationReporter {
            override fun report(coordinates: Coordinates) {
                coordinates.report(coordinatesReporter)
            }
        }
        location.report(plateauLocationReporter)

        return (x_ <= length) && (y_ <= width) && (x_ >= 0) && (y_ >= 0)
    }

    override fun locationOnSurface(coordinates: Coordinates): SurfaceLocation {
        return PlateauLocation(coordinates, this)
    }
}