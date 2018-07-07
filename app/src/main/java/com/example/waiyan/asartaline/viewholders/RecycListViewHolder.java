package com.example.waiyan.asartaline.viewholders;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.waiyan.asartaline.R;
import com.example.waiyan.asartaline.adapters.RestaurantAdapter;
import com.example.waiyan.asartaline.delegates.RestaurantDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycListViewHolder extends BaseRestaurantViewHolder{
    @BindView(R.id.rv_restaurant)
    RecyclerView rvRestaurant;

    private RestaurantAdapter restaurantAdapter;
    private RestaurantDelegate mrestaurantDelegate;

    public RecycListViewHolder(View itemView,RestaurantDelegate restaurantDelegate) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        mrestaurantDelegate=restaurantDelegate;

        rvRestaurant.setLayoutManager(new LinearLayoutManager(itemView.getContext(),
                LinearLayoutManager.VERTICAL,
                false));
        restaurantAdapter=new RestaurantAdapter(mrestaurantDelegate);
        rvRestaurant.setAdapter(restaurantAdapter);
    }

}
