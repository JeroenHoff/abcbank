package util.xml

import model.input.Record


class XmlRecordCollector {

    val xmlReader = XmlReader()

    fun getRecords(filePath : String) : List<Record> {
        val items : List<Record> = xmlReader.readXmlFile(filePath)
        return items
    }
}