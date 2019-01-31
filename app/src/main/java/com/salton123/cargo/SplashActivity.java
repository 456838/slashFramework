package com.salton123.cargo;

import android.os.Bundle;
import android.view.View;

import com.gyf.barlibrary.ImmersionBar;
import com.opensource.svgaplayer.SVGACallback;
import com.opensource.svgaplayer.SVGADrawable;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAPlayer;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.salton123.base.BaseSupportActivity;
import com.salton123.base.feature.ImmersionFeature;
import com.salton123.base.feature.PermissionFeature;
import com.salton123.cargo.ui.activity.MainActivity;

/**
 * User: newSalton@outlook.com
 * Date: 2018/12/27 11:54 AM
 * ModifyTime: 11:54 AM
 * Description:
 */
public class SplashActivity extends BaseSupportActivity {
    private SVGAPlayer mSvgaPlayer;

    @Override
    public int getLayout() {
        return R.layout.aty_splash;
    }

    @Override
    public void initVariable(Bundle bundle) {
        addFeature(new ImmersionFeature(this) {
            @Override
            public ImmersionBar getImmersionBar() {
                return super.getImmersionBar().statusBarDarkFont(false);
            }
        });
        addFeature(new PermissionFeature(this));
    }

    @Override
    public void initViewAndData() {
        mSvgaPlayer = f(R.id.svgaPlayer);
        mSvgaPlayer.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        SVGAParser parser = new SVGAParser(getApplicationContext());
        parser.parse("ani/82.svga", new SVGAParser.ParseCompletion() {
            @Override
            public void onComplete(SVGAVideoEntity svgaVideoEntity) {
                SVGADrawable drawable = new SVGADrawable(svgaVideoEntity);
                mSvgaPlayer.setImageDrawable(drawable);
                mSvgaPlayer.startAnimation();
            }

            @Override
            public void onError() {

            }
        });
        mSvgaPlayer.setCallback(new SVGACallback() {
            @Override
            public void onPause() {

            }

            @Override
            public void onFinished() {
                openActivity(MainActivity.class, new Bundle());
                finish();
            }

            @Override
            public void onRepeat() {

            }

            @Override
            public void onStep(int i, double v) {

            }
        });
    }

}
