package com.nbialas.warsstarapp

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.nbialas.warsstarapp.breakTime.isThereABreak
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BreakTest {
    @Test
    fun testIsABrakeTimeDay() {
        Assert.assertEquals(true, isThereABreak(12, 8, 15))
        Assert.assertEquals(false, isThereABreak(4, 6, 12))
        Assert.assertEquals(false, isThereABreak(14, 18, 19))
        Assert.assertEquals(true, isThereABreak(16, 10, 19))
    }

    @Test
    fun testIsABrakeTimeNight() {
        Assert.assertEquals(true, isThereABreak(23, 22, 4))
        Assert.assertEquals(false, isThereABreak(0, 1, 4))
        Assert.assertEquals(true, isThereABreak(4, 23, 4))
        Assert.assertEquals(true, isThereABreak(0, 0, 0))
        Assert.assertEquals(true, isThereABreak(22, 5, 3))
        Assert.assertEquals(false, isThereABreak(21, 23, 20))
    }
}

