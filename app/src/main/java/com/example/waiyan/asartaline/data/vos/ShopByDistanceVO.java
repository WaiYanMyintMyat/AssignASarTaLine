package com.example.waiyan.asartaline.data.vos;

import com.google.gson.annotations.SerializedName;

public class ShopByDistanceVO {
    @SerializedName("shopByDistanceId")
    private String shopByDistanceId;

    @SerializedName("mealShop")
    private MealShopVO mealShopVO;

    @SerializedName("distanceInFeet")
    private double distanceInFeet;

    public String getShopByDistanceId() {
        return shopByDistanceId;
    }

    public MealShopVO getMealShopVO() {
        return mealShopVO;
    }

    public double getDistanceInFeet() {
        return distanceInFeet;
    }
}
