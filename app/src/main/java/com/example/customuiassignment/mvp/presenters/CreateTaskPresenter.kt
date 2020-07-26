package com.example.customuiassignment.mvp.presenters

import com.example.customuiassignment.mvp.views.CreateTaskView

interface CreateTaskPresenter : BasePresenter<CreateTaskView>{
    fun onTapClientProfile()
    fun onTapCalender()
}