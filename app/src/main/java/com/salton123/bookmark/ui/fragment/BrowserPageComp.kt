package com.salton123.bookmark.ui.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.salton123.base.BaseSupportFragment
import com.salton123.bookmark.R
import com.salton123.bookmark.ui.view.adapter.BannerItem
import com.salton123.bookmark.ui.view.adapter.BrowserPageAdapter
import com.salton123.bookmark.ui.view.adapter.IBrowserType
import com.salton123.bookmark.ui.view.adapter.RecommendGvItem
import com.salton123.bookmark.ui.view.adapter.RecommendItem

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
        var mGvList: List<RecommendGvItem> = mutableListOf(
            RecommendGvItem("https://www.baidu.com/", "https://www.baidu.com/" + "/favicon.ico", "百度"),
            RecommendGvItem("https://3g.163.com", "https://3g.163.com" + "/favicon.ico", "网易"),
            RecommendGvItem("https://sina.cn", "https://sina.cn/favicon.ico", "新浪"),
            RecommendGvItem("http://m.sohu.com", "http://m.sohu.com" + "/favicon.ico", "搜狐"),
            RecommendGvItem("https://3g.china.com", "https://3g.china.com" + "/favicon.ico", "中华"),
            RecommendGvItem("https://h5.m.taobao.com", "https://h5.m.taobao.com" + "/favicon.ico", "淘宝"),
            RecommendGvItem("https://i.ifeng.com/", "https://i.ifeng.com/" + "/favicon.ico", "凤凰"),
            RecommendGvItem("https://xw.qq.com/", "https://mat1.gtimg.com/www/icon/favicon2.ico", "腾讯"),
            RecommendGvItem("https://m.weibo.cn/", "https://m.weibo.cn/" + "/favicon.ico", "微博")
        )
        datas.add(RecommendItem(mGvList))
        datas.add(BannerItem(R.mipmap.bg_banner))
        mAdapter.datas = datas
        mAdapter.notifyDataSetChanged()
        OverScrollDecoratorHelper.setUpOverScroll(mRecyclerView, OverScrollDecoratorHelper.ORIENTATION_VERTICAL);
    }
}