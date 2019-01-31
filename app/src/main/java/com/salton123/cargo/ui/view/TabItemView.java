package com.salton123.cargo.ui.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.OnCompositionLoadedListener;
import com.salton123.cargo.R;


public class TabItemView extends FrameLayout {


    private LottieAnimationView iconView;
    private TextView mTabTv;
    private TextView redPointTv;
    private int mNormalIconRes;
    private int mSelectIconRes;
    private String mNormalJsonRes;
    private String mPressJsonRes;
    private final static String JSON_FOLDER = "images/tab_icon";
    private static final String CANCEL_ANIM_TAG = "cancel_anim";

    public static TabItemView getTabItemView(Context context) {
        return (TabItemView) LayoutInflater.from(context).inflate(R.layout.widget_tab_item_layout, null);
    }

    public TabItemView(Context context) {
        this(context, null);
    }

    public TabItemView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TabItemView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        initViews();
    }

    public void setTabText(String text) {
        mTabTv.setText(text);
    }


    private void initViews() {
        iconView = (LottieAnimationView) findViewById(R.id.tab_icon_view);
        redPointTv = (TextView) findViewById(R.id.tab_red_point_tv);
        mTabTv = (TextView) findViewById(R.id.tab_tv);
    }

    public void setIconView(int normalRes, int selectIconRes, String normalJson, String selectJson) {
        mNormalIconRes = normalRes;
        mSelectIconRes = selectIconRes;
        mNormalJsonRes = normalJson;
        mPressJsonRes = selectJson;

    }

    private int res;


    private void setIconView(boolean isCheck, boolean isLast) {
        if (isCheck) {
            String json = mPressJsonRes;
            res = mSelectIconRes;
            if (isLast) {
                json = mNormalJsonRes;
                res = mNormalIconRes;
            }
            try {
                iconView.setTag(null);
                iconView.setImageAssetsFolder(JSON_FOLDER);
                LottieComposition.Factory.fromAssetFileName(getContext(), json,
                        new OnCompositionLoadedListener() {
                            @Override
                            public void onCompositionLoaded(@Nullable LottieComposition composition) {
                                if (composition == null ||
                                        (composition.hasImages() && TextUtils.isEmpty(iconView.getImageAssetsFolder()))) {
                                    iconView.setImageResource(res);
                                    return;
                                }
                                String tag = (String) iconView.getTag();
                                if (!TextUtils.isEmpty(tag) && tag.equals(CANCEL_ANIM_TAG)) {   //此处用户点击过快 ，动画已取消
                                    iconView.setImageResource(mNormalIconRes);
                                    return;
                                }
                                iconView.setProgress(0);
                                iconView.setComposition(composition);
                                iconView.playAnimation();
                            }
                        });
            } catch (Exception e) {
                iconView.setImageResource(res);
            }

        } else {

            iconView.setTag(CANCEL_ANIM_TAG);      //fromAssetFileName 为异步，防止用户双手点击过快，引起图标设置出错
            if (iconView.isAnimating()) {
                iconView.cancelAnimation();
            }
            iconView.clearAnimation();
            iconView.setImageResource(mNormalIconRes);
        }
    }

    public void setIsSelect(boolean isAnim, boolean isLast) {
        setIconView(isAnim, isLast);
    }

    public void setRedPointNum(int num) {
        redPointTv.setVisibility(View.VISIBLE);
        redPointTv.setText(num > 99 ? "99+" : String.valueOf(num));
    }

    public void hideRedPoint() {
        redPointTv.setVisibility(View.GONE);
    }
}
