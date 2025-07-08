package com.works

import com.works.utils.EControl

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    val useSet = UseSet()
    useSet.info()
    println("============================")

    val map = UseMap()
    map.info()
    map.control(EControl.user)

}