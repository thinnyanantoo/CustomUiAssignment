package com.example.customuiassignment.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.customuiassignment.R
import com.example.customuiassignment.adapters.ViewPagerAdatper
import com.example.customuiassignment.mvp.presenters.Impls.ProfilePresenterImpl
import com.example.customuiassignment.mvp.presenters.ProfilePresenter
import com.example.customuiassignment.mvp.views.ProfileView
import kotlinx.android.synthetic.main.activity_profile.*


class ProfileActivity : AppCompatActivity() , ProfileView {
    private lateinit var mPresenter: ProfilePresenter
    var mimage : Int = R.id.imageProfleView
    lateinit var adapter: ViewPagerAdatper

    companion object {
        fun newIntent (context : Context): Intent {
            return Intent (context,ProfileActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        setUpPresenter()
        setUpRecycler()

        mPresenter.onUiReady(this)

    }
    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(ProfilePresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }
    private fun setUpRecycler(){
        adapter = ViewPagerAdatper(this, supportFragmentManager)
        vpPager.adapter = adapter
        tabs.setupWithViewPager(vpPager)
    }
    override fun showProfile(image: Int) {
        mimage = image
    }
}
