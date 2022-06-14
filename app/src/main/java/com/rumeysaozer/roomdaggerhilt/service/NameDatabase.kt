package com.rumeysaozer.roomdaggerhilt.service

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rumeysaozer.roomdaggerhilt.model.NameItem

@Database(entities = [NameItem::class],version = 1)
abstract class NameDatabase : RoomDatabase(){
    abstract fun NameDao(): NameDao
}