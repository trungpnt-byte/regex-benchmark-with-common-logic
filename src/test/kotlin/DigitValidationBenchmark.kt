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
            Assertions.assertEquals(TRUE_EXPECTED, DigitValidatorUtil.regexValidateDigits(VALID_INPUT))
            Assertions.assertEquals(FALSE_EXPECTED, DigitValidatorUtil.regexValidateDigits(INVALID_INPUT))
        }
    }

    fun timeCommonValidateDigits(reps: Int) {
        for (i in 0..<reps) {
            Assertions.assertEquals(TRUE_EXPECTED, DigitValidatorUtil.commonValidateDigits(VALID_INPUT))
            Assertions.assertEquals(FALSE_EXPECTED, DigitValidatorUtil.commonValidateDigits(INVALID_INPUT))
        }
    }

    @Test
    @Throws(Exception::class)
    fun testRegexValidateDigits() {
        Assertions.assertEquals(TRUE_EXPECTED, DigitValidatorUtil.regexValidateDigits(VALID_INPUT))
        Assertions.assertEquals(FALSE_EXPECTED, DigitValidatorUtil.regexValidateDigits(INVALID_INPUT))
    }

    @Test
    @Throws(Exception::class)
    fun testCommonValidateDigits() {
        Assertions.assertEquals(TRUE_EXPECTED, DigitValidatorUtil.commonValidateDigits(VALID_INPUT))
        Assertions.assertEquals(FALSE_EXPECTED, DigitValidatorUtil.commonValidateDigits(INVALID_INPUT))
    }

    companion object {
        private val VALID_INPUT = "074567"
        private val INVALID_INPUT = "084567"
        private const val TRUE_EXPECTED = true
        private const val FALSE_EXPECTED = false
    }
}