package com.stah.recyclecard

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_layout.view.*

class ChildAdapter(val list:List<String>) : RecyclerView.Adapter<ChildAdapter.ViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        //ここから参照している
        holder.textView.text = list[position]
    }


    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        // ここでViewを設定
        val textView : TextView = itemView.textView2

    }

}
