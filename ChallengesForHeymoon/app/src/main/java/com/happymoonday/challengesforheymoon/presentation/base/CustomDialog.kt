package com.happymoonday.challengesforheymoon.presentation.base

import android.content.Context
import androidx.appcompat.app.AlertDialog
import com.happymoonday.challengesforheymoon.R

/**
 * 다이얼로그 팝업
 */
object CustomDialog {

    private var popup: AlertDialog? = null

    fun showDefaultDialog(
        context: Context,
        title: String? = "",
        callbackLeft: ((Any) -> Unit)? = null,
        callbackRight: ((Any) -> Unit)? = null,
        textLeft: String? = context.getString(R.string.no),
        textRight: String? = context.getString(R.string.yes)
    ) {
        popup = this.let {
            val builder = AlertDialog.Builder(context)
            builder.apply {
                setTitle(title)
                callbackLeft?.let {
                    setPositiveButton(
                        textLeft
                    ) { dialog, id ->
                        callbackLeft?.invoke("")
                        popup?.dismiss()
                    }
                }
                callbackRight?.let {
                    setNegativeButton(
                        textRight
                    ) { dialog, id ->
                        callbackRight?.invoke("")
                        popup?.dismiss()
                    }
                }
            }
            builder.create()
        }
        popup?.show()
    }

}