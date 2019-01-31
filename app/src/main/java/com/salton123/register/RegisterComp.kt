package com.salton123.register

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.view.View
import cn.bmob.v3.exception.BmobException
import cn.bmob.v3.listener.SaveListener
import com.salton123.base.BaseSupportFragment
import com.salton123.base.feature.PermissionFeature
import com.salton123.callback.SingleClickListener
import com.salton123.cargo.R
import com.salton123.log.XLog
import com.salton123.register.model.AgentInfo
import kotlinx.android.synthetic.main.comp_register.*


class RegisterComp : BaseSupportFragment() {

    internal var count = 0
    override fun getLayout(): Int = R.layout.comp_register

    override fun initVariable(savedInstanceState: Bundle?) {
//        addFeature(PermissionFeature(_mActivity as AppCompatActivity))
    }

    override fun initViewAndData() {
        imageView.setOnTouchListener(object : OnSwipeTouchListener(_mActivity) {
            override fun onSwipeTop() {}

            override fun onSwipeRight() {
                if (count == 0) {
                    imageView.setImageResource(R.drawable.good_night_img)
                    textView.text = "Night"
                    count = 1
                } else {
                    imageView.setImageResource(R.drawable.good_morning_img)
                    textView.text = "Morning"
                    count = 0
                }
            }

            override fun onSwipeLeft() {
                if (count == 0) {
                    imageView.setImageResource(R.drawable.good_night_img)
                    textView.text = "Night"
                    count = 1
                } else {
                    imageView.setImageResource(R.drawable.good_morning_img)
                    textView.text = "Morning"
                    count = 0
                }
            }

            override fun onSwipeBottom() {}

        })
        etLevelFirstRegion.setText("山西太原")
        etLevelSecondRegion.setText("尖草坪区太工分部")
        etAgentName.setText("桃太郎")
        etPhoneNum.setText("15388517136")
        etShopName.setText("哈喽时尚营业厅")
        etShopType.setText("私营")
    }

    override fun initListener() {
        btnSubmit.setOnClickListener(object : SingleClickListener(1000) {
            override fun onSingleClick(v: View) {
                btnSubmit.isClickable = false
                var info = AgentInfo()
                info.levelFirstRegion = etLevelFirstRegion.text.toString()
                info.levelSecondRegion = etLevelSecondRegion.text.toString()
                info.agentName = etAgentName.text.toString()
                info.phoneNum = etPhoneNum.text.toString()
                info.shopName = etShopName.text.toString()
                info.shopType = etShopType.text.toString()
                info.save(object : SaveListener<String>() {
                    override fun done(p0: String?, p1: BmobException?) {
                        if (TextUtils.isEmpty(p0)) {
                            btnSubmit.isClickable = true
                        } else {
                            longToast("数据已提交")
                        }
                        XLog.i(this, "[done] $p0:$p1")
                    }
                })
            }
        })
    }

}
