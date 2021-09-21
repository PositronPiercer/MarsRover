package roverproblem.surface

import roverproblem.Orientation
import roverproblem.surface.interfaces.SurfaceLocationReporter

abstract class SurfaceLocation(
    surface: Surface
){
    abstract fun report(surfaceLocationReporter: SurfaceLocationReporter)
    abstract fun atDelta(distance: Int, direction: Orientation) : SurfaceLocation
}
