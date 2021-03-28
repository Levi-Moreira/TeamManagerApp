package com.levimoreira.teammenagerapp.person.view

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.levimoreira.teammenagerapp.R
import com.levimoreira.teammenagerapp.application.entities.Person
import com.levimoreira.teammenagerapp.databinding.FragmentAddPersonBinding
import com.levimoreira.teammenagerapp.person.viewmodel.PersonItemViewModel

/**
 * A simple [Fragment] subclass.
 *
 */
class PersonAddFragment : Fragment(R.layout.fragment_add_person), View.OnClickListener {
    private var _binding: FragmentAddPersonBinding? = null
    private val binding get() = _binding!!

    //  ViewModels
    private val personItemViewModel: PersonItemViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentAddPersonBinding.bind(view)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.createPersonButton -> {
                createPerson()
            }
        }
    }

    private fun createPerson() {
        binding.apply {
            val person = Person(
                id = null,
                name = inputName.text.toString(),
                phone = inputPhone.text.toString(),
                email = inputEmail.text.toString()
            )
            personItemViewModel.createPerson(person)
            Snackbar.make(requireView(), R.string.person_created, Snackbar.LENGTH_SHORT).show()
        }
        findNavController().popBackStack()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
