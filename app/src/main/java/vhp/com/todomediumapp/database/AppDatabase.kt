package vhp.com.todomediumapp.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context

/**
 * Created by Vignesh Prabhu on 18/5/18.
 */
@Database(entities = arrayOf(TodoTask::class), version = 1, exportSchema = false)
@TypeConverters(DataConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun todoTaskDao(): TodoTaskDao

    companion object {

        private val LOCK = Any()
        private val DATABASE_NAME = "todotaskList"
        private var sAppDatabaseSingletonInstance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            if (sAppDatabaseSingletonInstance == null) {
                synchronized(LOCK) {
                    sAppDatabaseSingletonInstance = Room.databaseBuilder(
                            context.applicationContext,
                            AppDatabase::class.java,
                            AppDatabase.DATABASE_NAME
                    ).build()
                }
            }
            return sAppDatabaseSingletonInstance;
        }
    }
}
