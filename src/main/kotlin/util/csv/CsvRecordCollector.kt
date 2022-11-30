package util.csv

import model.input.Record
import util.csv.csvReader

class CsvRecordCollector {

    val csvReader = csvReader()

    fun getRecords(filePath : String) : List<Record> {
        val items : List<Record> = csvReader.readCsvFile(filePath)
        return items
    }
}