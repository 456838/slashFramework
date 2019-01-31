package com.salton123.bookmark.ui.view.adapter

/**
 * User: newSalton@outlook.com
 * Date: 2019/1/22 21:40
 * ModifyTime: 21:40
 * Description:
 */
interface IBrowserType

data class RecommendItem(var gvItem: List<RecommendGvItem>) : IBrowserType
data class RecommendGvItem(var url: String, var iconUrl: String, var name: String) : IBrowserType
data class BannerItem(var resId: Int) : IBrowserType