package com.levimoreira.teammenagerapp.person.view

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.levimoreira.teammenagerapp.R
import com.levimoreira.teammenagerapp.application.entities.Address
import com.levimoreira.teammenagerapp.application.entities.Person
import com.levimoreira.teammenagerapp.person.viewmodel.PersonItemViewModel
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_add_person.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 *
 */
class PersonAddFragment : DaggerFragment(), LifecycleOwner {
    val TAG = "OrganizationAddFragment"

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var viewModel: PersonItemViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(PersonItemViewModel::class.java)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_person, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        createPersonButton.setOnClickListener {
            val person = Person(id = null,
                name = inputName.text.toString(),
                phone = inputPhone.text.toString(),
                email = inputEmail.text.toString(),
                address = Address("Ari Maian", "488"))

            viewModel.createPerson(person).observe(this, Observer {
                this.view?.let { view ->
                    Snackbar.make(view, R.string.person_created, Snackbar.LENGTH_SHORT).show()
                }
                findNavController().popBackStack()
            })
        }
    }

    companion object {
        val TAG = "OrganizationAddFragment"
    }
}
