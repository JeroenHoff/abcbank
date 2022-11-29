package model.input

import java.util.Collections

//abstract class Records : MutableCollection<Record> {
//    private lateinit var records: List<Record>
//}


class Records {
//    val records: List<Record> = mutableListOf()

    private var records: Collection<Record> = mutableListOf()

    fun getRecords() : Collection<Record> {
        return records
    }

    fun setRecord(record : Collection<Record>) {
        records = record
    }

}
