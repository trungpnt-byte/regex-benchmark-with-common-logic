object DigitValidatorUtil {

    //
    val DIGIT_PATTERN  = Regex("0[1-7][0-9][0-9][0-9][0-9]")

    fun regexValidateDigits(str : String?) : Boolean {
        return DIGIT_PATTERN.matches(str?.trim() ?: "")
    }

    fun commonValidateDigits(str : String?) : Boolean {
        if (str.isNullOrBlank()) {
            return false
        }
        if (str[0] != '0') {
            return false
        }
        var expectedCount = 5
        for (i in 1 until str.length) {
            val ch = str[i]
            if (ch.isWhitespace()) {
                continue
            }
            val toRange = if (i == 1) '7' else '9'
            if (isInDigitRange(
                    char = ch,
                    from = '0',
                    to = toRange
                )) {
                expectedCount--
            } else {
                return false
            }
        }
        return expectedCount == 0
    }

    private fun isInDigitRange(char : Char, from : Char, to : Char) : Boolean {
        return char in from..to
    }
}