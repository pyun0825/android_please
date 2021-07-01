package com.example.android_please.adapters

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.android_please.fragments.FirstFragment
import com.example.android_please.fragments.SecondFragment
import com.example.android_please.fragments.ThirdFragment

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle, context: Context): FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    var mCon = context

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->{
                FirstFragment(mCon)
            }
            1->{
                SecondFragment()
            }
            2->{
                ThirdFragment()
            }
            else->{
                Fragment()
            }
        }
    }


}