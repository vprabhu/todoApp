package vhp.com.todomediumapp

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
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
import kotlin.math.log

class ListActivity : AppCompatActivity() {


    lateinit var mTaskRecyclerView : RecyclerView
    lateinit var mTodoTaskAdapters: TodoTaskAdapters
    lateinit var mDatabase: AppDatabase
//    lateinit var mTodoTaskList: LiveData<List<TodoTask>>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        mTaskRecyclerView = findViewById(R.id.recyclerview_task)

        mDatabase = AppDatabase.getInstance(this.applicationContext)!!

        loadTodoTasks()

        floatingActionButton_add_task.setOnClickListener(){
            //            Snackbar.make(it , "Tapped" , Snackbar.LENGTH_LONG).show()
            val mAddTaskIntent  = Intent(this , AddTaskActivity::class.java)
            startActivity(mAddTaskIntent)
        }
    }

    private fun loadTodoTasks() {
        TodoAppExecutors.getInstance().getDiskIO()?.execute(){
            var mTodoTaskList : LiveData<List<TodoTask>> = mDatabase.todoTaskDao().getallTasks()
            mTodoTaskList.observe(
                    this ,
                    Observer<List<TodoTask>>() {
                        Log.d("List" , it?.size.toString())
                        if (it != null) {
                            mTodoTaskAdapters = TodoTaskAdapters(this , it)
                            mTaskRecyclerView.layoutManager = LinearLayoutManager(
                                    this.applicationContext ,
                                    LinearLayout.VERTICAL , false)
                            mTaskRecyclerView.adapter = mTodoTaskAdapters
                        }
                    } )
        }
    }
}
