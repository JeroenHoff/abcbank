package util.csv

import com.fasterxml.jackson.dataformat.csv.CsvMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.dataformat.csv.CsvSchema
import java.io.FileReader

class csvReader {

    val csvMapper = CsvMapper().apply {
        registerModule(KotlinModule())
    }

    inline fun <reified T> readCsvFile(fileName: String): List<T> {
        FileReader(fileName).use { reader ->
            return csvMapper
                .readerFor(T::class.java)
                .with(CsvSchema.emptySchema().withHeader())
                .readValues<T>(reader)
                .readAll()
                .toList()
        }
    }

}