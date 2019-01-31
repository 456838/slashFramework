package com.salton123.cargo;

import com.salton123.base.ApplicationBase;

import cn.bmob.v3.Bmob;

/**
 * User: newSalton@outlook.com
 * Date: 2018/12/18 11:38 AM
 * ModifyTime: 11:38 AM
 * Description:
 */
public class XApp extends ApplicationBase {
    @Override
    public void onCreate() {
        super.onCreate();
        Bmob.initialize(this, "a774aaf487f9eb292b386cbc6f7c8dfa");
    }

    @Override
    public boolean highPriority() {

        return super.highPriority();
    }
}
