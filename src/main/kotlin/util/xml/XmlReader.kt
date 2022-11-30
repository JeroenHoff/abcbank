package util.xml

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.csv.CsvMapper
import com.fasterxml.jackson.dataformat.csv.CsvSchema
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinModule
import java.io.FileReader

class XmlReader {

//    val xmlMapper = ObjectMapper().registerModule(KotlinModule()).registerModule(JavaTimeModule())

    val objectMapper : ObjectMapper = XmlMapper().registerModule(KotlinModule()).registerModule(JavaTimeModule())

    inline fun <reified T> readXmlFile(fileName: String): List<T> {
        FileReader(fileName).use { reader ->
            return objectMapper
                .readerFor(T::class.java)
//                .with(CsvSchema.emptySchema().withHeader())
                .readValues<T>(reader)
                .readAll()
                .toList()
        }
    }
}