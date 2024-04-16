package com.androidpaginationexample.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.androidpaginationexample.data.RemoteKeys

@Dao
interface RemoteKeysDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRemote(list: List<RemoteKeys>)

    @Query("SELECT * FROM remoteKey WHERE repoId = :id")
   suspend fun getRemoteKeys(id:String) : RemoteKeys

    @Query("DELETE FROM remoteKey")
    suspend fun clearAll()
}