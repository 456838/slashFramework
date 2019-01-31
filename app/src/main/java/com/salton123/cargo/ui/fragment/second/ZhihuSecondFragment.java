package com.salton123.cargo.ui.fragment.second;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.salton123.base.FragmentDelegate;
import com.salton123.cargo.R;
import com.salton123.cargo.ui.fragment.BaseMainFragment;
import com.salton123.cargo.ui.fragment.second.child.DetailFragment;
import com.salton123.cargo.ui.fragment.second.child.ViewPagerFragment;
import com.salton123.register.RegisterComp;


public class ZhihuSecondFragment extends BaseMainFragment {

    public static ZhihuSecondFragment newInstance() {

        Bundle args = new Bundle();

        ZhihuSecondFragment fragment = new ZhihuSecondFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayout() {
        return R.layout.zhihu_fragment_second;
    }

    @Override
    public void initVariable(Bundle bundle) {

    }

    @Override
    public void initViewAndData() {

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (findChildFragment(RegisterComp.class) == null) {
            loadRootFragment(R.id.fl_second_container, FragmentDelegate.newInstance(RegisterComp.class));
        }
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        // 这里可以不用懒加载,因为Adapter的场景下,Adapter内的子Fragment只有在父Fragment是show状态时,才会被Attach,Create
    }
}
