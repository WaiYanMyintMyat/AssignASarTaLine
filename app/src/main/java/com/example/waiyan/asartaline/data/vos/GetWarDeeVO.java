package com.example.waiyan.asartaline.data.vos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetWarDeeVO {
    @SerializedName("warDeeId")
    private String warDeeId;

    @SerializedName("name")
    private String name;

    @SerializedName("images")
    private List<String> images;

    @SerializedName("generalTaste")
    private List<GeneralTasteVO> generalTaste;

    @SerializedName("suitedFor")
    private List<SuitedForVO> suitedFor;

    @SerializedName("priceRangeMin")
    private int priceRangeMin;

    @SerializedName("priceRangeMax")
    private int priceRangeMax;

    @SerializedName("matchWarDeeList")
    private List<MatchWarDeeVO> matchWarDeeList;

    @SerializedName("shopByDistance")
    private List<ShopByDistanceVO> shopByDistanceList;

    @SerializedName("shopByPopularity")
    private List<ShopByPopularityVO> shopByPopularityList;

    public String getWarDeeId() {
        return warDeeId;
    }

    public String getName() {
        return name;
    }

    public List<String> getImages() {
        return images;
    }

    public List<GeneralTasteVO> getGeneralTaste() {
        return generalTaste;
    }

    public List<SuitedForVO> getSuitedFor() {
        return suitedFor;
    }

    public int getPriceRangeMin() {
        return priceRangeMin;
    }

    public int getPriceRangeMax() {
        return priceRangeMax;
    }

    public List<MatchWarDeeVO> getMatchWarDeeList() {
        return matchWarDeeList;
    }

    public List<ShopByDistanceVO> getShopByDistanceList() {
        return shopByDistanceList;
    }

    public List<ShopByPopularityVO> getShopByPopularityList() {
        return shopByPopularityList;
    }
}
