package com.nbialas.warsstarapp.breakTime

fun isThereABreak(currentTime: Int, startTime: Int, endTime: Int): Boolean {
    if (startTime <= endTime) {
        return currentTime in startTime..endTime
    } else {
        if (currentTime >= startTime || currentTime <= endTime) {
            return true
        }
        return false
    }
}