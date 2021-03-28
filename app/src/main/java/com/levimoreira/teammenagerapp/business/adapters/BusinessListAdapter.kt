package com.levimoreira.teammenagerapp.business.adapters

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import com.levimoreira.teammenagerapp.R
import com.levimoreira.teammenagerapp.application.entities.Business
import com.levimoreira.teammenagerapp.databinding.BusinessItemViewBinding
import com.levimoreira.teammenagerapp.inflate

class BusinessListAdapter(private val list: List<Business>) : RecyclerView.Adapter<BusinessListAdapter.BusinessViewHolder>() {
    lateinit var clickListener: (Business) -> (Unit)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BusinessViewHolder {
        val binding = BusinessItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BusinessViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: BusinessViewHolder, position: Int) {
        val business: Business = list[position]
        holder.bind(business, this.clickListener)
    }

    inner class BusinessViewHolder(private val binding: BusinessItemViewBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Business, clicklistener: (Business) -> Unit) = with(binding.root) {
            binding.apply {
                title.text = item.title
                description.text = item.description
                value.text = item.value
                state.text = item.state
                deadline.text = item.deadline
                setOnClickListener { clicklistener(item) }
            }
        }
    }
}