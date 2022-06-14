package com.rumeysaozer.roomdaggerhilt.service

import androidx.room.withTransaction
import com.rumeysaozer.roomdaggerhilt.util.networkBoundResource
import kotlinx.coroutines.delay
import javax.inject.Inject

class NameRepository @Inject constructor(
    private val api: ImageApi,
    private val db : NameDatabase
) {
    private val nameDao = db.NameDao()
    fun getNames() = networkBoundResource(
        query = {
            nameDao.getAllNames()
        },
        fetch = {
            delay(2000)
            api.getImages()
        },
        saveFetchResult = { names ->
            db.withTransaction {
                nameDao.deleteAlllName()
                nameDao.insertName(names)
            }

        }
    )
}