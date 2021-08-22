enum class Orientation {
    N, E, S, W;
    companion object {
        fun fromChar(orientation: Char) : Orientation{
            return when(orientation){
                'N' -> N
                'S' -> S
                'E' -> E
                'W' -> W
                else -> throw IllegalArgumentException("Unknown Orientation")
            }
        }
    }
    fun left() : Orientation = values()[((this.ordinal - 1) + 4) % 4]
    fun right() : Orientation = values()[((this.ordinal + 1) + 4) % 4]
}