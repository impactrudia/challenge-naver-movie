package com.happymoonday.challengesforheymoon.presentation.base

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer

abstract class BaseFragment : Fragment() {
    /**
     * lateinit var 키워드로 생성해준다.
     */
    abstract val binding: ViewDataBinding
    abstract val viewModel: BaseViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.showProgress.observe(viewLifecycleOwner, Observer {
            if (it) showProgress() else hideProgress()
        })
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    open fun showProgress() {
        val mActivity = requireActivity()
        if (mActivity is BaseActivity) {
            mActivity.showProgress()
        }
    }

    open fun hideProgress() {
        val mActivity = requireActivity()
        if (mActivity is BaseActivity) {
            mActivity.hideProgress()
        }
    }

}