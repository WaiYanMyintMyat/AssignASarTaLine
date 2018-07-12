package com.example.waiyan.asartaline.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.waiyan.asartaline.R;
import com.example.waiyan.asartaline.data.vos.GetWarDeeVO;
import com.example.waiyan.asartaline.delegates.RestaurantDelegate;
import com.example.waiyan.asartaline.viewholders.BaseRestaurantViewHolder;
import com.example.waiyan.asartaline.viewholders.RecycItemViewHolder;

import java.util.ArrayList;
import java.util.List;

public class RestaurantAdapter extends RecyclerView.Adapter<BaseRestaurantViewHolder> {

    private RestaurantDelegate mrestaurantDelegate;
    private List<GetWarDeeVO> mGetWarDeeList;

    public RestaurantAdapter(RestaurantDelegate restaurantDelegate) {
        mrestaurantDelegate=restaurantDelegate;
        mGetWarDeeList=new ArrayList<>();
    }

    @NonNull
    @Override
    public BaseRestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_recyc_item,parent,false);
        return new RecycItemViewHolder(view,mrestaurantDelegate);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseRestaurantViewHolder holder, int position) {
        holder.bindData(mGetWarDeeList.get(position));
    }

    @Override
    public int getItemCount() {
        return mGetWarDeeList.size();
    }

    public void setNewWarDeeList(List<GetWarDeeVO> getWarDeeList) {
        mGetWarDeeList=getWarDeeList;
        notifyDataSetChanged();
    }
}
