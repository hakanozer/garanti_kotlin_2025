package com.works

import com.works.bank.Customer
import com.works.users.IProfile
import com.works.users.IUser
import com.works.users.UserImpl

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    val user = UserImpl()
    val userObj: IUser = UserImpl()
    val userProfile: IProfile = UserImpl()

    val customer = Customer(200, 7896767967986)
    println(customer.accountName())
    println(customer.accountNumber())
    println(customer.TC)

}