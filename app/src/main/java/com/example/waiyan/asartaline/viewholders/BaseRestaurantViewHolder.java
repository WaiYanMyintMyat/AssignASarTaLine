package com.example.waiyan.asartaline.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.waiyan.asartaline.data.vos.GetWarDeeVO;

public abstract class BaseRestaurantViewHolder extends RecyclerView.ViewHolder {
    public BaseRestaurantViewHolder(View itemView) {
        super(itemView);
    }

    public void bindData(GetWarDeeVO getWarDeeVO) {
    }
}
