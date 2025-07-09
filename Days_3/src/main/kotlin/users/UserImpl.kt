package com.works.users

import com.works.models.UserModel

class UserImpl : IUser, IProfile {

    override fun userLogin(username: String, password: String): UserModel? {
        TODO("Not yet implemented")
    }

    override fun userName(userID: Int): String? {
        TODO("Not yet implemented")
    }

    override fun userLogout(userID: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun userUpdateProfile(userObj: UserModel): UserModel {
        TODO("Not yet implemented")
    }

}