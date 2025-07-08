package com.works.actions

class Profile(
    var userId: Int,
    var status: Boolean = true,
    var email: String = ""
    )
{

    fun userName(): String {
        println("Status: $status")
        println("Email: $email")
        var name = ""
        if(userId == 100) {
            name = "Zehra"
        }else if (userId == 200) {
            name = "Erkan"
        }
        return name
    }
}