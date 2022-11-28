package model.input

import java.math.BigDecimal
import java.time.LocalDate

data class Record(
    var reference : String,
    var accountNumber : String,
    var description : String,
    var startBalance : BigDecimal,
    var mutation : Char,
    var endBalance : BigDecimal,
    var transactionDate : LocalDate
)


