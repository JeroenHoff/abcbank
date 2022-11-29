package util
import model.input.Record
import model.input.Records
import model.output.ProcessorResult
import model.output.ProcessorResults
import java.math.BigDecimal
import java.util.*
import java.util.stream.Collectors


class RecordValidator {



//    private fun validate(records: List<Record>) : ProcessorResults {
//        return records
//            .parallelStream()
//            .filter(record -> isReference)
//    }

//    fun validate(records: Records) : ProcessorResults {
//        val results = ProcessorResults()
//    }



    private fun isReferenceUnique(records: Records, record: Record): Boolean {
        return Collections.frequency(records, record) == 1
    }

    private fun isEndBalanceCorrect(record : Record) : Boolean {
        return record.startBalance.add(record.mutation).equals(record.endBalance)
    }

    private fun isStartBalanceZeroOrPositive(record: Record) : Boolean {
        return record.startBalance >= BigDecimal.ZERO
    }

    private fun isEndBalanceZeroOrPositive(record: Record) : Boolean {
        return record.endBalance >= BigDecimal.ZERO
    }

    private fun addResult(record: Record) : ProcessorResult {
        val result = ProcessorResult()
        result.reference = record.reference
        result.description = record.description
        return result
    }
}