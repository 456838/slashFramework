package com.salton123.bookmark.ui.view.adapter

import android.content.Context
import com.salton123.adapter.recyclerview.MultiRvAdapter
import com.salton123.cargo.browser.RecommendItemViewDelegate

/**
 * User: newSalton@outlook.com
 * Date: 2019/1/22 21:39
 * ModifyTime: 21:39
 * Description:
 */
class BrowserPageAdapter(context: Context)
    : MultiRvAdapter<IBrowserType>(context) {
    init {
        addItemViewDelegate(RecommendItemViewDelegate())
        addItemViewDelegate(BannerItemViewDelegate())
    }
}