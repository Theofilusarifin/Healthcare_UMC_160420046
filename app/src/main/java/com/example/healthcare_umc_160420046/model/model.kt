package com.example.healthcare_umc_160420046.model

data class Doctor(
    val id:String?,
    val name:String?,
    val type:String?,
    val rating:Int?,
    val description:String?,
    val dob:String?,
    val age:Int?,
    val gender:String?,

    )

data class Medicine(
    val id:String?,
    val name:String?,
    val stock:String?,
    val price:String?,
    )