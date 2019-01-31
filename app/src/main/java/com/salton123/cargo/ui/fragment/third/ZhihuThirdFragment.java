package com.salton123.cargo.ui.fragment.third;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.salton123.base.FragmentDelegate;
import com.salton123.cargo.R;
import com.salton123.cargo.ui.fragment.BaseMainFragment;
import com.salton123.cargo.ui.fragment.third.child.ShopFragment;

public class ZhihuThirdFragment extends BaseMainFragment {

    public static ZhihuThirdFragment newInstance() {
        Bundle args = new Bundle();
        ZhihuThirdFragment fragment = new ZhihuThirdFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayout() {
        return R.layout.zhihu_fragment_third;
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
        if (findChildFragment(ShopFragment.class) == null) {
            // ShopFragment是flow包里的
            loadRootFragment(R.id.fl_third_container,
                    FragmentDelegate.Companion.newInstance(ShopFragment.class));
        }
    }
}
