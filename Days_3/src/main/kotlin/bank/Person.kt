package com.works.bank

abstract class Person {

    abstract var TC: Long
    abstract fun accountNumber(): Int

    fun accountName(): String {
        val cid = accountNumber()
        val name = when (cid) {
            100 -> "Ali Bilmem"
            200 -> "Zehra Bilsin"
            300 -> "Murat Bil"
           else -> ""
        }
        return name
    }

    fun accountTotal() : Int {
        val cid = accountNumber()
        val total = when (cid) {
            100 -> 1000000
            200 -> 2000000
            300 -> 3000000
            else -> 0
        }
        return total
    }

}