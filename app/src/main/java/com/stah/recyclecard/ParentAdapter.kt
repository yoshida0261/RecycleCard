package com.stah.recyclecard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.stah.recyclecard.R.layout.main_recycler
import com.stah.recyclecard.R.layout.sub_recycler
import kotlinx.android.synthetic.main.main_recycler.view.*
import kotlinx.android.synthetic.main.main_recycler.view.textView
import kotlinx.android.synthetic.main.sub_recycler.view.*


class ParentAdapter(val list: List<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    sealed class AdapterItem(open val viewType: Int) {
        class TestA : AdapterItem(1)
        class TestB : AdapterItem(2)
    }

    class TestAViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recyclerView: RecyclerView = itemView.rv_child
        val textView: TextView = itemView.textView
    }

    class TestBViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recyclerView = itemView.rv_child2
    }

    override fun getItemViewType(position: Int): Int {
        return position +1 //  本当はここはadapterItemからあちいが
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            1 -> {
                val v = LayoutInflater.from(parent.context).inflate(main_recycler, parent, false)
                TestAViewHolder(v)
            }
            2 -> {
                val v = LayoutInflater.from(parent.context).inflate(sub_recycler, parent, false)
                TestBViewHolder(v)
            }
            else -> throw IllegalArgumentException("unsupported view type. viewType:=$viewType")
        }


    }


    override fun getItemCount(): Int {
        return list.size
    }

    /*
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

     */

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            1 -> {
                val parent = list[position]
                //holder.textView.text = parent
                if (holder is TestAViewHolder) {
                    holder.recyclerView.apply {

                        layoutManager =
                            LinearLayoutManager(
                                holder.recyclerView.context,
                                RecyclerView.VERTICAL,
                                false
                            )
                        adapter = ChildAdapter(listOf("123", "234", "234", "234", "234"))
                        // setRecycledViewPool = viewPool

                    }
                }
            }
            2 -> {
                if (holder is TestBViewHolder) {
                    holder.recyclerView.apply {

                        layoutManager =
                            LinearLayoutManager(
                                holder.recyclerView.context,
                                RecyclerView.VERTICAL,
                                false
                            )
                        adapter = ChildAdapter(listOf("abc", "aaa", "bbb", "ccc", "ddd"))
                        // setRecycledViewPool = viewPool

                    }
                }
            }
        }
    }

    /*
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recyclerView: RecyclerView = itemView.rv_child
        val textView: TextView = itemView.textView
    }

     */

}