package com.example.customuiassignment.mvp.presenters.Impls

import android.widget.ImageView
import androidx.lifecycle.LifecycleOwner
import com.example.customuiassignment.R
import com.example.customuiassignment.mvp.presenters.AbstractBasePresenter
import com.example.customuiassignment.mvp.presenters.MainPresenter
import com.example.customuiassignment.mvp.views.MainView


class MainPresenterImpl : MainPresenter , AbstractBasePresenter<MainView>(){
    override fun onTapProgress() {
        mView?.navigateToProgress()
    }

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
    }

    override fun onTapProfile(profileImage: Int) {
        mView?.navigateToProfile(R.id.imageProfleView)

    }
}