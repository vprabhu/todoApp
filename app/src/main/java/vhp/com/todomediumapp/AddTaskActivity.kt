package vhp.com.todomediumapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_add_task.*
import vhp.com.todomediumapp.database.AppDatabase
import vhp.com.todomediumapp.database.TodoTask
import vhp.com.todomediumapp.executors.TodoAppExecutors
import java.util.*

class AddTaskActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        val mTaskEditText : EditText = findViewById(R.id.editText_task_name)

        button_add_task.setOnClickListener(){
            val taskName = mTaskEditText.text.toString()
            val date = Date()
            val todoTask = TodoTask(taskName , date)
            TodoAppExecutors.getInstance().getDiskIO()!!.execute{
                // inser the task into DB
                AppDatabase.getInstance(this.applicationContext)!!.todoTaskDao().insertTodoTask(todoTask)
                // finsish the activity
                finish()
            }
        }


    }
}
