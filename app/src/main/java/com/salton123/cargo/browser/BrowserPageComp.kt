package com.salton123.cargo.browser

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.salton123.base.BaseSupportFragment
import com.salton123.cargo.R
import kotlinx.android.synthetic.main.comp_browser_page.*
import me.everything.android.ui.overscroll.OverScrollDecoratorHelper

/**
 * User: newSalton@outlook.com
 * Date: 2019/1/22 21:36
 * ModifyTime: 21:36
 * Description:
 */
class BrowserPageComp : BaseSupportFragment() {

    companion object {
        @JvmStatic
        fun newInstance(): BrowserPageComp {
            val args = Bundle()
            val fragment = BrowserPageComp()
            fragment.arguments = args
            return fragment
        }
    }

    private val mAdapter: BrowserPageAdapter by lazy { BrowserPageAdapter(context) }
    override fun getLayout(): Int = R.layout.comp_browser_page

    override fun initVariable(savedInstanceState: Bundle?) {

    }

    override fun initViewAndData() {
        mRecyclerView.adapter = mAdapter
        mRecyclerView.layoutManager = LinearLayoutManager(_mActivity)
        var datas = ArrayList<IBrowserType>()
        datas.add(RecommendItem("https://www.baidu.com/"))
        datas.add(BannerItem(R.mipmap.bg_banner))
        mAdapter.datas = datas
        mAdapter.notifyDataSetChanged()
        OverScrollDecoratorHelper.setUpOverScroll(mRecyclerView, OverScrollDecoratorHelper.ORIENTATION_VERTICAL);
    }
}