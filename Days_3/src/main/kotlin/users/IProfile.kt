package com.works.users

import com.works.models.UserModel

interface IProfile {

    fun userUpdateProfile(userObj: UserModel) : UserModel

}