package roverproblem

import roverproblem.interfaces.CartesianVectorReporter

class CartesianVector(
    private val vectorPoints : List<Int>
){
    fun report(cartesianVectorReporter : CartesianVectorReporter){
        cartesianVectorReporter.report(vectorPoints)
    }
}
