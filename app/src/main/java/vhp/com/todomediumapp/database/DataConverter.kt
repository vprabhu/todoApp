package vhp.com.todomediumapp.database

import android.arch.persistence.room.TypeConverter

import java.util.Date

/**
 * Created by Vignesh Prabhu on 18/5/18.
 */
object DataConverter {

    @TypeConverter
    fun toDate(timestamp: Long?): Date? {
        return if (timestamp == null) null else Date(timestamp)
    }

    @TypeConverter
    fun toTimestamp(date: Date?): Long? {
        return date?.time
    }
}
