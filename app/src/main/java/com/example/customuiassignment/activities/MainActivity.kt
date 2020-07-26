package com.example.customuiassignment.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.customuiassignment.R
import com.example.customuiassignment.adapters.ProgressRecyclerAdapter
import com.example.customuiassignment.mvp.presenters.Impls.MainPresenterImpl
import com.example.customuiassignment.mvp.presenters.MainPresenter
import com.example.customuiassignment.mvp.views.MainView

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , MainView{

    private lateinit var mPresenter: MainPresenter

    private val mAdapter: ProgressRecyclerAdapter = ProgressRecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpPresenter()
        setUpRecyclerAndProgress()
        setUpListeners()
        mPresenter.onUiReady(this)
    }

    override fun navigateToProgress() {
      startActivity(CreatetaskActivity.newIntent(this))
    }
    override fun navigateToProfile(image  : Int) {
        startActivity(ProfileActivity.newIntent(this))
    }

    private fun setUpListeners() {
        imageOne.setOnClickListener {
            mPresenter.onTapProfile(R.id.imageOne)

        }
        imageTwo.setOnClickListener {
            mPresenter.onTapProfile(R.id.imageTwo)
        }
        imageThree.setOnClickListener {
            mPresenter.onTapProfile(R.id.imageThree)
        }

        imageMore.setOnClickListener {
            mPresenter.onTapProgress()
        }
    }
    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(MainPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpRecyclerAndProgress(){
        progressBar.max = 9
        progressBar.progress = 5

        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = mAdapter
    }
    }

