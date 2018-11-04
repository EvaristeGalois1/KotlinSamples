package com.georgcantor.kotlinsamples.validation.fragment

import com.georgcantor.kotlinsamples.R
import io.reactivex.Observable
import rx.subscriptions.CompositeSubscription


class LoginFragment : BaseFragment() {

    private var loginFragment: LoginFragment? = null

    private val subscription: CompositeSubscription? = null
    private val emailObservable: Observable<CharSequence>? = null
    private val passwordObservable: Observable<CharSequence>? = null

    fun getInstant(): LoginFragment {
        if (loginFragment == null) {
            loginFragment = LoginFragment()
        }

        return loginFragment as LoginFragment
    }

    override fun getLayoutResource(): Int {
        return R.layout.fragment_login
    }
}