package com.levimoreira.teammenagerapp.person.view


import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.levimoreira.teammenagerapp.R
import com.levimoreira.teammenagerapp.application.entities.Person
import com.levimoreira.teammenagerapp.main.OnActivityCallback
import com.levimoreira.teammenagerapp.person.adapters.PersonListAdapter
import com.levimoreira.teammenagerapp.person.viewmodel.PersonListViewModel
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_people.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 *
 */
class PersonListFragment : DaggerFragment(), LifecycleOwner {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var viewModel: PersonListViewModel

    lateinit var adapter: PersonListAdapter

    var personList = mutableListOf<Person>()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(PersonListViewModel::class.java)
        adapter = PersonListAdapter(personList)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_people, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter.clickListener = { person ->
            Toast.makeText(this.context, person.name, Toast.LENGTH_SHORT).show()
        }

        personRecyclerView.layoutManager = LinearLayoutManager(this.context)
        personRecyclerView.adapter = adapter


        addPerson.setOnClickListener {
            it.findNavController().navigate(R.id.action_personListFragment_to_personAddFragment)
            it.visibility = View.INVISIBLE
        }
        viewModel.getAllPersons().observe(this, Observer {
            it?.let {
                personList.clear()
                personList.addAll(it)
                adapter.notifyDataSetChanged()
            }
        })
    }

    companion object {
        val TAG = "PersonListFragment"
    }

}
