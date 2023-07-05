package com.example.multiview

import androidx.room.*

@Dao
interface EmpDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(responseEmp: ResponseEmp)

    @Update
    suspend fun update(responseEmp: ResponseEmp)

    @Delete
    suspend fun delete(responseEmp: ResponseEmp)

    @Query("SELECT * FROM Employee_table ORDER BY Employe_id ASC")
    fun getAllUser(): List<ResponseEmp>
}