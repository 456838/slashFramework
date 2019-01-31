package com.salton123.cargo.ui.view;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.salton123.cargo.R;
import com.salton123.util.ScreenUtils;

import java.util.ArrayList;
import java.util.List;


public class BottomTabWidget extends FrameLayout {

    private static final int[] TAB_ICON_NORMAL_RES = {R.mipmap.icon_tab_live_normal, R.mipmap.icon_tab_moment_normal, R.mipmap.icon_tab_live, R.mipmap.icon_tab_message_normal, R.mipmap.icon_tab_mine_normal};
    private static final int[] TAB_ICON_SELECT_RES = {R.mipmap.icon_tab_live_select, R.mipmap.icon_tab_moment_select, R.mipmap.icon_tab_live, R.mipmap.icon_tab_message_select, R.mipmap.icon_tab_mine_select};

    private static final String[] NORMAL_FILE = {"", "", "", "", ""};

    private static final String[] PRESS_FILE = {"animation/icon_tab_home_pre.json", "animation/icon_tab_moment_pre.json",
            "", "animation/icon_tab_msg_pre.json", "animation/icon_tab_me_pre.json"};

    private static final String[] TAB_NAME = {"偶遇", "瞬间", "", "消息", "我"};
    private static final String[] TAB_NAME_SELECT = {"偶遇", "瞬间", "", "消息", "我"};

    private int lastClickIndex = -1;

    private OnTabClickListener mListener;
    private List<TabItemView> mTabItemList = new ArrayList<>();


    public BottomTabWidget(@NonNull Context context) {
        this(context, null);
    }

    public BottomTabWidget(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BottomTabWidget(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setBackgroundColor(getResources().getColor(android.R.color.transparent));
        this.getBackground().setAlpha(100);
        initWidget();
    }
    //按顺序
    public static final int HOME = 0;
    public static final int MOMENT = 1;
    public static final int LIVE = 2;
    public static final int MESSAGE = 3;
    public static final int MINE = 4;

    private void initWidget() {
        addViewBgView();
        addTabItem();

    }

    private void addViewBgView() {
        View view = new View(getContext());
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT,
                getResources().getDimensionPixelSize(R.dimen.tab_item_bg_height));
        view.setBackgroundColor(Color.WHITE);
        params.gravity = Gravity.BOTTOM;
        addView(view, params);
    }


    private void addTabItem() {
        LinearLayout tabLayout = new LinearLayout(getContext());
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        tabLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));

        for (int i = 0; i < TAB_ICON_NORMAL_RES.length; i++) {
            final TabItemView tabItemView = TabItemView.getTabItemView(getContext());
            tabItemView.setIconView(TAB_ICON_NORMAL_RES[i], TAB_ICON_SELECT_RES[i], NORMAL_FILE[i], PRESS_FILE[i]);
            tabItemView.setTabText(TAB_NAME[i]);
            tabItemView.setIsSelect(false, false);
            tabItemView.setId(i);
            LinearLayout.LayoutParams itemParams = new LinearLayout.LayoutParams(0, LayoutParams.MATCH_PARENT);
            itemParams.weight = 1;
            itemParams.bottomMargin = ScreenUtils.dp2px(3);

            tabItemView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    responseOnclick(v.getId());
                }
            });
            mTabItemList.add(tabItemView);
            tabLayout.addView(tabItemView, itemParams);

        }
        addView(tabLayout, params);
    }

    public void setOnTabClickListener(OnTabClickListener listener) {
        mListener = listener;
    }

    public void responseOnclick(int index) {
        if (mListener != null && index >= 0 && index < TAB_ICON_NORMAL_RES.length) {
            mListener.onTabClick(lastClickIndex, index, index == lastClickIndex);
        }
        if (index == LIVE) {
            return;
        }
        if (lastClickIndex >= 0 && lastClickIndex < TAB_ICON_NORMAL_RES.length) {
            mTabItemList.get(lastClickIndex).setIsSelect(false, true);
            mTabItemList.get(lastClickIndex).setTabText(TAB_NAME[lastClickIndex]);
        }
        mTabItemList.get(index).setIsSelect(true, false);
        mTabItemList.get(index).setTabText(TAB_NAME_SELECT[index]);
        lastClickIndex = index;
    }

    public interface OnTabClickListener {
        void onTabClick(int lastClickIndex, int index, boolean isRepeatClick);
    }

    public void setUnReadCount(int count) {
        if (getChildCount() < 1) {
            return;
        }
        TabItemView layout = mTabItemList.get(MESSAGE);
        if (layout == null || layout.getChildCount() < 1) {
            return;
        }
        if (count > 0) {
            layout.setRedPointNum(count);
        } else {
            layout.hideRedPoint();
        }

    }


}
