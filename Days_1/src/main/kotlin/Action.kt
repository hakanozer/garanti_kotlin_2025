import kotlin.arrayOf

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

    fun order(a: Double, b: Double, fncAction: (Double, Double) -> Double) : Double {
        var end = fncAction(a, b)
        end -= 10
        return end
    }

    fun fnc2(data: String, num1: Int): Any {
        if (num1 > 1) {
            return data.length + num1
        }else {
            return data
        }
    }

    fun fnc3(num: Int, data: String): Array<Int>  {
        val arr = arrayOf(num, data.length)
        return arr
    }


}