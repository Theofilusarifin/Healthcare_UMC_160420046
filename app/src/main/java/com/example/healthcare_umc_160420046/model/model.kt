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

data class Schedule(
    val monday:String?,
    val tuesday:String?,
    val wednesday:String?,
    val thursday:String?,
    val friday:String?,
    val saturday:String?,
    )

data class Medicine(
    val id:String?,
    val name:String?,
    val stock:Int?,
    val price:Int?,
    val description:String?,
    val dosage:String?,
    val minAge:Int?,
    )