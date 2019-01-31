package com.salton123.cargo.browser

import com.bumptech.glide.Glide
import com.salton123.adapter.base.ItemViewDelegate
import com.salton123.adapter.base.ViewHolder
import com.salton123.cargo.R

/**
 * User: newSalton@outlook.com
 * Date: 2019/1/22 21:56
 * ModifyTime: 21:56
 * Description:
 */

class BannerItemViewDelegate : ItemViewDelegate<IBrowserType> {
    override fun isForViewType(item: IBrowserType?, position: Int): Boolean {
        return item is BannerItem
    }

    override fun getItemViewLayoutId(): Int = R.layout.adapter_item_browser_banner

    override fun convert(holder: ViewHolder?, t: IBrowserType?, position: Int) {
        if (t is BannerItem) {
            holder?.let {
                Glide.with(it.convertView)
                        .load(t?.resId)
                        .into(it.getView(R.id.ivBanner))
            }
        }
    }
}