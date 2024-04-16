package com.androidpaginationexample.`data`.dao

import android.database.Cursor
import android.os.CancellationSignal
import androidx.room.CoroutinesRoom
import androidx.room.CoroutinesRoom.Companion.execute
import androidx.room.EntityInsertionAdapter
import androidx.room.RoomDatabase
import androidx.room.RoomSQLiteQuery
import androidx.room.RoomSQLiteQuery.Companion.acquire
import androidx.room.SharedSQLiteStatement
import androidx.room.util.createCancellationSignal
import androidx.room.util.getColumnIndexOrThrow
import androidx.room.util.query
import androidx.sqlite.db.SupportSQLiteStatement
import com.androidpaginationexample.`data`.RemoteKeys
import java.lang.Class
import java.util.concurrent.Callable
import javax.`annotation`.processing.Generated
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.collections.List
import kotlin.jvm.JvmStatic

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION"])
public class RemoteKeysDao_Impl(
  __db: RoomDatabase,
) : RemoteKeysDao {
  private val __db: RoomDatabase

  private val __insertionAdapterOfRemoteKeys: EntityInsertionAdapter<RemoteKeys>

  private val __preparedStmtOfClearAll: SharedSQLiteStatement
  init {
    this.__db = __db
    this.__insertionAdapterOfRemoteKeys = object : EntityInsertionAdapter<RemoteKeys>(__db) {
      protected override fun createQuery(): String =
          "INSERT OR REPLACE INTO `remoteKey` (`repoId`,`prevKey`,`nextKey`) VALUES (?,?,?)"

      protected override fun bind(statement: SupportSQLiteStatement, entity: RemoteKeys) {
        statement.bindString(1, entity.repoId)
        val _tmpPrevKey: Int? = entity.prevKey
        if (_tmpPrevKey == null) {
          statement.bindNull(2)
        } else {
          statement.bindLong(2, _tmpPrevKey.toLong())
        }
        val _tmpNextKey: Int? = entity.nextKey
        if (_tmpNextKey == null) {
          statement.bindNull(3)
        } else {
          statement.bindLong(3, _tmpNextKey.toLong())
        }
      }
    }
    this.__preparedStmtOfClearAll = object : SharedSQLiteStatement(__db) {
      public override fun createQuery(): String {
        val _query: String = "DELETE FROM remoteKey"
        return _query
      }
    }
  }

  public override suspend fun insertRemote(list: List<RemoteKeys>): Unit =
      CoroutinesRoom.execute(__db, true, object : Callable<Unit> {
    public override fun call() {
      __db.beginTransaction()
      try {
        __insertionAdapterOfRemoteKeys.insert(list)
        __db.setTransactionSuccessful()
      } finally {
        __db.endTransaction()
      }
    }
  })

  public override suspend fun clearAll(): Unit = CoroutinesRoom.execute(__db, true, object :
      Callable<Unit> {
    public override fun call() {
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
  })

  public override suspend fun getRemoteKeys(id: String): RemoteKeys {
    val _sql: String = "SELECT * FROM remoteKey WHERE repoId = ?"
    val _statement: RoomSQLiteQuery = acquire(_sql, 1)
    var _argIndex: Int = 1
    _statement.bindString(_argIndex, id)
    val _cancellationSignal: CancellationSignal? = createCancellationSignal()
    return execute(__db, false, _cancellationSignal, object : Callable<RemoteKeys> {
      public override fun call(): RemoteKeys {
        val _cursor: Cursor = query(__db, _statement, false, null)
        try {
          val _cursorIndexOfRepoId: Int = getColumnIndexOrThrow(_cursor, "repoId")
          val _cursorIndexOfPrevKey: Int = getColumnIndexOrThrow(_cursor, "prevKey")
          val _cursorIndexOfNextKey: Int = getColumnIndexOrThrow(_cursor, "nextKey")
          val _result: RemoteKeys
          if (_cursor.moveToFirst()) {
            val _tmpRepoId: String
            _tmpRepoId = _cursor.getString(_cursorIndexOfRepoId)
            val _tmpPrevKey: Int?
            if (_cursor.isNull(_cursorIndexOfPrevKey)) {
              _tmpPrevKey = null
            } else {
              _tmpPrevKey = _cursor.getInt(_cursorIndexOfPrevKey)
            }
            val _tmpNextKey: Int?
            if (_cursor.isNull(_cursorIndexOfNextKey)) {
              _tmpNextKey = null
            } else {
              _tmpNextKey = _cursor.getInt(_cursorIndexOfNextKey)
            }
            _result = RemoteKeys(_tmpRepoId,_tmpPrevKey,_tmpNextKey)
          } else {
            error("The query result was empty, but expected a single row to return a NON-NULL object of type <com.androidpaginationexample.`data`.RemoteKeys>.")
          }
          return _result
        } finally {
          _cursor.close()
          _statement.release()
        }
      }
    })
  }

  public companion object {
    @JvmStatic
    public fun getRequiredConverters(): List<Class<*>> = emptyList()
  }
}
