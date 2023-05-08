package com.example.healthcare_umc_160420046.model

data class Doctor(
    val id:String?,
    val img:String?,
    val name:String?,
    val type:String?,
    val rating:Float?,
    val description:String?,
    val dob:String?,
    val age:Int?,
    val gender:String?,
    )

data class Schedule(
    val day:String?,
    val time:String?,
    )

data class Medicine(
    val id:String?,
    val img:String?,
    val name:String?,
    val stock:Int?,
    val price:Int?,
    val description:String?,
    val dosage:String?,
    val min_age:Int?,
    )