package com.works

import com.works.actions.Order
import com.works.actions.Profile
import com.works.utils.EControl
import com.works.utils.EUser

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    val useSet = UseSet()
    useSet.info()
    println("============================")

    val map = UseMap()
    map.info()
    map.control(EControl.user)
    println("============================")

    val profile = Profile(userId = 100, email = "ali@mail.com")
    println(profile.userName())
    println("============================")

    val order = Order()
    order.info()

}