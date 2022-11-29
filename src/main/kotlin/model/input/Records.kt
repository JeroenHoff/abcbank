package model.input

class Records {
    private var records: Collection<Record> = mutableListOf()

    fun getRecords() : Collection<Record> {
        return records
    }

    fun setRecord(record : Collection<Record>) {
        records = record
    }

}
