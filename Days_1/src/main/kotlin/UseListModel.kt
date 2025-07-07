import models.User

class UseListModel {

    fun info() {

        val user = User(100, "John", "Smith","john@mail.com", 30, enable = true)
        val user1 = User(101, "Ali","Smith","ali@mail.com", 30, enable = true)
        val user2 = User(102, "Kemal","Bil","kemal@mail.com", 30, enable = true)
        val user3 = User(103, "Kemal","Bil","kemal@mail.com", 30, enable = true)

        val users = mutableListOf<User>()
        users.add(user)
        users.add(user1)
        users.add(user2)

        println(users)
        for (user in users) {
            println(user)
        }

        println("=====================")
        val indexOf = users.indexOf(user3)
        println(indexOf)

        println("=====================")
        val newArr = users.filter { user -> user.id > 100 }
        println(newArr)

    }

}