package vhp.com.todomediumapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_add_task.*

class AddTaskActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        val mTaskEditText : EditText = findViewById(R.id.editText_task_name)
        button_add_task.setOnClickListener(){
            mTaskEditText.setText("Sample")
        }
    }
}
