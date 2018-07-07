package com.example.waiyan.asartaline.viewholders;

import android.view.View;

import com.example.waiyan.asartaline.delegates.RestaurantDelegate;

public class RecycItemViewHolder extends BaseRestaurantViewHolder {
    private RestaurantDelegate mrestaurantDelegate;
    public RecycItemViewHolder(View itemView,RestaurantDelegate restaurantDelegate) {
        super(itemView);
        mrestaurantDelegate=restaurantDelegate;

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mrestaurantDelegate.onTapRestaurant();
            }
        });
    }
}
