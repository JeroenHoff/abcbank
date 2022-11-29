package model.input

import java.math.BigDecimal
import java.time.LocalDate
data class Record (
    val reference: String,
    val accountNumber: String,
    val description: String,
    val startBalance: BigDecimal,
    val mutation: BigDecimal,
    val endBalance: BigDecimal,
    val transactionDate: LocalDate
)


