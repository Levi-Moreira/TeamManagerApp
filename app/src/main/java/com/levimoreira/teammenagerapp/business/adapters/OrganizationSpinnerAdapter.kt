package com.levimoreira.teammenagerapp.business.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.levimoreira.teammenagerapp.R
import com.levimoreira.teammenagerapp.application.entities.Organization


class OrganizationSpinnerAdapter(val context: Context?, val list: List<Organization>) : BaseAdapter() {

    override fun getItemId(p0: Int): Long {
        list[p0].id?.let {
            return it
        }
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var holder: SpinnerViewHolder
        var view: View



        if (convertView == null) {
            holder = SpinnerViewHolder()
            view = LayoutInflater.from(context).inflate(R.layout.organization_spinner_list, parent, false)
            holder.organizationName = view.findViewById(R.id.organizationName) as TextView
        } else {
            view = convertView
            holder = convertView.tag as SpinnerViewHolder
        }

        holder.organizationName?.text = list[position].name
        view.tag = holder

        return view
    }

    override fun getItem(p0: Int): Any = list[p0]

    override fun getCount(): Int = list.size


    inner class SpinnerViewHolder {
        var organizationName: TextView? = null
    }
}