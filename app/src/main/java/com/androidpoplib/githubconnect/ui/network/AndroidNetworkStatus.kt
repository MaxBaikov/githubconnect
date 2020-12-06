package com.androidpoplib.githubconnect.ui.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.ConnectivityManager.NetworkCallback
import android.net.Network
import android.net.NetworkRequest
import android.util.Log
import com.androidpoplib.githubconnect.ui.GithubApplication
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.subjects.BehaviorSubject

class AndroidNetworkStatus : INetworkStatus {
    private val statusObject = BehaviorSubject.create<Boolean>()
    override val isOnline: Observable<Boolean> get() = statusObject
    override val isOnlineSingle: Single<Boolean> get() = statusObject.first(false)

    companion object {
        private val TAG = AndroidNetworkStatus::class.java.simpleName
    }

    init {
        statusObject.onNext(false)

        val connectivityManager = GithubApplication.instance
            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val networkRequest = NetworkRequest.Builder().build()

        connectivityManager.registerNetworkCallback(networkRequest, object : NetworkCallback() {
            override fun onAvailable(network: Network) {
                super.onAvailable(network)
                if (GithubApplication.DEBUG) {
                    Log.d(TAG, "onAvailable")
                }
                statusObject.onNext(true)
            }

            override fun onUnavailable() {
                super.onUnavailable()
                if (GithubApplication.DEBUG) {
                    Log.d(TAG, "onUnavailable")
                }
                statusObject.onNext(false)
            }

            override fun onLost(network: Network) {
                super.onLost(network)
                if (GithubApplication.DEBUG) {
                    Log.d(TAG, "onLost")
                }
                statusObject.onNext(false)
            }
        })
    }
}
