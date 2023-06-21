package com.itxtest.rickandmorty.business.model.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.itxtest.rickandmorty.R

class NavigationManager private constructor() {

    companion object {
        private var instance: NavigationManager? = null

        fun getInstance(): NavigationManager {
            if (instance == null) {
                instance = NavigationManager()
            }
            return instance!!
        }
    }

    var fragmentManager: FragmentManager? = null

    fun navigateTo(
        fragmentCanonicalName: String?,
        arguments: Bundle? = null
    ) {
        if (isFragmentOnBackStack(fragmentCanonicalName)) {
            navigateBackToFragment(fragmentCanonicalName)
        } else {
            navigateToNewFragment(fragmentCanonicalName, arguments)
        }
    }

    private fun isFragmentOnBackStack(fragmentCanonicalName: String?): Boolean {
        fragmentManager?.let { fragmentManager ->
            for (i in 0 until fragmentManager.backStackEntryCount) {
                if (fragmentManager.getBackStackEntryAt(i).name == fragmentCanonicalName) {
                    return true
                }
            }
        }
        return false
    }

    private fun navigateBackToFragment(fragmentCanonicalName: String?) {
        fragmentManager?.popBackStackImmediate(fragmentCanonicalName, 0)
    }

    private fun navigateToNewFragment(
        fragmentCanonicalName: String?,
        arguments: Bundle? = null
    ) {
        fragmentCanonicalName?.let {
            val fragment = Class.forName(fragmentCanonicalName).newInstance() as Fragment
            arguments?.let { fragment.arguments = arguments }
            fragmentManager?.beginTransaction()
                ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                ?.replace(R.id.fragmentContainer, fragment)?.addToBackStack(fragmentCanonicalName)
                ?.commitAllowingStateLoss()
        }
    }
}
