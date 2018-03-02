package com.ilbesculpi.themoviedroid.ui.common

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.ilbesculpi.themoviedroid.R


class HostFragment : Fragment() {
    
    private var fragment: Fragment? = null;
    
    companion object {
        fun newInstance(fragment: Fragment): HostFragment {
            val hostFragment = HostFragment();
            hostFragment.fragment = fragment;
            return hostFragment;
        }
    }
    
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState);
        val view = inflater!!.inflate(R.layout.host_fragment, container, false)
        if(fragment != null) {
            replaceFragment(fragment!!, false);
        }
        return view
    }
    
    fun replaceFragment(fragment: Fragment, addToBackstack: Boolean = false, backStack: String? = null) {
        if(addToBackstack) {
            childFragmentManager.beginTransaction()
                    .replace(R.id.host_fragment, fragment)
                    .addToBackStack(backStack)
                    .commit();
        }
        else {
            childFragmentManager.beginTransaction()
                    .replace(R.id.host_fragment, fragment)
                    .commit();
        }
    }
    
}