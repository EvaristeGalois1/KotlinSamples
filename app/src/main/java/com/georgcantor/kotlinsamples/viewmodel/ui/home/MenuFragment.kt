package com.georgcantor.kotlinsamples.viewmodel.ui.home

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.georgcantor.kotlinsamples.R
import com.georgcantor.kotlinsamples.viewmodel.model.MenuItem
import kotlinx.android.synthetic.main.fragment_menu.*

class MenuFragment : Fragment() {

    lateinit var viewModel: MenuViewModel
    lateinit var adapter: MenuListAdapter

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_menu, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter = MenuListAdapter(requireContext())
        viewModel = ViewModelProviders.of(requireActivity()).get(MenuViewModel::class.java)

        recycler_view?.addItemDecoration(DividerItemDecoration(requireContext(),
                DividerItemDecoration.VERTICAL))
        recycler_view?.layoutManager = LinearLayoutManager(requireContext())
        recycler_view?.adapter = adapter
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.getMenuItems().observe(this, Observer<List<MenuItem>> { menuItems ->
            if (menuItems != null) {
                adapter.setItems(menuItems)
            }
        })
    }
}