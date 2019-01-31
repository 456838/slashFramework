package com.salton123.cargo.feature

import android.annotation.SuppressLint
import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.salton123.base.feature.IFeature
import com.salton123.log.XLog

/**
 * User: newSalton@outlook.com
 * Date: 2018/12/25 4:59 PM
 * ModifyTime: 4:59 PM
 * Description:
 */
@SuppressLint("ValidFragment")
class AccelerometerFeature(private val mActivity: AppCompatActivity) : Fragment(), IFeature, SensorEventListener {

    override fun onBind() {

    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

    }

    override fun onUnBind() {

    }

    override fun onSensorChanged(event: SensorEvent) {
        val type = event.sensor.type
        when (type) {
            Sensor.TYPE_ACCELEROMETER -> {
                val values = event.values
                val xValue = values[0]
                val yValue = values[1]
                val zValue = values[2]
                XLog.i(this, "xValue=$xValue,yValue=$yValue,zValue=$zValue")
            }
        }
    }

    override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {

    }
}
