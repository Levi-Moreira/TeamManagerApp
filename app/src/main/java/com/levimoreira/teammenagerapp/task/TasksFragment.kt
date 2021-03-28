package com.levimoreira.teammenagerapp.task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.levimoreira.teammenagerapp.R
import com.levimoreira.teammenagerapp.databinding.FragmentTasksBinding

/**
 * A simple [Fragment] subclass.
 *
 */
class TasksFragment : Fragment(R.layout.fragment_tasks) {
    private var _binding: FragmentTasksBinding? = null
    private val binding get() = _binding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentTasksBinding.bind(view)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
