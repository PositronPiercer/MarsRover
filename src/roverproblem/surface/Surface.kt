package roverproblem.surface

import roverproblem.coordinates.Coordinates

abstract class Surface {
    abstract fun locationOnSurface(coordinates: Coordinates) : SurfaceLocation
}