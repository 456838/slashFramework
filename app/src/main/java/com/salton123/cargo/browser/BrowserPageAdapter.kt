package com.salton123.cargo.browser

import android.content.Context
import com.salton123.adapter.recyclerview.MultiRvAdapter

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