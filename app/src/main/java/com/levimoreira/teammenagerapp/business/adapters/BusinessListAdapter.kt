package com.levimoreira.teammenagerapp.business.adapters

import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.levimoreira.teammenagerapp.R
import com.levimoreira.teammenagerapp.application.entities.Business
import com.levimoreira.teammenagerapp.inflate
import kotlinx.android.synthetic.main.business_item_view.view.*

class BusinessListAdapter(private val list: List<Business>) : androidx.recyclerview.widget.RecyclerView.Adapter<BusinessListAdapter.BusinessViewHolder>() {
    lateinit var clickListener: (Business) -> (Unit)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BusinessViewHolder = BusinessViewHolder(parent.inflate(R.layout.business_item_view))

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: BusinessViewHolder, position: Int) {
        val business: Business = list[position]
        holder.bind(business, this.clickListener)
    }


    inner class BusinessViewHolder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {
        fun bind(item: Business, clicklistener: (Business) -> Unit) = with(itemView) {
            title.text = item.title
            description.text = item.description
            value.text = item.value
            state.text = item.state
            deadline.text = item.deadline
            setOnClickListener { clicklistener(item) }
        }
    }
}