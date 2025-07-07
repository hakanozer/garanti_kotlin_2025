//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    println("Hello World!")

    // Comment line
    /*
    Multi
    comment
    line
     */
    println(150)
    println("Merhaba Asya")
    println(10 + 15)

    // değişken üretimi
    // var, val
    // var -> bir değerin daha sonradan değiştirilmesi durumunda
    // val -> bir değerin değişmeme durumu

    // String
    var name = "Ali"
    name = "Erkan"
    val surname = "Bilmem"
    println("Adı: $name Soyadı: $surname")

    // int -> tam sayı
    val age = 30
    val number: Int = 2147000000
    println("Age: ${age + 10}")

    // long -> yüksek seviye tam sayı
    val num1: Long = 987989789789789999

    // orta seviye
    val num2: Short = 32767

    // düşük seviye tam sayı
    val num3: Byte = 127

    // true - false
    val status = true

    // ondalıklı değerler
    var num4 = 1056753453453.56756756
    num4 = 100.0

    // ondalıklı küçük değerler
    val num5: Float = 34534.34534f

    // Any type
    var obj:Any = 10
    obj = "Ali"

    // instanceof -> is
    if (obj is String) {
        println("obj is String")
    }

    if (obj is Int) {
        println("obj is Int")
    }

    obj = true
    if (obj is Boolean) {
        val status = obj.toString().toBoolean()
        println("obj is Boolean")
    }

    // Stirng to Int
    val st1 = "40"
    val intSt1 = st1.toInt()
    println(intSt1)

    // null
    val num6: Int? = null
    if (num6 != null) {
        val sum = num6 + 50
        println(sum)
    }

    // null control
    num6?.let {
        val sum = it + 50
        println("let control $sum")
    }

    // array -> immutable
    var users = arrayOf<String>("Mehmet", "Zehra", "Ayşe", "Ali", "Erkan", "Ali", "Erkan");

    // index
    println( users[0] )

    // count
    println( users.count() )

    val index = 4
    if ( users.count() > index ) {
        println(users[index])
    }

    println("=======================")
    // loop
    for ( item in users ) {
        println(item)
    }

    println("=======================")
    val dataString = "Hello Kotlin!"
    for ( item in dataString ) {
        println(item)
    }

    println("=======================")
    for (i in 1..users.size - 1 step 2) {
        println(users[i])
    }


    println("=======================")
    users.iterator().forEach {
        println(it)
    }

    // Benzersiz değerler ile yazdırım
    println("=======================")
    val newArr = users.distinct()
    for ( item in newArr ) {
        println(item)
    }

    // functions
    val action = Action()
    println("${action.name} - ${action.surname}")
    action.noParams()
    action.params(100, "sdfsdf34534fgdf")
    val count = action.count("Ali", "Bilmem")
    println(count)

    val chars = action.fnc1("Kemal", 11)
    println(chars)
}