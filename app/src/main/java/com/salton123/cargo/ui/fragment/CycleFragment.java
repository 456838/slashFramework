package com.salton123.cargo.ui.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hjq.bar.TitleBar;
import com.salton123.base.BaseSupportFragment;
import com.salton123.cargo.R;
import com.salton123.cargo.feature.ToolbarFeature;


public class CycleFragment extends BaseSupportFragment {
    private static final String ARG_NUMBER = "arg_number";

    private TitleBar mToolbar;
    private TextView mTvName;
    private Button mBtnNext, mBtnNextWithFinish;

    private int mNumber;

    public static CycleFragment newInstance(int number) {
        CycleFragment fragment = new CycleFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_NUMBER, number);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_cycle;
    }

    @Override
    public void initVariable(Bundle bundle) {
        addFeature(new ToolbarFeature(_mActivity));
        Bundle args = getArguments();
        if (args != null) {
            mNumber = args.getInt(ARG_NUMBER);
        }
    }

    @Override
    public void initViewAndData() {
        mToolbar = f(R.id.toolbar);
        mTvName = (TextView) f(R.id.tv_name);
        mBtnNext = (Button) f(R.id.btn_next);
        mBtnNextWithFinish = (Button) f(R.id.btn_next_with_finish);
        String title = "CyclerFragment " + mNumber;
        mToolbar.setTitle(title);
        mTvName.setText(title);
    }

    @Override
    public void initListener() {
        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start(CycleFragment.newInstance(mNumber + 1));
            }
        });
        mBtnNextWithFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startWithPop(CycleFragment.newInstance(mNumber + 1));
            }
        });
    }
}
