package com.salton123.register

import android.os.Bundle
import com.salton123.base.BaseSupportActivity
import com.salton123.base.FragmentDelegate
import com.salton123.cargo.R

/**
 * User: newSalton@outlook.com
 * Date: 2019/1/31 13:54
 * ModifyTime: 13:54
 * Description:
 */

class MainAty : BaseSupportActivity() {
    override fun getLayout(): Int = R.layout.aty_main
    override fun initVariable(savedInstanceState: Bundle?) {
    }

    override fun initViewAndData() {
        loadRootFragment(R.id.clRoot, FragmentDelegate.newInstance(RegisterComp::class.java))
    }

}