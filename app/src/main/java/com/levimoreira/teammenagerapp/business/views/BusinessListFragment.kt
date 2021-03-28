package com.levimoreira.teammenagerapp.business.views

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
import com.levimoreira.teammenagerapp.application.entities.Business
import com.levimoreira.teammenagerapp.business.adapters.BusinessListAdapter
import com.levimoreira.teammenagerapp.business.viewmodel.BusinessListViewModel
import com.levimoreira.teammenagerapp.databinding.FragmentBusinessBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * A simple [Fragment] subclass.
 *
 */
@AndroidEntryPoint
class BusinessListFragment : Fragment(R.layout.fragment_business) {
    private var _binding: FragmentBusinessBinding? = null
    private val binding get() = _binding!!

    //  ViewModel
    val businessListViewModel: BusinessListViewModel by viewModels()

    lateinit var adapter: BusinessListAdapter

    var businessList = mutableListOf<Business>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        subscribeToObservers()

        adapter = BusinessListAdapter(businessList)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_business, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentBusinessBinding.bind(view)

        adapter.clickListener = { business ->
            Toast.makeText(requireContext(), business.title, Toast.LENGTH_SHORT).show()
        }

        binding.apply {
            businessRecyclerView.layoutManager = LinearLayoutManager(requireContext())
            businessRecyclerView.adapter = adapter

            addBusiness.setOnClickListener {
                findNavController().navigate(R.id.action_businessListFragment_to_businessAddFragment)
            }
        }
    }

    private fun subscribeToObservers() {
        businessListViewModel.allBusinesses.observe(viewLifecycleOwner, {
            it?.let {
                businessList.clear()
                businessList.addAll(it)
                adapter.notifyDataSetChanged()
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
