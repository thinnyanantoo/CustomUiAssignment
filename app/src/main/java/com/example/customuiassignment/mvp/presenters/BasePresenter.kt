package com.example.customuiassignment.mvp.presenters

import com.example.customuiassignment.mvp.views.BaseView

interface BasePresenter<T: BaseView> {
    fun initPresenter(view : T)
}