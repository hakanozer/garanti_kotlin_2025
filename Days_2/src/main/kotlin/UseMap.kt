package com.works

import com.works.utils.EControl
import com.works.utils.EUser

class UseMap {

    fun info() {
        val map = mutableMapOf<String, Any>()

        // add items
        map.put("name", "John")
        map.put("name", "Erkan")
        map.put("surname", "Doe")
        map.put("age", 28)
        map.put("city", "New York")
        map.put("status", true)

        // change item
        // map["name"] = "Ali"

        // get item
        println( map.get("name") )
        println( map["city"] )

        // containsKey
        val keyStatus = map.containsKey("status")
        println(keyStatus)

        // get item let
        map.get("surname")?.let {
            println(it)
        }

        // remove item
        //map.remove("status")?.let {
          //  println(it)
        //}

        // replace
        map.replace("status", false)?.let { println("Replace : $it") }

        // all keys
        val keys = map.keys
        val values = map.values
        println(keys)
        println(values)
        println("============================")
        for (key in keys) {
            println("key: $key value: ${map.get(key)}")
        }
        println("============================")

        map.forEach { key, value ->
            println("forEach - key: $key value: $value")
        }
        println("============================")
        val newMap = map.filter { it.value is Int }
        println(newMap)

        println("============================")
        println(map)

        println("============================")
        val eMap = mutableMapOf<EUser, Any>()

        eMap.put(EUser.nameSurname, "Selin")
        eMap.put(EUser.age, "28")
        eMap.put(EUser.email, "selin@mail.com")
        eMap.put(EUser.status, true)

        // remove
        //eMap.remove(EUser.email)
        println(eMap)
        println("============================")

        val mapList = mutableListOf<Map<EUser, Any>>()

        mapList.add(eMap)
        mapList.add(eMap)
        mapList.add(eMap)

        println(mapList)
    }

    fun control(status: EControl) {
        if (status == EControl.admin) {

        }
        if (status == EControl.user) {

        }
        if (status == EControl.customer) {

        }
    }
}