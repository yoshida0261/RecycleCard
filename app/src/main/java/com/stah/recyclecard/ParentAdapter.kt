package com.stah.recyclecard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.stah.recyclecard.R.layout.main_recycler
import kotlinx.android.synthetic.main.main_recycler.view.*


class ParentAdapter(val list: List<String>) : RecyclerView.Adapter<ParentAdapter.ViewHolder>() {

    private val viewPool = RecyclerView.RecycledViewPool()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(main_recycler, parent, false)
        return ViewHolder(v)
    }


    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val parent = list[position]
        holder.textView.text = parent
        holder.recyclerView.apply {

            layoutManager =
                LinearLayoutManager(holder.recyclerView.context, RecyclerView.VERTICAL, false)
            adapter = ChildAdapter(listOf("123", "234", "234", "234", "234"))
           // setRecycledViewPool = viewPool

        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recyclerView: RecyclerView = itemView.rv_child
        val textView: TextView = itemView.textView
    }

}