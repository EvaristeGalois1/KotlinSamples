package com.georgcantor.kotlinsamples.viewmodel.ui.home

import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import butterknife.BindView
import com.georgcantor.kotlinsamples.R


class MenuFragment: Fragment() {

    @BindView(R.id.recycler_view)
    var recyclerView: RecyclerView? = null


}