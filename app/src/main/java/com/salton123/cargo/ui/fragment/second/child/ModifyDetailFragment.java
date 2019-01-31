package com.salton123.cargo.ui.fragment.second.child;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hjq.bar.TitleBar;
import com.salton123.base.BaseSupportFragment;
import com.salton123.cargo.R;
import com.salton123.cargo.ui.fragment.CycleFragment;


public class ModifyDetailFragment extends BaseSupportFragment {
    private static final String ARG_TITLE = "arg_title";

    private TitleBar mToolbar;
    private EditText mEtModiyTitle;
    private Button mBtnModify, mBtnNext;

    private String mTitle;

    public static ModifyDetailFragment newInstance(String title) {
        Bundle args = new Bundle();
        ModifyDetailFragment fragment = new ModifyDetailFragment();
        args.putString(ARG_TITLE, title);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public int getLayout() {
        return R.layout.fragment_modify_detail;
    }

    @Override
    public void initVariable(Bundle bundle) {
        Bundle args = getArguments();
        if (args != null) {
            mTitle = args.getString(ARG_TITLE);
        }
    }

    @Override
    public void initViewAndData() {
        mToolbar =  f(R.id.toolbar);
        mEtModiyTitle = (EditText) f(R.id.et_modify_title);
        mBtnModify = (Button) f(R.id.btn_modify);
        mBtnNext = (Button) f(R.id.btn_next);

        mToolbar.setTitle(R.string.start_result_test);
        mEtModiyTitle.setText(mTitle);
        // 显示 软键盘
//        showSoftInput(mEtModiyTitle);
    }

    @Override
    public void initListener() {
        mBtnModify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString(DetailFragment.KEY_RESULT_TITLE, mEtModiyTitle.getText().toString());
                setFragmentResult(RESULT_OK, bundle);

                Toast.makeText(_mActivity, R.string.modify_success, Toast.LENGTH_SHORT).show();
            }
        });
        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start(CycleFragment.newInstance(1));
            }
        });
    }

    @Override
    public void onSupportInvisible() {
        super.onSupportInvisible();
        hideSoftInput();
    }
}
