package com.salton123.base.util;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Field;

/**
 * User: newSalton@outlook.com
 * Date: 2019/1/9 3:03 PM
 * ModifyTime: 3:03 PM
 * Description:
 */
public class ViewUtil {
    public static void setViewWidth(View targetView, int width) {
        if (targetView == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = targetView.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        layoutParams.width = width;
        targetView.setLayoutParams(layoutParams);
    }

    public static void setViewHeight(View targetView, int height) {
        if (targetView == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = targetView.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        layoutParams.height = height;
        targetView.setLayoutParams(layoutParams);
    }

    public static void setViewWidthHeight(View targetView, int width, int height) {
        if (targetView == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = targetView.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        layoutParams.width = width;
        layoutParams.height = height;
        targetView.setLayoutParams(layoutParams);
    }

    /**
     * 获取状态栏高度
     *
     * @return 状态栏高度
     */
    public static int getStatusBarHeight() {
        Class<?> c;
        Object obj;
        Field field;
        int statusBarHeight = 0;
        try {
            c = Class.forName("com.android.internal.R$dimen");
            obj = c.newInstance();
            field = c.getField("status_bar_height");
            int x = Integer.parseInt(field.get(obj).toString());
            statusBarHeight = Resources.getSystem().getDimensionPixelSize(x);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusBarHeight;
    }

}
