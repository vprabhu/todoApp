package vhp.com.todomediumapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        floatingActionButton_add_task.setOnClickListener(){
//            Snackbar.make(it , "Tapped" , Snackbar.LENGTH_LONG).show()
            val mAddTaskIntent  = Intent(this , AddTaskActivity::class.java)
            startActivity(mAddTaskIntent)
        }
    }
}
