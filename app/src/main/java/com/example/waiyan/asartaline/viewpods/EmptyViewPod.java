package com.example.waiyan.asartaline.viewpods;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.waiyan.asartaline.R;
import com.example.waiyan.asartaline.utils.GlideApp;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EmptyViewPod extends RelativeLayout{

    @BindView(R.id.iv_vp_empty)
    ImageView ivVpEmpty;

    @BindView(R.id.tv_vp_empty)
    TextView tvVpEmpty;

    public EmptyViewPod(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EmptyViewPod(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public EmptyViewPod(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this,this);
    }

    public void setEmptyData(String emptyImageUrl,String emptyMessage){
        GlideApp.with(getContext())
                .load(emptyImageUrl)
                .into(ivVpEmpty);
        tvVpEmpty.setText(emptyMessage);
    }

    public void setEmptyData(int emptyImageUrl,String emptyMessage){
        ivVpEmpty.setImageResource(emptyImageUrl);
        tvVpEmpty.setText(emptyMessage);
    }
}
