package roverproblem.surface.interfaces

import roverproblem.coordinates.Coordinates

interface SurfaceLocationReporter {
    fun report(coordinates: Coordinates)
}