package model.input

import java.math.BigDecimal
import java.time.LocalDate
class Record {
    lateinit var reference: String
    lateinit var accountNumber: String
    lateinit var description: String
    lateinit var startBalance: BigDecimal
    lateinit var mutation: BigDecimal
    lateinit var endBalance: BigDecimal
    lateinit var transactionDate: LocalDate
}


