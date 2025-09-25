package com.example.smarttransport.data

data class User(
    val uid: String = "",
    val firstName: String,
    val lastName: String,
    val email: String,
    var imagePath: String = ""
){
    constructor(): this("","","","")
}