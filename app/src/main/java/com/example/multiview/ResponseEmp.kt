package com.example.multiview

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Employee_table")
data class ResponseEmp (
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "Employe_id") val eid:Int,
    @ColumnInfo(name = "Name") val employee_name:String,
    @ColumnInfo(name = "Salary") val employee_salary:Int,
    @ColumnInfo(name = "Age") val employee_age:Int
)