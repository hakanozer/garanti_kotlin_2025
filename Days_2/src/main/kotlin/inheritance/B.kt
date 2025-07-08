package com.works.inheritance

class B : Base {

    constructor(data: String) : super(data) {
    }

    override fun call() {
        val end = action(20)
        println("B : $end")
    }

}