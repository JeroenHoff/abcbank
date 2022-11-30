package model.input

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import java.math.BigDecimal
import java.time.LocalDate


data class Record (

    val reference: String,
    val accountNumber: String,
    val description: String,
    val startBalance: BigDecimal,
    val mutation: BigDecimal,
    val endBalance: BigDecimal,
    @JacksonXmlProperty(localName = "date")
    val transactionDate: LocalDate
)


