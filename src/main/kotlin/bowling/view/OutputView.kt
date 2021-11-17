package bowling.view

import bowling.domain.frame.Frame
import bowling.domain.frame.Frames

class OutputView {
    companion object {
        fun printCurrent(frames: Frames) {
            printHeader()
            printBody(frames)
        }

        private fun printHeader() {
            println("| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |")
        }

        private fun printBody(frames: Frames) {
            val stringBuilder = StringBuilder()
            appendName(stringBuilder, frames)

            for (frame in frames.current()) {
                appendFrameCurrent(frame, stringBuilder)
            }

            appendBelow(frames, stringBuilder)
            println(stringBuilder)
        }

        private fun appendBelow(frames: Frames, stringBuilder: StringBuilder) {
            for (i in frames.current().size + 1..10) {
                stringBuilder.append("      |")
            }
        }

        private fun appendFrameCurrent(frame: Frame, stringBuilder: StringBuilder) {
            val desc = frame.current()
                .joinToString("|") { it.print() }

            stringBuilder.append(" ${desc.padEnd(5, ' ')}|")
        }

        private fun appendName(stringBuilder: StringBuilder, frames: Frames) {
            stringBuilder.append("| ")
            val name = frames.name()
                .toString()
                .padEnd(5, ' ')
            stringBuilder.append(name)
            stringBuilder.append("|")
        }
    }
}