package com.salton123.cargo.browser

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.hjq.bar.TitleBar
import com.salton123.adapter.base.ItemViewDelegate
import com.salton123.adapter.base.ViewHolder
import com.salton123.bookmark.R
import com.salton123.bookmark.ui.view.adapter.IBrowserType
import com.salton123.bookmark.ui.view.adapter.RecommendGvAdapter
import com.salton123.bookmark.ui.view.adapter.RecommendItem

/**
 * User: newSalton@outlook.com
 * Date: 2019/1/22 21:56
 * ModifyTime: 21:56
 * Description:
 */

class RecommendItemViewDelegate : ItemViewDelegate<IBrowserType> {

    override fun isForViewType(item: IBrowserType?, position: Int): Boolean {
        return item is RecommendItem
    }

    override fun getItemViewLayoutId(): Int = R.layout.adapter_item_browser_recommend

    override fun convert(holder: ViewHolder?, t: IBrowserType?, position: Int) {
        if (t is RecommendItem) {
            holder?.let {
                val mGvAdapter by lazy { RecommendGvAdapter(it.convertView.context) }
                var recyclerView = it.getView<RecyclerView>(R.id.gvRecommend)
                recyclerView.adapter = mGvAdapter
                recyclerView.layoutManager = GridLayoutManager(it.convertView.context, 5)
                mGvAdapter.addAll(t.gvItem)
                var titleBar = it.getView<TitleBar>(R.id.titleBar)
                titleBar.leftView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null)
                titleBar.leftView.isEnabled = false
                titleBar.leftView.isClickable = false
                titleBar.rightView.setOnClickListener {
                    Toast.makeText(it.context, "more", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}