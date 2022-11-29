package model.output

abstract class ProcessorResults : MutableCollection<ProcessorResult> {
    private lateinit var results : List<ProcessorResult>
}