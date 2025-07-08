package com.works.actions

class Order {

    var id: Int = 0
    var status: Boolean = false

    constructor() {
        print("no params constructor")
    }

    constructor(id: Int) {
        this.id = id
    }

    constructor(id: Int, status: Boolean) {
        this.id = id
        this.status = status
    }

    fun info() {
        print("id: $id status: $status")
    }

}