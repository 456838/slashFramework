package com.salton123.cargo.ui.fragment.first;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.salton123.cargo.R;
import com.salton123.cargo.ui.fragment.BaseMainFragment;
import com.salton123.cargo.ui.fragment.first.child.FirstHomeFragment;

public class ZhihuFirstFragment extends BaseMainFragment {

    public static ZhihuFirstFragment newInstance() {
        Bundle args = new Bundle();
        ZhihuFirstFragment fragment = new ZhihuFirstFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        if (findChildFragment(FirstHomeFragment.class) == null) {
            loadRootFragment(R.id.fl_first_container, FirstHomeFragment.newInstance());
        }
    }

    @Override
    public int getLayout() {
        return R.layout.zhihu_fragment_first;
    }

    @Override
    public void initVariable(Bundle bundle) {

    }

    @Override
    public void initViewAndData() {

    }
}
