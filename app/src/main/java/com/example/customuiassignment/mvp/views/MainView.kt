package com.example.customuiassignment.mvp.views

import com.example.customuiassignment.Delegates.profileDelegates


interface MainView : BaseView
{
    fun navigateToProfile(image : Int)
    fun navigateToProgress()

}