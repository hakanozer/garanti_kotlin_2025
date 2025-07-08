package com.works.inheritance

open class Base {

    var data: String = ""
    init {
        println("Base init called")
    }

    constructor(data: String) {
        this.data = data
        println("Base called with data: $data")
    }

    open fun call() {
        val end = action(0);
        println(end)
    }

    fun action( num : Int ): Int {
        return num * num * data.length
    }

}