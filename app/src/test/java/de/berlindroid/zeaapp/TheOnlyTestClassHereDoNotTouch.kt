package de.berlindroid.zeaapp

import android.os.CountDownTimer
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.atLeastOnce
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations.initMocks

class TheOnlyTestClassHereDoNotTouch {

    lateinit var classUnderTest: CountDownTimer

    @Mock
    lateinit var onTickActionMock: (String) -> Unit

    @Mock
    lateinit var onFinishTimerMock: () -> Unit

    @Before
    fun setup() {
        initMocks(this)
        classUnderTest = TheOnlyClassCoveredWithTestYOLO(
            onTickAction = onTickActionMock,
            onFinishCountdownAction = onFinishTimerMock
        )
    }

    @Test
    fun onTickActionActuallyInvoked() {
        classUnderTest.onTick(4000)
        verify(onTickActionMock, atLeastOnce()).invoke("ACHTUNG!!! Time until SWAGGIFY left: 4")
    }

    @Test
    fun onFinishActionActuallyInvoked() {
        classUnderTest.onFinish()
        verify(onFinishTimerMock, atLeastOnce()).invoke()
    }
}