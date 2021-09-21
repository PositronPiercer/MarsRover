package roverproblem.surface.plateau

import roverproblem.coordinates.Coordinates
import roverproblem.Orientation
import roverproblem.surface.SurfaceLocation
import roverproblem.surface.interfaces.SurfaceLocationReporter
import java.lang.IllegalStateException

class PlateauLocation (
    private val coordinates: Coordinates,
    private val plateau: Plateau
        ): SurfaceLocation(plateau){
    init {
        if (!plateau.inBounds(this)){
            throw IllegalStateException("Location out of roverproblem.surface.plateau.Plateau")
        }
    }
    override fun report(surfaceLocationReporter: SurfaceLocationReporter) {
        surfaceLocationReporter.report(coordinates)
    }

    override fun atDelta(distance: Int, direction: Orientation): SurfaceLocation {
        return PlateauLocation(
            coordinates = coordinates.atDelta(distance, direction),
            plateau = plateau
        )
    }
}