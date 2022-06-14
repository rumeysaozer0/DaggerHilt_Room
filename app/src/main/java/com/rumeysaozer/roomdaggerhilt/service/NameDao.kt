package com.rumeysaozer.roomdaggerhilt.service

import androidx.room.*
import com.rumeysaozer.roomdaggerhilt.model.NameItem
import kotlinx.coroutines.flow.Flow

@Dao
interface NameDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertName(names : List<NameItem>)
    @Query("DELETE FROM names")
    suspend fun deleteAlllName()
    @Query("SELECT * FROM names")
    fun getAllNames():Flow<List<NameItem>>


}