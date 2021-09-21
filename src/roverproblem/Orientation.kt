package roverproblem

import java.lang.IllegalArgumentException

enum class Orientation {
    N{
     override val cartesianUnitVector = CartesianVector(listOf(
         0, 1
     ))
     },
    E{
        override val cartesianUnitVector = CartesianVector(listOf(
            1, 0
        ))
     },
    S{
        override val cartesianUnitVector = CartesianVector(listOf(
            0, -1
        ))
     },
    W{
        override val cartesianUnitVector = CartesianVector(listOf(
            -1, 0
        ))
    };
    companion object {
        private val char2OrientationMap = mapOf(
            'N' to N,
            'S' to S,
            'E' to E,
            'W' to W
        )
        fun fromChar(orientation: Char) : Orientation {
            return char2OrientationMap[orientation] ?:
            throw IllegalArgumentException("Unknown Orientation")
        }
    }
    abstract val cartesianUnitVector : CartesianVector
    fun left() : Orientation = values()[((this.ordinal - 1) + 4) % 4]
    fun right() : Orientation = values()[((this.ordinal + 1) + 4) % 4]
}