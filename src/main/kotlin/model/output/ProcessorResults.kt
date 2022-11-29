package model.output

class ProcessorResults {

    private var result : Collection<ProcessorResult> = mutableListOf()

    fun getResult() : Collection<ProcessorResult> {
        return result
    }

    fun setResult(someResult : Collection<ProcessorResult>) {
        result = someResult
    }
}