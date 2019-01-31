package com.salton123.cargo.ui.fragment

import android.os.Bundle
import com.salton123.base.BaseSupportFragment
import com.salton123.base.FragmentDelegate
import com.salton123.cargo.R
import com.salton123.cargo.ui.view.BottomTabWidget
import kotlinx.android.synthetic.main.comp_home_page.*
import me.yokeyword.fragmentation.SupportFragment

/**
 * User: newSalton@outlook.com
 * Date: 2019/1/1 6:25 PM
 * ModifyTime: 6:25 PM
 * Description:
 */

class HomePageComp : BaseSupportFragment(), BottomTabWidget.OnTabClickListener {
    val HOME = 0
    val MOMENT = 1
    val LIVE = 2
    val MESSAGE = 3
    val MINE = 4

    private val mFragments = arrayOf<SupportFragment>(
        FragmentDelegate.newInstance(RecommondComp::class.java),
        FragmentDelegate.newInstance(RecommondComp::class.java),
        FragmentDelegate.newInstance(RecommondComp::class.java),
        FragmentDelegate.newInstance(RecommondComp::class.java),
        FragmentDelegate.newInstance(RecommondComp::class.java)
    )

    override fun getLayout(): Int = R.layout.comp_home_page

    override fun initVariable(savedInstanceState: Bundle?) {
        loadMultipleRootFragment(R.id.main_container, HOME,
            mFragments[HOME],
            mFragments[MOMENT],
            mFragments[LIVE],
            mFragments[MESSAGE],
            mFragments[MINE])
    }

    override fun initViewAndData() {
    }

    override fun initListener() {
        bottomTabWidget.setOnTabClickListener(this)
    }

    override fun onTabClick(lastClickIndex: Int, index: Int, isRepeatClick: Boolean) {
        if (index == LIVE) {
            return
        }
        showHideFragment(mFragments[index])
    }
}