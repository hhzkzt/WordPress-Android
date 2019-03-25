package org.wordpress.android.ui.utils

import android.content.Context
import android.support.annotation.DrawableRes
import android.support.annotation.StringRes
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import org.wordpress.android.ui.utils.UiString.UiStringRes
import org.wordpress.android.ui.utils.UiString.UiStringText
import javax.inject.Inject

class UiHelpers @Inject constructor() {
    fun getTextOfUiString(context: Context, uiString: UiString): String =
            when (uiString) {
                is UiStringRes -> context.getString(uiString.stringRes)
                is UiStringText -> uiString.text
            }

    fun updateVisibility(view: View, visible: Boolean) {
        view.visibility = if (visible) View.VISIBLE else View.GONE
    }

    fun setTextOrHide(view: TextView, uiString: UiString?) {
        val text = if (uiString != null) {
            getTextOfUiString(view.context, uiString)
        } else {
            null
        }
        setTextOrHide(view, text)
    }

    fun setTextOrHide(view: TextView, @StringRes resId: Int?) {
        val text = if (resId != null) {
            view.context.getString(resId)
        } else {
            null
        }
        setTextOrHide(view, text)
    }

    fun setTextOrHide(view: TextView, text: CharSequence?) {
        updateVisibility(view, text != null)
        text?.let {
            view.text = text
        }
    }

    fun setImageOrHide(imageView: ImageView, @DrawableRes resId: Int?) {
        updateVisibility(imageView, resId != null)
        resId?.let {
            imageView.setImageResource(resId)
        }
    }
}
