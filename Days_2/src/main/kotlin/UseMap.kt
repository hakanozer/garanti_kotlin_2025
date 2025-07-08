package com.works

class UseMap {

    fun info() {
        val map = mutableMapOf<String, Any>()

        // add items
        map.put("name", "John")
        map.put("surname", "Doe")
        map.put("age", 28)
        map.put("city", "New York")
        map.put("status", true)

        // change item
        map["name"] = "Ali"

        // get item
        println( map.get("name") )

        println(map)

    }
}