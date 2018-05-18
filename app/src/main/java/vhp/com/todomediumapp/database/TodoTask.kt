package vhp.com.todomediumapp.database

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

import java.util.Date

/**
 * Created by Vignesh Prabhu on 18/5/18.
 */
@Entity(tableName = "todotasks")
class TodoTask(@field:PrimaryKey(autoGenerate = true)
               var id: Int, var name: String?, @field:ColumnInfo(name = "due_date")
               var dueDate: Date?)
