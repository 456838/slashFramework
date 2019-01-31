package com.salton123.register.model

import cn.bmob.v3.BmobObject

/**
 * User: newSalton@outlook.com
 * Date: 2019/1/31 14:09
 * ModifyTime: 14:09
 * Description:
 */
data class AgentInfo(
    var levelFirstRegion: String = "",
    var levelSecondRegion: String = "",
    var shopName: String = "",
    var shopType: String = "",
    var agentName: String = "",
    var phoneNum: String = ""
) : BmobObject()