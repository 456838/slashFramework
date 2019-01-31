package com.salton123.cargo.feature

import android.support.v4.app.FragmentActivity
import android.support.v7.widget.Toolbar
import android.widget.Toast
import com.salton123.base.feature.IFeature
import com.salton123.cargo.R
import com.salton123.log.XLog

/**
 * User: newSalton@outlook.com
 * Date: 2019/1/2 11:13 AM
 * ModifyTime: 11:13 AM
 * Description:
 */
const val TAG = "ToolbarFeature"
class ToolbarFeature(var mActivity: FragmentActivity) : IFeature {

    override fun onBind() {
        var toolbar = mActivity.findViewById<Toolbar>(R.id.toolbar)
        if (toolbar != null) {
            initToolbarNav(toolbar)
        } else {
            Toast.makeText(mActivity, "can not find toolbar , please check your layout!", Toast.LENGTH_LONG).show()
            XLog.e(TAG, "can not find toolbar , please check your layout!")
        }
    }

    override fun onUnBind() {
    }

    private fun initToolbarNav(toolbar: Toolbar) {
        toolbar.setNavigationIcon(R.mipmap.ic_arrow_back_white_24dp)
        toolbar.setNavigationOnClickListener { mActivity.onBackPressed() }
    }
}