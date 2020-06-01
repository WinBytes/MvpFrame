package com.rain.mvpframe.ui;



import com.rain.mvpframe.R;
import com.rain.mvpframe.base.BaseActivity;
import com.rain.mvpframe.base.BasePresenter;

public class MainActivity extends BaseActivity {


    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int setContentView() {
        return R.layout.activity_main;
    }
}
