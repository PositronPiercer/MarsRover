package roverproblem

import java.lang.IllegalArgumentException

enum class Orientation {
    N, E, S, W;
    companion object {
        private val char2OrientationMap = mapOf(
            'N' to N,
            'S' to S,
            'E' to E,
            'W' to W
        )
        fun fromChar(orientation: Char) : Orientation {
            return char2OrientationMap[orientation] ?:
            throw IllegalArgumentException("Unknown roverproblem.Orientation")
        }
    }
    fun left() : Orientation = values()[((this.ordinal - 1) + 4) % 4]
    fun right() : Orientation = values()[((this.ordinal + 1) + 4) % 4]
}