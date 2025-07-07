class UseList {

    fun info() {

        val profile = Profile()
        println(profile.name)

        // mutable arrays
        var arr = mutableListOf<String>()
        var arr1 = ArrayList<String>()

        // Add item
        arr.add("Ankara")
        arr.add("İstanbul")
        arr.add("İzmir")
        arr.add("Van")
        arr.add("Bursa")
        arr.add("Zonguldak")
        arr.add("Adana")

        // index değerine göre ekleme
        arr.add(1, "Trabzon")

        // remove item
        //arr.removeAt(1)
        //arr.remove("Bursa")
        //arr.removeAll { it.length > 5 }
        //arr.removeAll(arrayOf("İstanbul","","Adana"))

        println("=======================")
        for (item in arr) {
            println(item)
        }

        val adana1 = "Adana"
        val adana2 = "Adana"

        val indexOf = arr.indexOf("adana")
        println(indexOf)

        // set
        arr.set(1, "Artvin")
        arr[1] = "Artvin"

        println("=======================")
        for (i in 0..arr.count() -1 step 2) {
            println(arr[i])
        }

        // contains
        val status = arr.contains("Adana")
        println(status)
        println("=======================")

        // clear
        //arr.clear()

        // isEmpty
        println(arr.isEmpty())

        // slice
        val newArr = arr.slice(0..3)
        println(newArr)

        // filter
        val filterArr = arr.filter {
            it.count() > 5 && it.contains("t")
        }
        println(filterArr)

        arr.sort()
        arr.reverse()

        println("=======================")
        println(arr)

    }

}