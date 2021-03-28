package com.levimoreira.teammenagerapp.person.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.levimoreira.teammenagerapp.R
import com.levimoreira.teammenagerapp.application.entities.Person
import com.levimoreira.teammenagerapp.databinding.FragmentPeopleBinding
import com.levimoreira.teammenagerapp.person.adapters.PersonListAdapter
import com.levimoreira.teammenagerapp.person.viewmodel.PersonListViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * A simple [Fragment] subclass.
 *
 */
@AndroidEntryPoint
class PersonListFragment : Fragment(R.layout.fragment_people) {
    private var _binding: FragmentPeopleBinding? = null
    private val binding get() = _binding!!

    //  Viewmodels
    private val personListViewModel: PersonListViewModel by viewModels()

    lateinit var adapter: PersonListAdapter

    var personList = mutableListOf<Person>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        subscribeToObservers()

        adapter = PersonListAdapter(personList)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_people, container, false)
    }

    private fun subscribeToObservers() {
        personListViewModel.allPersons.observe(viewLifecycleOwner, {
            it?.let {
                personList.clear()
                personList.addAll(it)
                adapter.notifyDataSetChanged()
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentPeopleBinding.bind(view)

        adapter.clickListener = { person ->
            Toast.makeText(this.context, person.name, Toast.LENGTH_SHORT).show()
        }

        binding.apply {
            personRecyclerView.layoutManager = LinearLayoutManager(requireContext())
            personRecyclerView.adapter = adapter


            addPerson.setOnClickListener {
                findNavController().navigate(R.id.action_personListFragment_to_personAddFragment)
                it.visibility = View.INVISIBLE
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
