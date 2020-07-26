package com.example.customuiassignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.customuiassignment.Delegates.profileDelegates
import com.example.customuiassignment.R
import com.example.customuiassignment.views.viewholders.ProfileRecyclerViewHolder

class ProfileRecyclerAdapter(val delegate : profileDelegates) : RecyclerView.Adapter<ProfileRecyclerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_progress,parent,false)
        return ProfileRecyclerViewHolder(view,delegate)
    }

    override fun getItemCount(): Int {
        return 9
    }

    override fun onBindViewHolder(holder: ProfileRecyclerViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}