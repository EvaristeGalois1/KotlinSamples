package com.georgcantor.kotlinsamples.viewmodel.ui.home

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.Unbinder
import com.georgcantor.kotlinsamples.R
import com.georgcantor.kotlinsamples.viewmodel.model.MenuItem

class MenuFragment : Fragment() {

    @BindView(R.id.recycler_view)
    var recyclerView: RecyclerView? = null

    lateinit var viewModel: MenuViewModel
    lateinit var unbinder: Unbinder
    lateinit var adapter: MenuListAdapter

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_menu, container, false)
        unbinder = ButterKnife.bind(this, view)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter = MenuListAdapter(requireContext())
        viewModel = ViewModelProviders.of(requireActivity()).get(MenuViewModel::class.java)

        recyclerView?.addItemDecoration(DividerItemDecoration(requireContext(),
                DividerItemDecoration.VERTICAL))
        recyclerView?.layoutManager = LinearLayoutManager(requireContext())
        recyclerView?.adapter = adapter
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