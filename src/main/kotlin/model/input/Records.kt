package model.input

import java.util.Collections

abstract class Records : MutableCollection<Record> {
    private lateinit var records: List<Record>
}
