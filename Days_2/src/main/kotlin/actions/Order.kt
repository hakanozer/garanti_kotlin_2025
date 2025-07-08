package com.works.actions

class Order {

    var id: Int = 0
    var status: Boolean = false

    init {
        println("init Order created - 1")
    }

    constructor() {
        println("no params constructor -2")
    }

    constructor(id: Int) {
        this.id = id
    }

    constructor(id: Int, status: Boolean) {
        this.id = id
        this.status = status
    }

    fun info() {
        println("id: $id status: $status")
    }

}