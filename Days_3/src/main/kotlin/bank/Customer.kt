package com.works.bank

class Customer(val accountNumber: Int, val tc: Long) : Person() {

    override var TC: Long = 0
        get() = tc
        set(value) { field = value }

    override fun accountNumber(): Int {
        return accountNumber
    }

}