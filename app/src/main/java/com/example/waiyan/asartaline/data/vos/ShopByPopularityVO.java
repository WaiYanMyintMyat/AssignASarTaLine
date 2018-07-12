package com.example.waiyan.asartaline.data.vos;

import com.google.gson.annotations.SerializedName;

public class ShopByPopularityVO {
    @SerializedName("shopByPopularityId")
    private String shopByPopularityId;

    @SerializedName("mealShop")
    private MealShopVO mealShopVO;

    public String getShopByPopularityId() {
        return shopByPopularityId;
    }

    public MealShopVO getMealShopVO() {
        return mealShopVO;
    }
}
