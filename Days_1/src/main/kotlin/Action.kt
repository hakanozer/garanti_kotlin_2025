class Action {

    val name = "Salih"
    val surname = "Bilirim"


    // Fonksiyonlar
    fun noParams() {
        println("NoParams Called")
    }

    fun params( userID: Int, token: String ) {
        println("userID: $userID")
        println("token: $token")
    }

    fun count(name: String, surname: String): Int {
        val sum = name.length + surname.length
        return sum
    }

    fun fnc1(name: String, age: Int?) : Int {
        var count = name.length
        age?.let {
            count += it
            params(it, name)
        }
        return count
    }


}