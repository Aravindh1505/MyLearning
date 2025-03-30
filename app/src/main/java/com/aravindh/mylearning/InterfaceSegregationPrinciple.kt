package com.aravindh.mylearning

fun main() {

    val clickAction = PerformClickAction()
    clickAction.onCLick()
    clickAction.onLongClick()

}

interface ClickAction {
    fun onCLick()
}

interface LoginClickAction {
    fun onLongClick()
}

interface DoubleClickAction {
    fun onDoubleClick()
}

class PerformClickAction : ClickAction , LoginClickAction {
    override fun onCLick() {
        println("Click action performed")
    }

    override fun onLongClick() {
        println("Long click action performed")
    }
}