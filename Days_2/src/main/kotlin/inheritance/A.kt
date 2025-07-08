package com.works.inheritance

class A : Base {

    constructor(data: String) : super(data) {
    }

    override fun call() {
        val end = action(10)
        println("A : $end")
    }

    fun call2() {
        super.call()
        println("call 2 called")
    }

}