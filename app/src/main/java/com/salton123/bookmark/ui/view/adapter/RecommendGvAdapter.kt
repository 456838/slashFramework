package com.salton123.bookmark.ui.view.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide
import com.salton123.adapter.base.ViewHolder
import com.salton123.adapter.recyclerview.CommonRvAdapter
import com.salton123.adapter.recyclerview.MultiRvAdapter
import com.salton123.base.bus.EventFactory
import com.salton123.bookmark.R


/**
 * User: newSalton@outlook.com
 * Date: 2019/1/24 11:50 AM
 * ModifyTime: 11:50 AM
 * Description:
 */
class RecommendGvAdapter(context: Context) :
    CommonRvAdapter<RecommendGvItem>(context, R.layout.adapter_item_browser_recommend_gv) {
    override fun convert(holder: ViewHolder, entity: RecommendGvItem, position: Int) {
        Glide.with(holder.itemView).load(entity.iconUrl).into(holder.getView(R.id.ivIcon))
        holder.setText(R.id.tvTitle, entity.name + "")
        setOnItemClickListener(object : MultiRvAdapter.OnItemClickListener {
            override fun onItemLongClick(view: View?, holder: RecyclerView.ViewHolder?, position: Int): Boolean = true

            override fun onItemClick(view: View?, holder: RecyclerView.ViewHolder?, position: Int) {
                EventFactory.sendEvent("hello")
            }
        })
    }
}