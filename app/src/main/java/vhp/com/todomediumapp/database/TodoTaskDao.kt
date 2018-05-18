package vhp.com.todomediumapp.database

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update

/**
 * Created by Vignesh Prabhu on 18/5/18.
 */
@Dao
interface TodoTaskDao {

    @Query("select * from todotasks order by id")
    fun getallTasks(): LiveData<List<TodoTask>>

    @Insert
    fun insertTodoTask(todoTask: TodoTask)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateTodoTask(todoTask: TodoTask)

    @Delete
    fun deleteTodoTask()

    @Query("Select * from todotasks where id = :id")
    fun getTaskbyId(id: Int): LiveData<List<TodoTask>>
}
