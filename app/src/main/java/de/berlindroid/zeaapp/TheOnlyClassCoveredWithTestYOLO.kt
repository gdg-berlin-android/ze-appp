package de.berlindroid.zeaapp

import android.os.CountDownTimer

class TheOnlyClassCoveredWithTestYOLO(
    val onTickAction: ((String) -> Unit)? = null,
    val onFinishCountdownAction: () -> Unit,
    durationInMillis: Long = 5000,
    tickIntervalInMillis: Long = 500
) : CountDownTimer(durationInMillis, tickIntervalInMillis) {

    override fun onFinish() {
        onFinishCountdownAction()
    }

    override fun onTick(timeLeft: Long) {
        val secondsLeft = if (timeLeft / 1000 < 1) {
            0
        } else {
            timeLeft / 1000
        }
        onTickAction?.invoke("ACHTUNG!!! Time until SWAGGIFY left: $secondsLeft")
    }
}