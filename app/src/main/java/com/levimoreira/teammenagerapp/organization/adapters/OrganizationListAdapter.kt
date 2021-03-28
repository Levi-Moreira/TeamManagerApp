package com.levimoreira.teammenagerapp.organization.adapters

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import com.levimoreira.teammenagerapp.application.entities.Organization
import com.levimoreira.teammenagerapp.databinding.OrganizationItemViewBinding

class OrganizationListAdapter(private val list: List<Organization>) : RecyclerView.Adapter<OrganizationListAdapter.OrganizationViewHolder>() {
    lateinit var clickListener: (Organization) -> (Unit)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrganizationViewHolder {
        val binding = OrganizationItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OrganizationViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: OrganizationViewHolder, position: Int) {
        val organization: Organization = list[position]
        holder.bind(organization, this.clickListener)
    }

    inner class OrganizationViewHolder(private val binding: OrganizationItemViewBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Organization, clicklistener: (Organization) -> Unit) = with(binding.root) {
            binding.apply {
                name.text = item.name
                phone.text = item.phone
                address.text = item.address
                setOnClickListener { clicklistener(item) }
            }
        }
    }
}