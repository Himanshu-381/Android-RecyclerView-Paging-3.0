package com.androidpaginationexample.`data`.database

import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.room.RoomDatabase
import androidx.room.RoomOpenHelper
import androidx.room.migration.AutoMigrationSpec
import androidx.room.migration.Migration
import androidx.room.util.TableInfo
import androidx.room.util.TableInfo.Companion.read
import androidx.room.util.dropFtsSyncTriggers
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.androidpaginationexample.`data`.dao.Dao
import com.androidpaginationexample.`data`.dao.Dao_Impl
import com.androidpaginationexample.`data`.dao.RemoteKeysDao
import com.androidpaginationexample.`data`.dao.RemoteKeysDao_Impl
import java.lang.Class
import java.util.ArrayList
import java.util.HashMap
import java.util.HashSet
import javax.`annotation`.processing.Generated
import kotlin.Any
import kotlin.Lazy
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.MutableList
import kotlin.collections.Set

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION"])
public class Database_Impl : Database() {
  private val _dao: Lazy<Dao> = lazy {
    Dao_Impl(this)
  }


  private val _remoteKeysDao: Lazy<RemoteKeysDao> = lazy {
    RemoteKeysDao_Impl(this)
  }


  protected override fun createOpenHelper(config: DatabaseConfiguration): SupportSQLiteOpenHelper {
    val _openCallback: SupportSQLiteOpenHelper.Callback = RoomOpenHelper(config, object :
        RoomOpenHelper.Delegate(1) {
      public override fun createAllTables(db: SupportSQLiteDatabase) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `posts` (`id` INTEGER NOT NULL, `userId` INTEGER NOT NULL, `title` TEXT NOT NULL, `body` TEXT NOT NULL, PRIMARY KEY(`id`))")
        db.execSQL("CREATE TABLE IF NOT EXISTS `remoteKey` (`repoId` TEXT NOT NULL, `prevKey` INTEGER, `nextKey` INTEGER, PRIMARY KEY(`repoId`))")
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)")
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'a3e603afee00fbfef28a8b8ea5705fdd')")
      }

      public override fun dropAllTables(db: SupportSQLiteDatabase) {
        db.execSQL("DROP TABLE IF EXISTS `posts`")
        db.execSQL("DROP TABLE IF EXISTS `remoteKey`")
        val _callbacks: List<RoomDatabase.Callback>? = mCallbacks
        if (_callbacks != null) {
          for (_callback: RoomDatabase.Callback in _callbacks) {
            _callback.onDestructiveMigration(db)
          }
        }
      }

      public override fun onCreate(db: SupportSQLiteDatabase) {
        val _callbacks: List<RoomDatabase.Callback>? = mCallbacks
        if (_callbacks != null) {
          for (_callback: RoomDatabase.Callback in _callbacks) {
            _callback.onCreate(db)
          }
        }
      }

      public override fun onOpen(db: SupportSQLiteDatabase) {
        mDatabase = db
        internalInitInvalidationTracker(db)
        val _callbacks: List<RoomDatabase.Callback>? = mCallbacks
        if (_callbacks != null) {
          for (_callback: RoomDatabase.Callback in _callbacks) {
            _callback.onOpen(db)
          }
        }
      }

      public override fun onPreMigrate(db: SupportSQLiteDatabase) {
        dropFtsSyncTriggers(db)
      }

      public override fun onPostMigrate(db: SupportSQLiteDatabase) {
      }

