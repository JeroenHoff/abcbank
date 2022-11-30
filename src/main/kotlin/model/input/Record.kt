package model.input

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import java.math.BigDecimal
import java.time.LocalDate

data class Record (

    @JsonProperty("Reference")
    @JsonAlias("reference")
    val reference: String,
    @JsonProperty("Account Number")
    @JsonAlias("accountNumber")
    val accountNumber: String,
    @JsonProperty("Description")
    @JsonAlias("description")
    val description: String,
    @JsonProperty("Start Balance")
    @JsonAlias("startBalance")
    val startBalance: BigDecimal,
    @JsonProperty("Mutation")
    @JsonAlias("mutation")
    val mutation: BigDecimal,
    @JsonProperty("End Balance")
    @JsonAlias("endBalance")
    val endBalance: BigDecimal,
    @JacksonXmlProperty(localName = "date")
    @JsonProperty("Transaction Date")
    val transactionDate: LocalDate
)


