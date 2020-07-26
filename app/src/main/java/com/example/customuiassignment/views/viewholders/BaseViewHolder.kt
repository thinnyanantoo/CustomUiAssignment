package com.example.customuiassignment.views.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
    var mData  = null

   abstract fun bindData()
}