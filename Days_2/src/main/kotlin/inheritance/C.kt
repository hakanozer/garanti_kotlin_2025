package com.works.inheritance

class C : Base {

    constructor(data: String) : super(data) {
    }

    override fun call() {
        val end = action(30)
        println("C : $end")
    }
}