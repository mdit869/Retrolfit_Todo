package com.example.todo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter(val api: ArrayList<Dataclass>): RecyclerView.Adapter<TodoAdapter.viewHolde>() {
    class viewHolde(item: View): RecyclerView.ViewHolder(item) {
        val id: TextView = item.findViewById(R.id.txtId)
        val title: TextView = item.findViewById(R.id.txtTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolde {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return  viewHolde(view)
    }

    override fun getItemCount(): Int {
        return api.size
    }

    override fun onBindViewHolder(holder: viewHolde, position: Int) {
        val curson = api[position]
        holder.id.text = curson.id.toString()
        holder.title.text = curson.title
    }
}