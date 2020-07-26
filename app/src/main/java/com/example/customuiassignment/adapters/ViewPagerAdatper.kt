package com.example.customuiassignment.adapters

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.customuiassignment.fragments.aboutFragment
import com.example.customuiassignment.fragments.contactFragment
import com.example.customuiassignment.fragments.projectTaskFragment

class ViewPagerAdatper(context: Context, fragmetManager: FragmentManager):

    FragmentPagerAdapter(fragmetManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    val title = arrayListOf("Project Task", "Contact", "About")
    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                return projectTaskFragment.newInstance("A", "B")
            }

            1 -> {
                return contactFragment.newInstance("A", "B")
            }
            2 -> {
                return aboutFragment.newInstance("A", "B")
            }
            else -> {
                return projectTaskFragment.newInstance("A", "B")
            }
        }
    }


    override fun getCount(): Int {
        return title.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return title[position]
    }
}

