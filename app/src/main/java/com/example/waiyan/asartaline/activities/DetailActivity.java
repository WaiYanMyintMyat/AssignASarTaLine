package com.example.waiyan.asartaline.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.waiyan.asartaline.R;
import com.example.waiyan.asartaline.data.model.ASarTaLineModel;
import com.example.waiyan.asartaline.data.vos.GetWarDeeVO;
import com.example.waiyan.asartaline.utils.ASarTaLineConstants;
import com.example.waiyan.asartaline.utils.GlideApp;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {
    @BindView(R.id.iv_cover)
    ImageView ivCover;

    @BindView(R.id.tv_detail_title)
    TextView tvDetailTitle;

    @BindView(R.id.tv_cost)
    TextView tvCost;

    @BindView(R.id.tv_description)
    TextView tvDescription;

    private GetWarDeeVO getWarDeeVO;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this, this);
        String warDeeId = getIntent().getStringExtra(ASarTaLineConstants.WAR_DEE_ID);
        getWarDeeVO = ASarTaLineModel.getObjInstance().getWarDeeById(warDeeId);

        GlideApp.with(DetailActivity.this)
                .load(getWarDeeVO.getImages().get(0))
                .placeholder(R.drawable.restaurant)
                .error(R.drawable.restaurant)
                .into(ivCover);
        tvDetailTitle.setText(getWarDeeVO.getName());
        tvCost.setText("$"+getWarDeeVO.getPriceRangeMax());
        tvDescription.setText(getWarDeeVO.getGeneralTaste().get(0).getTasteDesc());
    }
}
