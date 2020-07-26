package com.example.customuiassignment.mvp.presenters

import android.widget.ImageView
import androidx.lifecycle.LifecycleOwner
import com.example.customuiassignment.Delegates.profileDelegates
import com.example.customuiassignment.mvp.views.MainView

interface MainPresenter : BasePresenter<MainView> ,profileDelegates{
    fun onUiReady(lifecycleOwner: LifecycleOwner)

    override fun onTapProfile(profileImageView: Int)

    override fun onTapProgress()
}