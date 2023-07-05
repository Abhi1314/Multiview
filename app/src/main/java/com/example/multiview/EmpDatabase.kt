package com.example.multiview

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities =[ResponseEmp::class], version = 1)
abstract class EmpDatabase(): RoomDatabase() {
    abstract fun getEmpDao():EmpDao
    companion object{
        @Volatile
        private var INSTANCE:EmpDatabase?=null

        fun getDatabase(context: Context):EmpDatabase{
            return INSTANCE ?: synchronized(this){
                val instance= Room.databaseBuilder(context.applicationContext,
                    EmpDatabase::class.java,"Employee_Database").allowMainThreadQueries().build()
                INSTANCE=instance
                instance
            }
        }
    }
}