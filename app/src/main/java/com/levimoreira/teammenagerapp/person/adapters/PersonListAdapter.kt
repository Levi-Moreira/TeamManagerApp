package com.levimoreira.teammenagerapp.person.adapters

import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.levimoreira.teammenagerapp.R
import com.levimoreira.teammenagerapp.application.entities.Person
import com.levimoreira.teammenagerapp.inflate
import kotlinx.android.synthetic.main.person_item_view.view.*

class PersonListAdapter(val list: List<Person>) : androidx.recyclerview.widget.RecyclerView.Adapter<PersonListAdapter.PersonViewHolder>() {

    lateinit var clickListener: (Person) -> (Unit)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder = PersonViewHolder(parent.inflate(R.layout.person_item_view))

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val person: Person = list[position]
        holder.bind(person, this.clickListener)
    }

    inner class PersonViewHolder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {
        fun bind(item: Person, clicklistener: (Person) -> Unit) = with(itemView) {
            name.text = item.name
            phone.text = item.phone
            email.text = item.email
            setOnClickListener { clicklistener(item) }
        }
    }
}