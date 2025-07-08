package com.works

import com.works.models.Customer

class UseSet {

    fun info() {

        val customer1 = Customer(1, "John", "Smith")
        val customer2 = Customer(2, "Erkan", "Bil")
        val customer3 = Customer(3, "Zehra", "Bilsin")

        val arr = mutableListOf<String>()
        arr.add("Ali")
        arr.add("Erkan")
        arr.add("Erkan")
        arr.add("Erkan")
        arr.add("Zehra")
        arr.add("Mehmet")
        arr.add("Mehmet")
        arr.add("Mehmet")
        arr.add("Selin")
        arr.add("Ayşe")
        arr.add("Mehmet")

        println(arr)

        val customers = mutableListOf<Customer>(customer1, customer1, customer2, customer3, customer3)
        println(customers)

        println("============================")

        val set = mutableSetOf<String>()
        set.add("Ali")
        set.add("Erkan")
        set.add("Erkan")
        set.add("Erkan")
        set.add("Zehra")
        set.add("Mehmet")
        set.add("Mehmet")
        set.add("Mehmet")
        set.add("Selin")
        set.add("Ayşe")
        set.add("Mehmet")
        println(set)

        val customerSet = mutableSetOf<Customer>(customer1, customer1, customer2, customer3, customer3)
        println(customerSet)
    }

}