package com.salton123.cargo.browser

/**
 * User: newSalton@outlook.com
 * Date: 2019/1/22 21:40
 * ModifyTime: 21:40
 * Description:
 */
interface IBrowserType {
}

data class RecommendItem(var url: String) : IBrowserType
data class BannerItem(var resId: Int) : IBrowserType