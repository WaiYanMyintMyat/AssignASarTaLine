package com.example.waiyan.asartaline.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.waiyan.asartaline.R;
import com.example.waiyan.asartaline.data.vos.GetWarDeeVO;
import com.example.waiyan.asartaline.delegates.RestaurantDelegate;
import com.example.waiyan.asartaline.viewholders.BaseRestaurantViewHolder;
import com.example.waiyan.asartaline.viewholders.CategoryViewHolder;
import com.example.waiyan.asartaline.viewholders.RecycItemViewHolder;
import com.example.waiyan.asartaline.viewholders.RecycListViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainRecyclerAdapter extends RecyclerView.Adapter<BaseRestaurantViewHolder> {

    private static final int VT_CATEGORY = 1000;
    private static final int VT_RECYCITEM = 2000;

    private RestaurantDelegate mrestaurantDelegate;
    private List<GetWarDeeVO> mGetWarDeeList;
    private RecycListViewHolder recycListViewHolder;

    public MainRecyclerAdapter(RestaurantDelegate restaurantDelegate) {
        mrestaurantDelegate=restaurantDelegate;
        mGetWarDeeList=new ArrayList<>();
    }

    @NonNull
    @Override
    public BaseRestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        if(viewType==VT_CATEGORY){
            View view=layoutInflater.inflate(R.layout.view_holder_category,parent,false);
            return new CategoryViewHolder(view);
        }else{
            View view=layoutInflater.inflate(R.layout.view_holder_recyclist,parent,false);
            recycListViewHolder=new RecycListViewHolder(view,mrestaurantDelegate);
            return recycListViewHolder;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull BaseRestaurantViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if(position==0){
            return VT_CATEGORY;
        }else{
            return VT_RECYCITEM;
        }
    }

    public void setNewWarDeeList(List<GetWarDeeVO> getWarDeeList){
        mGetWarDeeList=getWarDeeList;
        recycListViewHolder.setNewWarDeeList(mGetWarDeeList);
        //notifyDataSetChanged();
    }
}
