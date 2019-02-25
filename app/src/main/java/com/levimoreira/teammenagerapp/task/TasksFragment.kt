package com.levimoreira.teammenagerapp.task


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.levimoreira.teammenagerapp.R


/**
 * A simple [Fragment] subclass.
 *
 */
class TasksFragment : androidx.fragment.app.Fragment() {
    val TAG = "TasksFragment"
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tasks, container, false)
    }


}
