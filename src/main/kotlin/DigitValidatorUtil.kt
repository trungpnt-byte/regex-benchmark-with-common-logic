object DigitValidatorUtil {

    val DIGIT_PATTERN  = Regex("0[1-7][0-9][0-9][0-9][0-9]")

    fun regexValidateDigits(str : String?) : Boolean {
        return DIGIT_PATTERN.matches(str ?: "")
    }

    fun commonValidateDigits(str : String?) : Boolean {
        if (str.isNullOrBlank() || str[0] != '0') {
            return false
        }
        var expectedCount = 5
        for (i in 1 until str.length) {
            val ch = str[i]
            val toRange = if (i == 1) '7' else '9'
            if (ch in '0' .. toRange) {
                expectedCount--
            } else {
                return false
            }
        }
        return expectedCount == 0
    }
}