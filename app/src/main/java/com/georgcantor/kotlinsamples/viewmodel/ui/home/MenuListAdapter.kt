package com.georgcantor.kotlinsamples.viewmodel.ui.home

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import com.bumptech.glide.Glide
import com.georgcantor.kotlinsamples.R
import com.georgcantor.kotlinsamples.viewmodel.model.MenuItem
import kotlinx.android.synthetic.main.menu_item.view.*

class MenuListAdapter(private val context: Context) :
        RecyclerView.Adapter<MenuListAdapter.MyViewHolder>() {

    private var itemList = ArrayList<MenuItem>()

    @NonNull
    override fun onCreateViewHolder(@NonNull parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.menu_item, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(@NonNull holder: MyViewHolder, position: Int) {
        holder.bind(itemList.get(position))
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal fun bind(menuItem: MenuItem) {
            itemView.name.text = menuItem.name
            itemView.description.text = menuItem.description
            itemView.price.text = "Price: " + menuItem.price

            itemView.thumbnail.let {
                Glide.with(context)
                        .load(menuItem.thumbnail)
                        .into(it)
            }
        }
    }

    fun setItems(menuItems: List<MenuItem>) {
        itemList.clear()
        itemList.addAll(menuItems)
        notifyDataSetChanged()
    }
}