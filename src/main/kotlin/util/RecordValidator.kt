package util
import model.input.Record
import model.input.Records
import model.output.ProcessorResult
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*
import java.util.stream.Collectors


class RecordValidator {

//    fun validate(records: Records) : List<ProcessorResult> {
//        return records
//            .parallelStream()
//            .filter { record -> isReferenceUnique(records, record) || isEndBalanceCorrect(record) || isStartBalanceZeroOrPositive(record) || isEndBalanceZeroOrPositive(record)}
//            .map{ record -> addResult(record)}
//            .collect(Collectors.toList())
//    }

    fun validate(records: Records) : List<ProcessorResult> {

        val references : List<String> = records.getRecords().parallelStream().map { record -> record.reference } .collect(Collectors.toList())

        return records.getRecords()
            .parallelStream()
            .filter { record -> isReferenceNotUnique(references, record) || isEndBalanceIncorrect(record) || isStartBalanceNegative(record) || isEndBalanceNegative(record) || isFutureDate(record)}
            .map{ record -> addResult(record)}
            .collect(Collectors.toList())
    }

    private fun isReferenceNotUnique(references : List<String>, record: Record): Boolean {
        return Collections.frequency(references, record.reference) > 1
    }

    private fun isEndBalanceIncorrect(record : Record) : Boolean {
        return !record.startBalance.add(record.mutation).equals(record.endBalance)
    }

    private fun isStartBalanceNegative(record: Record) : Boolean {
        return record.startBalance < BigDecimal.ZERO
    }

    private fun isEndBalanceNegative(record: Record) : Boolean {
        return record.endBalance < BigDecimal.ZERO
    }

    private fun isFutureDate(record : Record) : Boolean {
        return record.transactionDate.isAfter(LocalDate.now())
    }

    private fun addResult(record: Record): ProcessorResult {
        return ProcessorResult(
            reference = record.reference,
            description = record.description)
    }
}