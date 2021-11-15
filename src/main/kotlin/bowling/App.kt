package bowling

import bowling.domain.frame.Frames
import bowling.domain.frame.Name
import bowling.view.InputView
import bowling.view.OutputView

fun main() {
    val playerName = InputView.getPlayerName()
    val frames = Frames(Name(playerName))
    play(frames)
}

private fun play(frames: Frames) {
    while (frames.ableToPitch()) {
        val currentFrameNumber = frames.currentFrameNumber()
        val pitchCount = InputView.getPitchCount(currentFrameNumber)
        frames.pitch(pitchCount)
        OutputView.printCurrent(frames)
    }
}