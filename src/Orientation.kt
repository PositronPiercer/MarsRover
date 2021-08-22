enum class Orientation {
    N, E, S, W;
    companion object {
        fun fromChar(orientation: Char){
            when(orientation){
                'N' -> N
                'S' -> S
                'E' -> E
                'W' -> W
            }
        }
    }
    fun left() : Orientation = values()[((this.ordinal - 1) + 4) % 4]
    fun right() : Orientation = values()[((this.ordinal + 1) + 4) % 4]
}