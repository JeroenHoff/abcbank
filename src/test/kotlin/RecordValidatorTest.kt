import model.input.Record
import model.input.Records
import org.junit.jupiter.api.Test
import util.RecordValidator
import java.math.BigDecimal
import java.time.LocalDate
import org.junit.jupiter.api.Assertions.assertEquals


class RecordValidatorTest {

    @Test
    fun testValidate() {

        var records = Records()
        var validator = RecordValidator()

        records.setRecord(getDummyRecords())

        println(validator.validate(records))

        assertEquals(6, validator.validate(records).size)
    }

    private fun getDummyRecords() : List<Record> {
        val someRecords : MutableList<Record> = mutableListOf()

        // Incorrect (6)
        someRecords.add(Record("00", "NL01RABO99", "Repeated reference", BigDecimal("500"), BigDecimal("-150"), BigDecimal("350"), LocalDate.now()))
        someRecords.add(Record("00", "NL01RABO99", "Repeated reference", BigDecimal("350"), BigDecimal("150"), BigDecimal("500"), LocalDate.now()))
        someRecords.add(Record("01", "NL01RABO100", "End balance incorrect", BigDecimal("500"), BigDecimal("500"), BigDecimal("500"), LocalDate.now()))
        someRecords.add(Record("03", "NL01RABO101", "Start balance below zero", BigDecimal("-50"), BigDecimal("100"), BigDecimal("50"), LocalDate.now()))
        someRecords.add(Record("04", "NL01RABO102", "End balance below zero", BigDecimal("50"), BigDecimal("-100"), BigDecimal("-50"), LocalDate.now()))
        someRecords.add(Record("05", "NL01RABO103", "Transaction date in the future (year 2050)", BigDecimal("100"), BigDecimal("500"), BigDecimal("600"), LocalDate.of(2050,1,1)))

        // Correct (3)
        someRecords.add(Record("06", "NL01RABO104", "Correct transaction", BigDecimal("100"), BigDecimal("200"), BigDecimal("300"), LocalDate.now()))
        someRecords.add(Record("07", "NL01RABO104", "Correct transaction", BigDecimal("300"), BigDecimal("100"), BigDecimal("400"), LocalDate.now()))
        someRecords.add(Record("08", "NL01RABO105", "Correct transaction", BigDecimal("600"), BigDecimal("-100"), BigDecimal("500"), LocalDate.now()))

        return someRecords
    }
}