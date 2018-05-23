package vhp.com.todomediumapp

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_list.*
import vhp.com.todomediumapp.R.id.floatingActionButton_add_task
import vhp.com.todomediumapp.R.id.recyclerview_task
import vhp.com.todomediumapp.adapters.TodoTaskAdapters
import vhp.com.todomediumapp.database.AppDatabase
import vhp.com.todomediumapp.database.TodoTask
import vhp.com.todomediumapp.executors.TodoAppExecutors
import vhp.com.todomediumapp.viewmodels.TodoListViewModel
import kotlin.math.log

class ListActivity : AppCompatActivity() {


    lateinit var mTaskRecyclerView : RecyclerView
    lateinit var mTodoTaskAdapters: TodoTaskAdapters
    lateinit var mDatabase: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        mTaskRecyclerView = findViewById(R.id.recyclerview_task)

        mDatabase = AppDatabase.getInstance(this.applicationContext)!!

        loadTodoTasks()

        floatingActionButton_add_task.setOnClickListener(){
            val mAddTaskIntent  = Intent(this , AddTaskActivity::class.java)
            startActivity(mAddTaskIntent)
        }
    }

    /**
     * method to Load all the tasks from Room DB using LiveData and ViewModel
     */
    private fun loadTodoTasks() {
        val viewModel : TodoListViewModel = ViewModelProviders.of(this).get(TodoListViewModel::class.java)
        viewModel.getAllTasksFromViewModel()?.observe(
                this ,
                Observer {
                    if (it != null) {
                        mTodoTaskAdapters = TodoTaskAdapters(it)
                        mTaskRecyclerView.layoutManager = LinearLayoutManager(
                                this.applicationContext ,
                                LinearLayout.VERTICAL , false)
                        mTaskRecyclerView.adapter = mTodoTaskAdapters
                    }
                }
        )
    }
}
