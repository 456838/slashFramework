package com.salton123.cargo.browser

import android.os.Bundle
import com.salton123.base.BaseSupportActivity
import com.salton123.cargo.R

/**
 * User: newSalton@outlook.com
 * Date: 2019/1/22 22:14
 * ModifyTime: 22:14
 * Description:
 */
class BrowserMainAty : BaseSupportActivity() {
    override fun getLayout(): Int = R.layout.salton_fm_container
    override fun initVariable(savedInstanceState: Bundle?) {

    }

    override fun initViewAndData() {
        loadRootFragment(R.id.fl_container, BrowserPageComp.newInstance())
    }

}