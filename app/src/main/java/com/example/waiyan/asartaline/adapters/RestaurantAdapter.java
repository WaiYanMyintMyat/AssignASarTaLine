package com.example.waiyan.asartaline.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.waiyan.asartaline.R;
import com.example.waiyan.asartaline.delegates.RestaurantDelegate;
import com.example.waiyan.asartaline.viewholders.BaseRestaurantViewHolder;
import com.example.waiyan.asartaline.viewholders.RecycItemViewHolder;

public class RestaurantAdapter extends RecyclerView.Adapter<BaseRestaurantViewHolder> {

    private RestaurantDelegate mrestaurantDelegate;
    public RestaurantAdapter(RestaurantDelegate restaurantDelegate) {
        mrestaurantDelegate=restaurantDelegate;
    }

    @NonNull
    @Override
    public BaseRestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_recyc_item,parent,false);
        return new RecycItemViewHolder(view,mrestaurantDelegate);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseRestaurantViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;//There is a error...
    }
}
