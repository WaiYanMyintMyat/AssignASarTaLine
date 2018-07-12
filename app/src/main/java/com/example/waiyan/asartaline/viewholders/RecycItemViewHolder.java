package com.example.waiyan.asartaline.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.request.RequestOptions;
import com.example.waiyan.asartaline.R;
import com.example.waiyan.asartaline.data.vos.GetWarDeeVO;
import com.example.waiyan.asartaline.delegates.RestaurantDelegate;
import com.example.waiyan.asartaline.utils.GlideApp;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycItemViewHolder extends BaseRestaurantViewHolder {

    @BindView(R.id.tv_recycy_item_title)
    TextView tvRecycItemTitle;

    @BindView(R.id.tv_country)
    TextView tvCountry;

    @BindView(R.id.iv_recyc_item)
    ImageView ivRecycItem;

    @BindView(R.id.tv_cost)
    TextView tvCost;

    private RestaurantDelegate mrestaurantDelegate;
    private GetWarDeeVO mGetWarDeeVO;

    public RecycItemViewHolder(View itemView,RestaurantDelegate restaurantDelegate) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        mrestaurantDelegate=restaurantDelegate;

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mrestaurantDelegate.onTapRestaurant(mGetWarDeeVO);
            }
        });
    }

    @Override
    public void bindData(GetWarDeeVO getWarDeeVO) {
        super.bindData(getWarDeeVO);
        mGetWarDeeVO=getWarDeeVO;
        tvRecycItemTitle.setText(mGetWarDeeVO.getName());
        tvCountry.setText(mGetWarDeeVO.getGeneralTaste().get(0).getTaste());
        GlideApp.with(ivRecycItem.getContext())
                .load(mGetWarDeeVO.getImages().get(0))
                .placeholder(R.drawable.restaurant)
                .error(R.drawable.restaurant)
                .into(ivRecycItem);
        tvCost.setText("Cost "+mGetWarDeeVO.getPriceRangeMin()+"Ks - "+mGetWarDeeVO.getPriceRangeMax()+"Ks for one");
    }
}
