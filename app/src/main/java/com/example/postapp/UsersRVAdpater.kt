package com.example.postapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_row.view.*

class UsersRVAdpater(val list: List<UserDetailsItem>) : RecyclerView.Adapter<UsersRVAdpater.ItemViewHolder>() {
    class ItemViewHolder (itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val user = list[position]

        holder.itemView.apply {
            textView3.text = " ID: ${user.pk}"
            textView.text = " Name: ${user.name}"
            textView2.text =" Location: ${user.location}"
        }
    }

    override fun getItemCount(): Int = list.size
}

