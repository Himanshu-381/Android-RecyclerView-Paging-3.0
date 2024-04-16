package com.androidpaginationexample.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.androidpaginationexample.data.dao.Dao
import com.androidpaginationexample.data.dao.RemoteKeysDao
import com.androidpaginationexample.data.Post
import com.androidpaginationexample.data.RemoteKeys

@Database(entities = [Post::class,RemoteKeys::class],version = 1,exportSchema = false)
abstract class Database : RoomDatabase(){

    abstract fun getDao(): Dao
    abstract fun remoteKeyDao():RemoteKeysDao
}