package com.example.customuiassignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.customuiassignment.R
import com.example.customuiassignment.views.viewholders.ProgressRecyclerViewHolder

class ProgressRecyclerAdapter : RecyclerView.Adapter<ProgressRecyclerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgressRecyclerViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_progress,parent,false)
        return ProgressRecyclerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 9
    }

    override fun onBindViewHolder(holder: ProgressRecyclerViewHolder, position: Int) {
    }
}