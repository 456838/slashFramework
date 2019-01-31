package com.salton123.cargo.ui.fragment.fourth;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;

import com.salton123.cargo.R;
import com.salton123.cargo.ui.fragment.BaseMainFragment;
import com.salton123.cargo.ui.fragment.fourth.child.AvatarFragment;
import com.salton123.cargo.ui.fragment.fourth.child.MeFragment;

public class ZhihuFourthFragment extends BaseMainFragment {
    private Toolbar mToolbar;

    public static ZhihuFourthFragment newInstance() {
        Bundle args = new Bundle();
        ZhihuFourthFragment fragment = new ZhihuFourthFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayout() {
        return R.layout.zhihu_fragment_fourth;
    }

    @Override
    public void initVariable(Bundle bundle) {

    }

    @Override
    public void initViewAndData() {

    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        if (findChildFragment(AvatarFragment.class) == null) {
            loadFragment();
        }

        mToolbar = (Toolbar) f(R.id.toolbar);
        mToolbar.setTitle(R.string.me);
    }

    private void loadFragment() {
        loadRootFragment(R.id.fl_fourth_container_upper, AvatarFragment.newInstance());
        loadRootFragment(R.id.fl_fourth_container_lower, MeFragment.newInstance());
    }

    public void onBackToFirstFragment() {
        _mBackToFirstListener.onBackToFirstFragment();
    }


}
