package com.levimoreira.teammenagerapp.organization.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.levimoreira.teammenagerapp.R
import com.levimoreira.teammenagerapp.application.entities.Organization
import com.levimoreira.teammenagerapp.inflate
import kotlinx.android.synthetic.main.organization_item_view.view.*

class OrganizationListAdapter(private val list: List<Organization>) : RecyclerView.Adapter<OrganizationListAdapter.OrganizationViewHolder>() {
    lateinit var clickListener: (Organization) -> (Unit)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrganizationViewHolder = OrganizationViewHolder(parent.inflate(R.layout.organization_item_view))

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: OrganizationViewHolder, position: Int) {
        val organization: Organization = list[position]
        holder.bind(organization, this.clickListener)
    }


    inner class OrganizationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Organization, clicklistener: (Organization) -> Unit) = with(itemView) {
            name.text = item.name
            phone.text = item.phone
            address.text = item.address
            setOnClickListener { clicklistener(item) }
        }
    }
}