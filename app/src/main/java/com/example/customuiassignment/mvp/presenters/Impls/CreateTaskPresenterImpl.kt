package com.example.customuiassignment.mvp.presenters.Impls

import com.example.customuiassignment.mvp.presenters.AbstractBasePresenter
import com.example.customuiassignment.mvp.presenters.CreateTaskPresenter
import com.example.customuiassignment.mvp.views.CreateTaskView

class CreateTaskPresenterImpl :CreateTaskPresenter, AbstractBasePresenter<CreateTaskView>() {
    override fun onTapClientProfile() {
        mView?.navigateToProfile()

    }

    override fun onTapCalender() {
        mView?.showCalender()
    }


}