package com.example.customuiassignment.activities

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.customuiassignment.R
import com.example.customuiassignment.mvp.presenters.CreateTaskPresenter
import com.example.customuiassignment.mvp.presenters.Impls.CreateTaskPresenterImpl
import com.example.customuiassignment.mvp.views.CreateTaskView
import kotlinx.android.synthetic.main.activity_createtask.*
import java.util.*

class CreatetaskActivity : AppCompatActivity() , CreateTaskView{

    override fun showCalender() {
       setCalendar()
    }

    override fun navigateToProfile() {
       startActivity(ProfileActivity.newIntent(this))
    }

    private lateinit var mPresenter : CreateTaskPresenter

    companion object {
        fun newIntent (context : Context): Intent {
            return Intent (context,CreatetaskActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_createtask)

       setUpPresenter()
        setUpListener()

    }
    private fun setUpPresenter(){
        mPresenter = ViewModelProviders.of(this).get(CreateTaskPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }


    private fun setUpListener(){
        ivClient.setOnClickListener {
            mPresenter.onTapClientProfile()
        }
        etCalentarTwo.setOnClickListener {
            mPresenter.onTapCalender()
        }
        etCalendar.setOnClickListener {
            mPresenter.onTapCalender()
        }
    }

    private fun setCalendar(){
        val calendarr = Calendar.getInstance()
        val day = calendarr.get(Calendar.DAY_OF_MONTH)
        val month = calendarr.get(Calendar.MONTH)
        val year = calendarr.get(Calendar.YEAR)
        val dpd = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                // Display Selected date in textbox
                etCalendar.setText("" + dayOfMonth + " " + monthOfYear + ", " + year)
            }, year, month, day
        )
        dpd.show()
    }



}
