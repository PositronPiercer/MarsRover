package interfaces

interface CoordinatesReporter {
    fun reportCartesian2d(x : Int, y : Int){}
    fun reportCartesian(coordinates : List<Int>){
        if (coordinates.size == 2){
            reportCartesian2d(coordinates[0], coordinates[1])
        }
    }
}