package bowling.state.finished

class Strike : Finished() {
    companion object {
        private const val DESC = "X"
    }

    override fun print() = DESC
}