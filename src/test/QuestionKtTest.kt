import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.File

internal class QuestionKtTest{
    @Test
    fun `output file should match correct_output file` (){
        main()
        val correctOutputFile = File("C:\\Users\\shaik\\Documents\\MarsRover\\src\\roverproblem\\correct_output.txt")
        val outputFile = File("C:\\Users\\shaik\\Documents\\MarsRover\\src\\roverproblem\\output.txt")
        assertEquals(correctOutputFile.readText(), outputFile.readText())
    }
}