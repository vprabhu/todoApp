package vhp.com.todomediumapp.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import vhp.com.todomediumapp.R
import vhp.com.todomediumapp.database.TodoTask

class TodoTaskAdapters(var mTodoTaskList : List<TodoTask>)
    : RecyclerView.Adapter<TodoTaskAdapters.TodaTaskViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodaTaskViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item , parent , false)
        return TodoTaskAdapters.TodaTaskViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mTodoTaskList.size
    }

    override fun onBindViewHolder(holder: TodaTaskViewHolder, position: Int) {
        holder.mTaskTextView.text = mTodoTaskList.get(position).taskName
    }

    class TodaTaskViewHolder(view : View ) : RecyclerView.ViewHolder(view){
        var mTaskTextView = view.findViewById(R.id.textView_taskname) as TextView
    }

}