package com.salton123.cargo.ui.fragment.first.child;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.salton123.base.BaseSupportFragment;
import com.salton123.cargo.R;
import com.salton123.cargo.model.entity.Article;
import com.salton123.cargo.ui.fragment.CycleFragment;

public class FirstDetailFragment extends BaseSupportFragment {
    private static final String ARG_ITEM = "arg_item";

    private Article mArticle;

    private Toolbar mToolbar;
    private ImageView mImgDetail;
    private TextView mTvTitle;
    private FloatingActionButton mFab;

    public static FirstDetailFragment newInstance(Article article) {

        Bundle args = new Bundle();
        args.putParcelable(ARG_ITEM, article);
        FirstDetailFragment fragment = new FirstDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayout() {
        return R.layout.zhihu_fragment_first_detail;
    }

    @Override
    public void initVariable(Bundle bundle) {
        mArticle = getArguments().getParcelable(ARG_ITEM);
    }

    @Override
    public void initViewAndData() {
        mToolbar = (Toolbar) f(R.id.toolbar);
        mImgDetail = (ImageView) f(R.id.img_detail);
        mTvTitle = (TextView) f(R.id.tv_content);
        mFab = (FloatingActionButton) f(R.id.fab);

        mToolbar.setTitle("");
        mImgDetail.setImageResource(mArticle.getImgRes());
        mTvTitle.setText(mArticle.getTitle());

    }

    @Override
    public void initListener() {
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start(CycleFragment.newInstance(1));
            }
        });
    }
}
