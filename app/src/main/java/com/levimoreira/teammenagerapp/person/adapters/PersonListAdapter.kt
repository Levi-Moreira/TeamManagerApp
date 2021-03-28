package com.levimoreira.teammenagerapp.person.adapters

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import com.levimoreira.teammenagerapp.application.entities.Person
import com.levimoreira.teammenagerapp.databinding.PersonItemViewBinding

class PersonListAdapter(val list: List<Person>) : RecyclerView.Adapter<PersonListAdapter.PersonViewHolder>() {

    lateinit var clickListener: (Person) -> (Unit)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val binding = PersonItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PersonViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val person: Person = list[position]
        holder.bind(person, this.clickListener)
    }

    inner class PersonViewHolder(private val binding: PersonItemViewBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Person, clicklistener: (Person) -> Unit) = with(binding.root) {
            binding.apply {
                name.text = item.name
                phone.text = item.phone
                email.text = item.email
                setOnClickListener { clicklistener(item) }
            }
        }
    }
}