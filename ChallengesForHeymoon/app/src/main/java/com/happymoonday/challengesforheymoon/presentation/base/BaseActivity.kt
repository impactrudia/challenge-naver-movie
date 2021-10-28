package com.happymoonday.challengesforheymoon.presentation.base

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDialog
import com.happymoonday.challengesforheymoon.R

abstract class BaseActivity() : AppCompatActivity() {

    var progressDialog: AppCompatDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        progressDialog = AppCompatDialog(this, R.style.Theme_AppCompat)
        progressDialog!!.setCancelable(false)
        progressDialog!!.setContentView(R.layout.dialog_progress)
        progressDialog!!.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    open fun showProgress(){
        progressDialog?.let {
            if(!isFinishing && !it.isShowing){
                it.show()
            }
        }
    }

    open fun hideProgress(){
        progressDialog?.let {
            if(!isFinishing && it.isShowing){
                it.dismiss()
            }
        }
    }

}