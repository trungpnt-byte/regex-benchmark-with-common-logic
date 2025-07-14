import com.google.caliper.Param
import com.google.caliper.Runner
import com.google.caliper.SimpleBenchmark
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class DigitValidationBenchmark : SimpleBenchmark() {

    @Test
    @Throws(Exception::class)
    fun benchmark() {
        Runner.main(DigitValidationBenchmark::class.java, arrayOfNulls<String>(0))
    }

    @Param("0", "10", "100", "1000")
    private val length = 0

    fun timeRegexValidateDigits(reps: Int) {
        for (i in 0..<reps) {
            VALID_INPUTS.forEach {
                Assertions.assertEquals(TRUE_EXPECTED, DigitValidatorUtil.regexValidateDigits(it))
            }
            INVALID_INPUTS.forEach {
                Assertions.assertEquals(FALSE_EXPECTED, DigitValidatorUtil.regexValidateDigits(it))
            }
        }
    }

    fun timeCommonValidateDigits(reps: Int) {
        for (i in 0..<reps) {
            VALID_INPUTS.forEach {
                Assertions.assertEquals(TRUE_EXPECTED, DigitValidatorUtil.commonValidateDigits(it))
            }
            INVALID_INPUTS.forEach {
                Assertions.assertEquals(FALSE_EXPECTED, DigitValidatorUtil.commonValidateDigits(it))
            }
        }
    }

    @Test
    @Throws(Exception::class)
    fun testRegexValidateDigits() {
        VALID_INPUTS.forEach {
            Assertions.assertEquals(TRUE_EXPECTED, DigitValidatorUtil.regexValidateDigits(it))
        }
        INVALID_INPUTS.forEach {
            Assertions.assertEquals(FALSE_EXPECTED, DigitValidatorUtil.regexValidateDigits(it))
        }
    }

    @Test
    @Throws(Exception::class)
    fun testCommonValidateDigits() {
        VALID_INPUTS.forEach {
            Assertions.assertEquals(TRUE_EXPECTED, DigitValidatorUtil.commonValidateDigits(it))
        }
        INVALID_INPUTS.forEach {
            Assertions.assertEquals(FALSE_EXPECTED, DigitValidatorUtil.commonValidateDigits(it))
        }
    }

    companion object {
        private val VALID_INPUTS = listOf("074567","021111", "021342","012342")
        private val INVALID_INPUTS = listOf("08456781029481204981209432109831", null, "","    ", "110000","0799910","089342")
        private const val TRUE_EXPECTED = true
        private const val FALSE_EXPECTED = false
    }
}