package vhp.com.todomediumapp.database

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

import java.util.Date

/**
 * Created by Vignesh Prabhu on 18/5/18.
 */
/*@Entity(tableName = "todotasks")
class TodoTask(@field:PrimaryKey(autoGenerate = true)
               var id: Int = 0, var name: String? = null, @field:ColumnInfo(name = "updated_date")

               var updatedDate: Date? = null)*/
@Entity(tableName = "todotasks")
class TodoTask{
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    var taskName: String? = null
    @ColumnInfo(name = "updated_date")
    var date: Date? = null

    constructor(taskName: String, date: Date) {
        this.taskName = taskName
        this.date = date
    }
}
