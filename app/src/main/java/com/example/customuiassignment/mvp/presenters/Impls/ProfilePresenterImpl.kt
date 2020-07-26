package com.example.customuiassignment.mvp.presenters.Impls

import androidx.lifecycle.LifecycleOwner
import com.example.customuiassignment.R
import com.example.customuiassignment.mvp.presenters.AbstractBasePresenter
import com.example.customuiassignment.mvp.presenters.ProfilePresenter
import com.example.customuiassignment.mvp.views.ProfileView

class ProfilePresenterImpl : ProfilePresenter, AbstractBasePresenter<ProfileView>() {
    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
        mView?.showProfile(R.drawable.profile1)
    }



}