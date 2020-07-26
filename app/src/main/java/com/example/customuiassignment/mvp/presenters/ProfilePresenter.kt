package com.example.customuiassignment.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.example.customuiassignment.mvp.views.MainView
import com.example.customuiassignment.mvp.views.ProfileView

interface ProfilePresenter : BasePresenter<ProfileView>{
    fun onUiReady(lifecycleOwner: LifecycleOwner)
}