      public override fun onValidateSchema(db: SupportSQLiteDatabase):
          RoomOpenHelper.ValidationResult {
        val _columnsPosts: HashMap<String, TableInfo.Column> = HashMap<String, TableInfo.Column>(4)
        _columnsPosts.put("id", TableInfo.Column("id", "INTEGER", true, 1, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsPosts.put("userId", TableInfo.Column("userId", "INTEGER", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsPosts.put("title", TableInfo.Column("title", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsPosts.put("body", TableInfo.Column("body", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        val _foreignKeysPosts: HashSet<TableInfo.ForeignKey> = HashSet<TableInfo.ForeignKey>(0)
        val _indicesPosts: HashSet<TableInfo.Index> = HashSet<TableInfo.Index>(0)
        val _infoPosts: TableInfo = TableInfo("posts", _columnsPosts, _foreignKeysPosts,
            _indicesPosts)
        val _existingPosts: TableInfo = read(db, "posts")
        if (!_infoPosts.equals(_existingPosts)) {
          return RoomOpenHelper.ValidationResult(false, """
              |posts(com.androidpaginationexample.data.Post).
              | Expected:
              |""".trimMargin() + _infoPosts + """
              |
              | Found:
              |""".trimMargin() + _existingPosts)
        }
        val _columnsRemoteKey: HashMap<String, TableInfo.Column> =
            HashMap<String, TableInfo.Column>(3)
        _columnsRemoteKey.put("repoId", TableInfo.Column("repoId", "TEXT", true, 1, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsRemoteKey.put("prevKey", TableInfo.Column("prevKey", "INTEGER", false, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsRemoteKey.put("nextKey", TableInfo.Column("nextKey", "INTEGER", false, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        val _foreignKeysRemoteKey: HashSet<TableInfo.ForeignKey> = HashSet<TableInfo.ForeignKey>(0)
        val _indicesRemoteKey: HashSet<TableInfo.Index> = HashSet<TableInfo.Index>(0)
        val _infoRemoteKey: TableInfo = TableInfo("remoteKey", _columnsRemoteKey,
            _foreignKeysRemoteKey, _indicesRemoteKey)
        val _existingRemoteKey: TableInfo = read(db, "remoteKey")
        if (!_infoRemoteKey.equals(_existingRemoteKey)) {
          return RoomOpenHelper.ValidationResult(false, """
              |remoteKey(com.androidpaginationexample.data.RemoteKeys).
              | Expected:
              |""".trimMargin() + _infoRemoteKey + """
              |
              | Found:
              |""".trimMargin() + _existingRemoteKey)
        }
        return RoomOpenHelper.ValidationResult(true, null)
      }
    }, "a3e603afee00fbfef28a8b8ea5705fdd", "e6bea11adf860178e5b630e19ad8fd7f")
    val _sqliteConfig: SupportSQLiteOpenHelper.Configuration =
        SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build()
    val _helper: SupportSQLiteOpenHelper = config.sqliteOpenHelperFactory.create(_sqliteConfig)
    return _helper
  }

  protected override fun createInvalidationTracker(): InvalidationTracker {
    val _shadowTablesMap: HashMap<String, String> = HashMap<String, String>(0)
    val _viewTables: HashMap<String, Set<String>> = HashMap<String, Set<String>>(0)
    return InvalidationTracker(this, _shadowTablesMap, _viewTables, "posts","remoteKey")
  }

  public override fun clearAllTables() {
    super.assertNotMainThread()
    val _db: SupportSQLiteDatabase = super.openHelper.writableDatabase
    try {
      super.beginTransaction()
      _db.execSQL("DELETE FROM `posts`")
      _db.execSQL("DELETE FROM `remoteKey`")
      super.setTransactionSuccessful()
    } finally {
      super.endTransaction()
      _db.query("PRAGMA wal_checkpoint(FULL)").close()
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM")
      }
    }
  }

  protected override fun getRequiredTypeConverters(): Map<Class<out Any>, List<Class<out Any>>> {
    val _typeConvertersMap: HashMap<Class<out Any>, List<Class<out Any>>> =
        HashMap<Class<out Any>, List<Class<out Any>>>()
    _typeConvertersMap.put(Dao::class.java, Dao_Impl.getRequiredConverters())
    _typeConvertersMap.put(RemoteKeysDao::class.java, RemoteKeysDao_Impl.getRequiredConverters())
    return _typeConvertersMap
  }

  public override fun getRequiredAutoMigrationSpecs(): Set<Class<out AutoMigrationSpec>> {
    val _autoMigrationSpecsSet: HashSet<Class<out AutoMigrationSpec>> =
        HashSet<Class<out AutoMigrationSpec>>()
    return _autoMigrationSpecsSet
  }

  public override
      fun getAutoMigrations(autoMigrationSpecs: Map<Class<out AutoMigrationSpec>, AutoMigrationSpec>):
      List<Migration> {
    val _autoMigrations: MutableList<Migration> = ArrayList<Migration>()
    return _autoMigrations
  }

  public override fun getDao(): Dao = _dao.value

  public override fun remoteKeyDao(): RemoteKeysDao = _remoteKeysDao.value
}
