package vhp.com.todomediumapp.viewmodels

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import vhp.com.todomediumapp.database.AppDatabase
import vhp.com.todomediumapp.database.TodoTask

/**
 * Created by Vignesh Prabhu on 23/5/18.
 */
class TodoListViewModel(application: Application) : AndroidViewModel(application) {

    private var  mTodoTaskList : LiveData<List<TodoTask>> ?= null

    fun getAllTasksFromViewModel() : LiveData<List<TodoTask>>? {
        return mTodoTaskList
    }

    init {
        val appDatabase : AppDatabase? = AppDatabase.getInstance(this.getApplication())
        mTodoTaskList = appDatabase?.todoTaskDao()?.getallTasks()
    }

}