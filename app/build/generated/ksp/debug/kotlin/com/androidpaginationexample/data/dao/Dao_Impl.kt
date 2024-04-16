package com.androidpaginationexample.`data`.dao

import android.database.Cursor
import androidx.paging.PagingSource
import androidx.room.CoroutinesRoom
import androidx.room.EntityInsertionAdapter
import androidx.room.RoomDatabase
import androidx.room.RoomSQLiteQuery
import androidx.room.RoomSQLiteQuery.Companion.acquire
import androidx.room.SharedSQLiteStatement
import androidx.room.paging.LimitOffsetPagingSource
import androidx.room.util.getColumnIndexOrThrow
import androidx.sqlite.db.SupportSQLiteStatement
import com.androidpaginationexample.`data`.Post
import java.lang.Class
import java.util.ArrayList
import java.util.concurrent.Callable
import javax.`annotation`.processing.Generated
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.jvm.JvmStatic

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION"])
public class Dao_Impl(
  __db: RoomDatabase,
) : Dao {
  private val __db: RoomDatabase

  private val __insertionAdapterOfPost: EntityInsertionAdapter<Post>

  private val __preparedStmtOfClearAll: SharedSQLiteStatement
  init {
    this.__db = __db
    this.__insertionAdapterOfPost = object : EntityInsertionAdapter<Post>(__db) {
      protected override fun createQuery(): String =
          "INSERT OR REPLACE INTO `posts` (`id`,`userId`,`title`,`body`) VALUES (?,?,?,?)"

      protected override fun bind(statement: SupportSQLiteStatement, entity: Post) {
        statement.bindLong(1, entity.id.toLong())
        statement.bindLong(2, entity.userId.toLong())
        statement.bindString(3, entity.title)
        statement.bindString(4, entity.body)
      }
    }
    this.__preparedStmtOfClearAll = object : SharedSQLiteStatement(__db) {
      public override fun createQuery(): String {
        val _query: String = "DELETE FROM posts"
        return _query
      }
    }
  }

  public override suspend fun insert(list: List<Post>): Unit = CoroutinesRoom.execute(__db, true,
      object : Callable<Unit> {
    public override fun call() {
      __db.beginTransaction()
      try {
        __insertionAdapterOfPost.insert(list)
        __db.setTransactionSuccessful()
      } finally {
        __db.endTransaction()
      }
    }
  })

  public override fun clearAll() {
    __db.assertNotSuspendingTransaction()
    val _stmt: SupportSQLiteStatement = __preparedStmtOfClearAll.acquire()
    try {
      __db.beginTransaction()
      try {
        _stmt.executeUpdateDelete()
        __db.setTransactionSuccessful()
      } finally {
        __db.endTransaction()
      }
    } finally {
      __preparedStmtOfClearAll.release(_stmt)
    }
  }

  public override fun getAllPosts(): PagingSource<Int, Post> {
    val _sql: String = "SELECT * FROM posts"
    val _statement: RoomSQLiteQuery = acquire(_sql, 0)
    return object : LimitOffsetPagingSource<Post>(_statement, __db, "posts") {
      protected override fun convertRows(cursor: Cursor): List<Post> {
        val _cursorIndexOfId: Int = getColumnIndexOrThrow(cursor, "id")
        val _cursorIndexOfUserId: Int = getColumnIndexOrThrow(cursor, "userId")
        val _cursorIndexOfTitle: Int = getColumnIndexOrThrow(cursor, "title")
        val _cursorIndexOfBody: Int = getColumnIndexOrThrow(cursor, "body")
        val _result: MutableList<Post> = ArrayList<Post>(cursor.getCount())
        while (cursor.moveToNext()) {
          val _item: Post
          val _tmpId: Int
          _tmpId = cursor.getInt(_cursorIndexOfId)
          val _tmpUserId: Int
          _tmpUserId = cursor.getInt(_cursorIndexOfUserId)
          val _tmpTitle: String
          _tmpTitle = cursor.getString(_cursorIndexOfTitle)
          val _tmpBody: String
          _tmpBody = cursor.getString(_cursorIndexOfBody)
          _item = Post(_tmpId,_tmpUserId,_tmpTitle,_tmpBody)
          _result.add(_item)
        }
        return _result
      }
    }
  }

  public companion object {
    @JvmStatic
    public fun getRequiredConverters(): List<Class<*>> = emptyList()
  }
}
