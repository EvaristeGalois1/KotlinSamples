package com.georgcantor.kotlinsamples.validation.fragment

import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.georgcantor.kotlinsamples.R
import io.reactivex.Observable
import rx.subscriptions.CompositeSubscription

class LoginFragment : BaseFragment() {

    private var loginFragment: LoginFragment? = null
    private var subscription: CompositeSubscription? = null
    private var emailObservable: Observable<CharSequence>? = null
    private var passwordObservable: Observable<CharSequence>? = null

    private lateinit var editEmail: EditText

    fun getInstant(): LoginFragment {
        if (loginFragment == null) {
            loginFragment = LoginFragment()
        }

        return loginFragment as LoginFragment
    }

    override fun getLayoutResource(): Int {
        return R.layout.fragment_login
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        editEmail = view.findViewById(R.id.edt_email)

        subscription = CompositeSubscription()
    }
}